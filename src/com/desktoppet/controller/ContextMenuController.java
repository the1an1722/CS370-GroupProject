package com.desktoppet.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;


/**
 * Description: Right-click menu controller
 *
 * @author Shengliang Yu
 */
public class ContextMenuController {

    /**
     * The first level menu should be hidden after clicking the button
     */
    private Stage preStage;
    /**
     * Use X coordinate of the upper left corner to open the secondary menu
     */
    private double screenX;
    /**
     * Use Y coordinate of the upper left corner to open the secondary menu
     */
    private double screenY;

    public void Init(Stage stage, double screenX, double screenY) {
        this.preStage = stage;
        this.screenX = screenX;
        this.screenY = screenY;
    }

    @FXML
    public void eat() {
        preStage.close();
        showItemsWindow(ItemsWindowController.FoodTitle);
    }

    @FXML
    public void bath() {
        preStage.close();
        showItemsWindow(ItemsWindowController.BathTitle);
    }

    private void showItemsWindow(String title) {
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
        stage.setX(screenX);
        stage.setY(screenY);

        // Get fxml file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/desktoppet/fxml/ItemsWindow.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Get controller
        ItemsWindowController controller = loader.getController();
        controller.Init(title, stage);

        // Load the scene in the stage and set the css style for the scene
        Scene scene = new Scene(Objects.requireNonNull(root));
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        scene.getStylesheets().addAll(Objects.requireNonNull(this.getClass().getResource("/com/desktoppet/fxml/ItemsWindow.css")).toExternalForm());

        // Set to hide the stage when the focus is lost
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
