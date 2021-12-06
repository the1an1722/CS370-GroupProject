package com.desktoppet.item.food;

import com.desktoppet.constant.Constant;
import com.desktoppet.img.ResourceGetter;
import com.desktoppet.state.TotalState;
import com.desktoppet.ui.Action;
import com.desktoppet.ui.ActionExecutor;
import com.desktoppet.ui.InterfaceFunction;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * Description: food list
 *
 * @author Shengliang Yu
 */
public class FoodList {

    private FoodEnum foodEnum;
    private int itemNum;
    private AnchorPane anchorPane;
    private Label label;

    public FoodList(FoodEnum foodEnum, int itemNum) {
        this.foodEnum = foodEnum;
        this.itemNum = itemNum;
        init();
    }

    /**
     * Create an AnchorPane for display in ItemsWindow, and add a click event
     * After clicking, an action using the item will be generated, and an item will be subtracted
     *
     * @return AnchorPane
     */
    public AnchorPane toItemAnchorPane() {
        label.setText(foodEnum.getName() + "*" + itemNum);
        return anchorPane;
    }

    /**
     * Only the number changes each time, so there is no need to create new objects again,
     * otherwise it will be particularly time-consuming
     */
    private void init() {
        anchorPane = new AnchorPane();
        ImageView imageView = new ImageView(ResourceGetter.getInstance().get(foodEnum.getPath()));
        imageView.setFitWidth(85);
        imageView.setFitHeight(85);
        label = new Label(foodEnum.getName() + "*" + itemNum);
        label.setLayoutX(0);
        label.setLayoutY(65);
        label.setMinWidth(85);
        label.setMinHeight(20);
        // Vertically and horizontally centered
        label.setAlignment(Pos.CENTER);
        label.setStyle("-fx-background-color: rgba(0, 0, 0, 0.6); -fx-text-fill: white");
        anchorPane.getChildren().addAll(imageView, label);
        anchorPane.setOnMousePressed(e -> useItem());
    }

    private void useItem() {
        if (itemNum <= 0) return;
        if (!TotalState.getInstance().getStaminaState().canIncrease()) {
            InterfaceFunction.getInstance().say("Can eat anymore, I'm stuck~", Constant.UserInterface.SayingRunTime);
            return;
        }
        decrease(1);
        Action action = Action.creatTemporaryInterruptableAction(
                foodEnum.getActionPath(),
                Constant.UserInterface.ActionRunTime * 2,
                Constant.ImageShow.mainImage
        );
        ActionExecutor.getInstance().execute(action);
        InterfaceFunction.getInstance().say("Yummy!Yummy!", Constant.UserInterface.SayingRunTime);
        // increase stamina state
        TotalState.getInstance().getStaminaState().increase(foodEnum.getBuff());
    }

    /**
     * increase item
     *
     * @param num
     */
    public void increase(int num) {
        this.itemNum += num;
    }

    /**
     * decrease item
     *
     * @param num
     */
    public void decrease(int num) {
        this.itemNum -= num;
        itemNum = Math.max(0, itemNum);
    }

    /**
     * item left
     *
     * @return
     */
    public int getItemNum() {
        return itemNum;
    }
}
