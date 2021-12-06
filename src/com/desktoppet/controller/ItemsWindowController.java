package com.desktoppet.controller;

import com.desktoppet.item.ItemWarehouse;
import com.desktoppet.item.bath.BathList;
import com.desktoppet.item.food.FoodList;
import com.desktoppet.state.TotalState;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Map;

/**
 * Description: Stock list controller, this window is used to display food, bath supplies, and part-time job lists
 *
 * @author Shengliang Yu
 */
public class ItemsWindowController {
    public static final String BathTitle = "Bath Stock";
    public static final String FoodTitle = "Food Stock";
    public static final String DrugTitle = "Drag Stock";

    @FXML
    public Label title;
    private String titleText;
    @FXML
    public Pane itemPane;
    @FXML
    public ScrollPane scrollPane;
    @FXML
    public VBox vbox;
    private Stage stage;

    public void Init(String title, Stage stage) {
        this.stage = stage;
        this.titleText = title;
        this.title.setText(title);
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.setSpacing(10);
        // Disable left and right rollers
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        loadItems();
    }

    private void loadItems() {
        switch (titleText) {
            case FoodTitle:
                loadFoodItems();
                break;
            case BathTitle:
                loadBathItems();
                break;
            case DrugTitle:
                loadDrugItems();
        }
    }

    private void loadFoodItems() {
        Map<String, FoodList> foodItemList = ItemWarehouse.getInstance().getFoodItemMap();
        for (Map.Entry<String, FoodList> entry : foodItemList.entrySet()) {
            if (entry.getValue().getItemNum() != 0) {
                vbox.getChildren().add(entry.getValue().toItemAnchorPane());
            }
        }
        ObservableList<Node> children = vbox.getChildren();
        children.forEach(c -> c.setOnMouseReleased(e -> {
            if (TotalState.getInstance().getStaminaState().canIncrease()) {
                stage.close();
            }
        }));
    }

    private void loadBathItems() {
        Map<String, BathList> bathItemList = ItemWarehouse.getInstance().getBathItemMap();
        for (Map.Entry<String, BathList> entry : bathItemList.entrySet()) {
            if (entry.getValue().getItemNum() != 0) {
                vbox.getChildren().add(entry.getValue().toItemAnchorPane());
            }
        }
        ObservableList<Node> children = vbox.getChildren();
        children.forEach(c -> c.setOnMouseReleased(e -> {
            if (TotalState.getInstance().getCleanlinessState().canIncrease()) {
                stage.close();
            }
        }));
    }

    private void loadDrugItems() {
    }
}
