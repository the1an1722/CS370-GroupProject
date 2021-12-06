package com.desktoppet.ui;

import com.desktoppet.constant.Constant;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: Get a new interactive action and close the interactive action
 *
 * @author Shengliang Yu
 */
public class ActionGenerator {

    /**
     * Action id
     */
    private int actionIndex = NoAction;

    private static final Map<Integer, String> resource = new HashMap<Integer, String>() {{
        put(1, Constant.ImageShow.rotatingcupImage);
    }};
    private static final int MinIndex = 1;
    private static final int MaxIndex = 1;
    public static final int NoAction = 0;

    /**
     * Randomly generate an action number, here when the action number is not 0,
     * it means that the action has not ended yet
     *
     * @return If and only if the previous action is not over, return false and no new action will be generated
     */
    public boolean generateNewActionIndex() {
        if (actionIndex != NoAction) return false;
        actionIndex = (int) (Math.random() * (MaxIndex - MinIndex + 1) + MinIndex);
        return true;
    }

    /**
     * This API must be called when the action is finished.
     */
    public void close() {
        actionIndex = NoAction;
    }

    /**
     * Get the GIF resource of the action
     *
     * @return
     */
    public String getActionPath() {
        if (resource.containsKey(actionIndex))
            return resource.get(actionIndex);
        return null;
    }
}
