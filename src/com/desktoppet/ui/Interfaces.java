package com.desktoppet.ui;


import com.desktoppet.constant.Constant;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

/**
 * Description: UI's Interface function
 *
 * @author Shengliang Yu
 */
public class Interfaces {

    private static Interfaces uiInterface;

    private final ImageView imageView = MainNode.getInstance().getImageView();
    private final ActionExecutor actionExecutor = ActionExecutor.getInstance();
    private final Stage stage = MainNode.getInstance().getStage();
    private VBox messageBox;
    private CheckboxMenuItem itemSay = new CheckboxMenuItem("Nagging");
    private final String greet = "Miss yo, long time no see~";

    public Interfaces() {
        this.messageBox = new VBox();
        inMessage();
        say(greet, 8);
        // Turn on random events
        RandomEvent randomEvent = new RandomEvent();
        new Thread(randomEvent).start();
    }

    public static Interfaces getInstance() {
        if (uiInterface == null) {
            uiInterface = new Interfaces();
        }
        return uiInterface;
    }

    /**
     * Exit
     */
    public void exit() {
        // Show farewell animation
        double time = 2.0;
        actionExecutor.execute(Action.creatTemporaryUninterruptible(Constant.ImageShow.byeImage, time, Constant.ImageShow.mainImage));
        // Use Platform.runLater
        Platform.runLater(() -> say("Bye~", Constant.UserInterface.SayingRunTime));
        // Execute exit after the animation ends
        new Timeline(new KeyFrame(
                Duration.seconds(time),
                ae -> System.exit(0)))
                .play();
    }

    /**
     * Initialize the message box
     */
    private void inMessage() {
        Label bubble = new Label();
        bubble.setPrefWidth(100);   // Set the width of the bubble
        bubble.setWrapText(true);   // Automatic warp line
        bubble.setStyle("-fx-background-color: rgba(255,255,255,0.8); -fx-background-radius: 8px;");
        // The width of the inner margin of the label
        bubble.setPadding(new Insets(8));
        bubble.setFont(new javafx.scene.text.Font(15));
        bubble.setTextFill(Color.web("#000001"));
        //Set the X and Y of the three vertices of the triangle respectively
        Polygon triangle = new Polygon(0.0, 0.0, 8.0, 10.0, 16.0, 0.0);
        triangle.setFill(new Color(1, 1, 1, 0.7));

        messageBox.getChildren().addAll(bubble, triangle);
        messageBox.setAlignment(Pos.BOTTOM_CENTER);
        messageBox.setStyle("-fx-background:transparent;");
        // Set the position relative to the parent container
        messageBox.setLayoutX(0);
        messageBox.setLayoutY(0);
        messageBox.setVisible(true);
    }


    /**
     * Say
     *
     * @param msg
     * @param duration
     */
    public void say(String msg, int duration) {
        Label lbl = (Label) messageBox.getChildren().get(0);
        lbl.setText(msg);
        messageBox.setVisible(true);
        // Set the display time of the bubble
        new Timeline(new KeyFrame(
                Duration.seconds(duration),
                ae -> messageBox.setVisible(false)))
                .play();
    }

    /**
     * Add system tray
     *
     * @param stage
     */
    public void setTray(Stage stage) {
        SystemTray tray = SystemTray.getSystemTray();
        // System tray
        BufferedImage image;
        try {
            // Add a right-click pop-up menu for the tray
            PopupMenu popMenu = new PopupMenu();
            popMenu.setFont(new Font("Times New Roman", Font.PLAIN, 14));

            MenuItem itemShow = new MenuItem("SHOW");
            itemShow.addActionListener(e -> Platform.runLater(stage::show));

            MenuItem itemHide = new MenuItem("HIDE");
            // First setImplicitExit(false), otherwise stage.hide() will directly close the stage
            itemHide.addActionListener(e -> {
                Platform.setImplicitExit(false);
                Platform.runLater(stage::hide);
            });

            MenuItem itemExit = new MenuItem("EXIT");
            itemExit.addActionListener(e -> exit());

            popMenu.add(itemSay);
            popMenu.addSeparator();
            popMenu.add(itemShow);
            popMenu.add(itemHide);
            popMenu.add(itemExit);
            // Set system tray
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(Constant.ImageShow.iconImage)));
            TrayIcon trayIcon = new TrayIcon(image, "Pet", popMenu);
            trayIcon.setToolTip("Pet");
            // Automatically adjust the picture size. If I don't set this, it will display blank page
            trayIcon.setImageAutoSize(true);
            tray.add(trayIcon);
        } catch (IOException | AWTException e) {
            e.printStackTrace();
        }
    }

    public ImageView getImageView() {
        return imageView;
    }

    public VBox getMessageBox() {
        return messageBox;
    }

    class RandomEvent implements Runnable {
        @Override
        public void run() {
            while (true) {
                Random rand = new Random();
                // An automatic event occurs randomly, the following setting interval is 9~24 seconds
                long time = (rand.nextInt(15) + 10) * 1000;
                if (itemSay.getState()) {
                    //Randomly choose what to say
                    String str = Constant.UserInterface.selfTalking[rand.nextInt(5)];
                    Platform.runLater(() -> say(str, Constant.UserInterface.SayingRunTime));
                }
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
