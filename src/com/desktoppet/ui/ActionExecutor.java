package com.desktoppet.ui;

import com.desktoppet.constant.Constant;
import com.desktoppet.img.ResourceGetter;
import com.desktoppet.state.TotalState;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;


/**
 * Description: Action Executor
 *
 * @author Shengliang Yu
 */
public class ActionExecutor {

    private final ImageView imageView = MainNode.getInstance().getImageView();
    private Action curAction;
    private final ResourceGetter resourceGetter = ResourceGetter.getInstance();
    private final ActionGenerator actionGenerator = new ActionGenerator();
    private static ActionExecutor actionExecutor;
    private Timeline timeline;

    public static ActionExecutor getInstance() {
        if (actionExecutor == null) actionExecutor = new ActionExecutor();
        return actionExecutor;
    }

    private ActionExecutor() {
    }

    public boolean execute(Action action) {
        // If the previous action cannot be interrupted, then the action execution fails
        if (curAction != null && !curAction.isInterruptable()) return false;
        Image actionImage = resourceGetter.get(action.getPath());
        imageView.setImage(actionImage);
        curAction = action;
        if (timeline != null) timeline.pause();
        // If the current action is temporary, it needs to be restored to a certain action
        if (action.isTemporaryAction()) {
            timeline = new Timeline(new KeyFrame(Duration.seconds(action.getTime()),
                    e -> executeContinuousInterruptableActionAction(action.getRecoverPath())));
            timeline.play();
        }
        return true;
    }

    public boolean executeClickAction() {
        boolean ok = actionGenerator.generateNewActionIndex();
        if (ok) {
            execute(Action.creatTemporaryInterruptableAction(
                    actionGenerator.getActionPath(),
                    Constant.UserInterface.ActionRunTime,
                    Constant.ImageShow.mainImage));
            // At the same time it will increase the mood value
            TotalState.getInstance().getEmotionState().increase();
        }
        return ok;
    }

    /**
     * Perform an interruptible, continuous action immediately
     */
    private void executeContinuousInterruptableActionAction(String path) {
        curAction = null;
        timeline = null;
        actionGenerator.close();
        Action action = Action.creatContinuousInterruptableAction(path);
        execute(action);
    }

}
