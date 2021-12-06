package com.desktoppet.menu;

import com.desktoppet.controller.ContextMenuController;
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
public class ContextMenu {

    private static ContextMenu contextMenu;

    private ContextMenu() {

    }

    public static ContextMenu getInstance() {
        if (contextMenu == null) contextMenu = new ContextMenu();
        return contextMenu;
    }

    public void show(Node node, double screenX, double screenY) {
        // Set a nominal stage to avoid generating a small window on the taskbar
        final Stage nominalStage = new Stage();
        nominalStage.initStyle(StageStyle.UTILITY);
        nominalStage.setOpacity(0);
        final Stage stage = new Stage();
        stage.initOwner(nominalStage);
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
        if (screenX + stageWidth > screenWidth) screenX -= stageWidth;
        stage.setX(screenX);
        stage.setY(screenY);
        // If the pop-up right-click menu extends beyond the bottom edge of the screen, expand upward
        if (screenY + stageHeight > screenHeight) screenY -= stageHeight;

        // Get fxml file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/desktoppet/fxml/ContextMenu.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Get controller instance
        ContextMenuController controller = loader.getController();
        controller.Init(stage, screenX, screenY);

        // Load the scene in the stage and set the css style for the scene
        Scene scene = new Scene(Objects.requireNonNull(root));
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        scene.getStylesheets().addAll(Objects.requireNonNull(this.getClass().getResource("/com/desktoppet/fxml/ContextMenu.css")).toExternalForm());

        // When the focus is lost, set to hide the stage
        stage.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!stage.isFocused()) {
                stage.close();
            }
        });

        // Show menu
        nominalStage.show();
        stage.show();
    }

}
