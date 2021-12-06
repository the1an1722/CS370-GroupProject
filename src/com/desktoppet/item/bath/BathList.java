package com.desktoppet.item.bath;

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
 * Description: Bath list
 *
 * @author Shengliang Yu
 */
public class BathList {

    private BathEnum bathEnum;
    private int itemNum;
    private AnchorPane anchorPane;
    private Label label;

    public BathList(BathEnum bathEnum, int itemNum) {
        this.bathEnum = bathEnum;
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
        label.setText(bathEnum.getName() + "*" + itemNum);
        return anchorPane;
    }

    /**
     * Only the number changes each time, so there is no need to create new objects again,
     * otherwise it will be particularly time-consuming
     */
    private void init() {
        anchorPane = new AnchorPane();
        ImageView imageView = new ImageView(ResourceGetter.getInstance().get(bathEnum.getPath()));
        imageView.setFitWidth(85);
        imageView.setFitHeight(85);
        label = new Label(bathEnum.getName() + "*" + itemNum);
        label.setLayoutX(0);
        label.setLayoutY(65);
        label.setMinWidth(85);
        label.setMinHeight(20);
        label.setAlignment(Pos.CENTER); // Vertically and horizontally centered
        label.setStyle("-fx-background-color: rgba(0, 0, 0, 0.6); -fx-text-fill: white");
        anchorPane.getChildren().addAll(imageView, label);
        anchorPane.setOnMousePressed(e -> useItem());
    }

    private void useItem() {
        if (itemNum <= 0) return;
        if (!TotalState.getInstance().getCleanlinessState().canIncrease()) {
            InterfaceFunction.getInstance().say("I'm already clean!", Constant.UserInterface.SayingRunTime);
            return;
        }
        decrease(1);
        Action action = Action.creatTemporaryInterruptableAction(
                bathEnum.getActionPath(),
                Constant.UserInterface.ActionRunTime * 2,
                Constant.ImageShow.mainImage
        );
        ActionExecutor.getInstance().execute(action);
        InterfaceFunction.getInstance().say("I love taking shower~", Constant.UserInterface.SayingRunTime);
        // Increase Cleanliness
        TotalState.getInstance().getCleanlinessState().increase(bathEnum.getBuff());
    }

    /**
     * Increase the number of items by num
     *
     * @param num
     */
    public void increase(int num) {
        this.itemNum += num;
    }

    /**
     * Decrease the number of items by num
     *
     * @param num
     */
    public void decrease(int num) {
        this.itemNum -= num;
        itemNum = Math.max(0, itemNum);
    }

    /**
     * Item left
     *
     * @return
     */
    public int getItemNum() {
        return itemNum;
    }

}
