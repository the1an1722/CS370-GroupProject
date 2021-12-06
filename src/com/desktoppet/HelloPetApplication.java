package com.desktoppet;

import com.desktoppet.constant.Constant;
import com.desktoppet.event.GlobalEventListener;
import com.desktoppet.img.ResourceGetter;
import com.desktoppet.state.TotalState;
import com.desktoppet.ui.InterfaceFunction;
import com.desktoppet.ui.MainNode;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;

public class HelloPetApplication extends Application {
    /**
     * Window for displaying pictures
     */
    private final ImageView imageView = MainNode.getInstance().getImageView();
    private final Stage stage = MainNode.getInstance().getStage();
    private AnchorPane pane;
    private InterfaceFunction interfaceFunction;
    private final TotalState totalState = TotalState.getInstance();
    /**
     * Global event monitoring, currently supports drag and drop, left-click feedback
     */
    private GlobalEventListener globalEventListener;

    private final ResourceGetter resourceGetter = ResourceGetter.getInstance();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.setOpacity(0);     // Set parent transparency to 0
        stage.initOwner(primaryStage);  // Set primaryStage as the attribution object
        initImageView();
        // Interactive function platform
        interfaceFunction = InterfaceFunction.getInstance();
        // Panel
        pane = new AnchorPane(
                interfaceFunction.getMessageBox(),
                imageView,
                totalState.getEmotionState().getImageView()
        );
        pane.setStyle("-fx-background:transparent;");
        // Turn on global events listener
        globalEventListener = new GlobalEventListener(stage, imageView, pane);
        initStage(stage);
        primaryStage.show();
        stage.show();
        interfaceFunction.setTray(stage);   // Set system tray
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void initImageView() {
        Image image = resourceGetter.get(Constant.ImageShow.mainImage);
        imageView.setImage(image);
        imageView.setX(0);
        imageView.setY(0);
        imageView.setLayoutX(0);
        imageView.setLayoutY(50);
        // Set the size of the picture display
        imageView.setFitHeight(Constant.ImageShow.ImageHeight);
        imageView.setFitHeight(Constant.ImageShow.ImageWidth);
        imageView.setPreserveRatio(true);                       // Keep width:height ratio
        imageView.setStyle("-fx-background:transparent;");      // Transparent Background
    }

    private void initStage(Stage stage) {
        Scene scene = new Scene(pane, 400, 400);
        scene.setFill(null);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("application.css")).toExternalForm());
        stage.setScene(scene);
        // Set the initial position of the form
        stage.setX(850);
        stage.setY(400);
        // The window is always displayed at the top
        stage.setAlwaysOnTop(true);
        // Modify the taskbar icon
        stage.getIcons().add(resourceGetter.get(Constant.ImageShow.iconImage));
        // Transparent background
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setOnCloseRequest(event -> {
            event.consume();
            interfaceFunction.exit();
        });
    }
}