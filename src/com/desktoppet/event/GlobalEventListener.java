package com.desktoppet.event;

import com.desktoppet.menu.ContextMenu;
import com.desktoppet.ui.ActionExecutor;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import static javafx.scene.input.MouseButton.PRIMARY;
import static javafx.scene.input.MouseButton.SECONDARY;

/**
 * Description: Global Event Listener
 *
 * @author Shengliang Yu
 */
public class GlobalEventListener {

    private final Stage stage;
    private final ImageView imageView;
    private final AnchorPane anchorPane;
    /**
     * The action executor, the triggered action needs to be entrusted to the action executor to execute
     */
    private final ActionExecutor actionExecutor;

    private double xOffset = 0;
    private double yOffset = 0;
    private double preScreenX = 0;
    private double preScreenY = 0;

    public GlobalEventListener(Stage stage, ImageView imageView, AnchorPane anchorPane) {
        this.stage = stage;
        this.imageView = imageView;
        this.anchorPane = anchorPane;
        this.actionExecutor = ActionExecutor.getInstance();
        activeDrag();
        activeClick();
        enableContextMenu();
    }

    /**
     * Active Dragging
     */
    private void activeDrag() {
        anchorPane.setOnMousePressed(e -> {
            xOffset = e.getSceneX();
            yOffset = e.getSceneY();
        });
        anchorPane.setOnMouseDragged(e -> {
            stage.setX(e.getScreenX() - xOffset);
            stage.setY(e.getScreenY() - yOffset);
        });
    }

    /**
     * Active Click
     */
    private void activeClick() {
        imageView.setOnMousePressed(e -> {
            if (e.getButton() == PRIMARY) {
                preScreenX = e.getScreenX();
                preScreenY = e.getScreenY();
            }
        });
        imageView.setOnMouseReleased(e -> {
            if (e.getButton() == PRIMARY) {
                if (e.getScreenX() == preScreenX && e.getScreenY() == preScreenY) {
                    actionExecutor.executeClickAction();
                }
            }
        });
    }

    /**
     * Right-click on Pet to open the right-click menu
     */
    private void enableContextMenu() {
        imageView.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
            if (e.getButton() == SECONDARY) {
                Node node = e.getPickResult().getIntersectedNode();
                // Add a menu to the node object
                ContextMenu.getInstance().show(node, e.getScreenX(), e.getScreenY());
            }
        });
    }


}
