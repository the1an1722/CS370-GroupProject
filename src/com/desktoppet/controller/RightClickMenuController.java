package com.desktoppet.controller;

import com.desktoppet.HelloPetApplication;
import com.desktoppet.calculator.Calc;
import com.desktoppet.ui.Interfaces;
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
public class RightClickMenuController extends Interfaces {

    /**
     * The first level menu should be hidden after clicking the button
     */
    private Stage firstStage;
    /**
     * Use X coordinate of the upper left corner to open the secondary menu
     */
    private double x;
    /**
     * Use Y coordinate of the upper left corner to open the secondary menu
     */
    private double y;

    public void RightClickMenu(Stage stage, double screenX, double screenY) {
        this.firstStage = stage;
        this.x = screenX;
        this.y = screenY;
    }

    @FXML
    public void eat() {
        firstStage.close();
        showItemsWindow(ItemsWindowController.FoodTitle);
    }

    @FXML
    public void bath() {
        firstStage.close();
        showItemsWindow(ItemsWindowController.BathTitle);
    }

    @FXML
    public void calc() throws Exception {
        firstStage.close();
        Calc calculator = new Calc();
        calculator.start(firstStage);
    }


    @FXML
    public void hide()
    {
        HelloPetApplication me = new HelloPetApplication();
        me.getPrimaryStage().close();
    }

    private void showItemsWindow(String title) {
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
        stage.setX(x);
        stage.setY(y);

        // Get fxml file
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().
                getResource("/com/desktoppet/fxml/ItemsWindow.fxml"));
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Get controller
        ItemsWindowController itemsWindowController = fxmlLoader.getController();
        itemsWindowController.ItemWindow(title, stage);

        // Load the scene in the stage and set the css style for the scene
        Scene scene = new Scene(Objects.requireNonNull(root));
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        scene.getStylesheets().addAll(Objects.requireNonNull(this.getClass().
                getResource("/com/desktoppet/fxml/ItemsWindow.css")).toExternalForm());

        // Set to hide the stage when the focus is lost
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
