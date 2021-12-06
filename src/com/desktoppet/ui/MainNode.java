package com.desktoppet.ui;


import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * Description: Action display window，Including ImageView of the main interface，Stage
 * After all, it is the only object globally, so it is set to singleton mode,
 * and what you get globally is the only object
 *
 * @author Shengliang Yu
 */
public class MainNode {
    private final ImageView imageView;
    private final Stage stage;
    private static MainNode mainNode;

    private MainNode() {
        imageView = new ImageView();
        stage = new Stage();
    }

    public ImageView getImageView() {
        return imageView;
    }

    public static MainNode getInstance() {
        if (mainNode == null) mainNode = new MainNode();
        return mainNode;
    }

    public Stage getStage() {
        return stage;
    }


}
