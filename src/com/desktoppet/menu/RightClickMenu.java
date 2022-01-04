package com.desktoppet.menu;

import com.desktoppet.controller.RightClickMenuController;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;


/**
 * Description: Click the right-click menu triggered by the Pet body
 *
 * @author Shengliang Yu
 */
public class RightClickMenu {

    private static RightClickMenu rightClickMenu;

    private RightClickMenu() {
    }

    public static RightClickMenu getInstance() {
        if (rightClickMenu == null) {
            rightClickMenu = new RightClickMenu();
        }
        return rightClickMenu;
    }

    public void show(Node node, double x, double y) {
        // Set a nominal stage to avoid generating a small window on the taskbar
        final Stage nominal = new Stage();
        nominal.initStyle(StageStyle.UTILITY);
        nominal.setOpacity(0);
        final Stage stage = new Stage();
        stage.initOwner(nominal);
        // Set the window to be transparent and borderless
        stage.initStyle(StageStyle.TRANSPARENT);
        // The setting window is always displayed at the top
        stage.setAlwaysOnTop(true);

        // Set the position where the menu appears, by default it appears at the bottom right of the cursor
        Rectangle2D screenRectangle = Screen.getPrimary().getBounds();
        double screenWidth = screenRectangle.getWidth();
        double screenHeight = screenRectangle.getHeight();
        double stageWidth = 138.0;
        double stageHeight = 280.0;

        // If the pop-up right-click menu extends beyond the right edge of the screen, expand to the left
        if (x + stageWidth > screenWidth) x -= stageWidth;
        stage.setX(x);
        stage.setY(y);
        // If the pop-up right-click menu extends beyond the bottom edge of the screen, expand upward
        if (y + stageHeight > screenHeight) y -= stageHeight;

        // Get fxml file
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/desktoppet/fxml/RightClickMenu.fxml"));
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Get controller instance
        RightClickMenuController contextMenuController = fxmlLoader.getController();
        contextMenuController.RightClickMenu(stage, x, y);

        // Load the scene in the stage and set the css style for the scene
        Scene scene = new Scene(Objects.requireNonNull(root));
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        scene.getStylesheets().addAll(Objects.requireNonNull(this.getClass().getResource("/com/desktoppet/fxml/RightClickMenu.css")).toExternalForm());

        // When the focus is lost, set to hide the stage
        stage.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!stage.isFocused()) {
                stage.close();
            }
        });

        // Show menu
        nominal.show();
        stage.show();
    }
}
