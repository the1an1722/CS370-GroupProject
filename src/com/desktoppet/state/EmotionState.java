package com.desktoppet.state;

import com.desktoppet.constant.Constant;
import com.desktoppet.img.ResourceGetter;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 * Description: Pet's Emotion State
 *
 * @author Shengliang Yu
 */
public class EmotionState {

    /**
     * Emotion State，Range in [0, 100]
     */
    private int emotion = 60;
    public static final int Reduce_Step = 5;
    public static final int Increase_Step = 10;
    public static final int Max_Value = 100;
    public static final int Min_Value = 0;
    private ImageView imageView;

    private final ResourceGetter resourceGetter = ResourceGetter.getInstance();

    public EmotionState() {
        imageView = new ImageView();
    }

    /**
     * Decreased Emotion
     */
    public void reduce() {
        emotion = Math.max(Min_Value, emotion - Reduce_Step);
    }

    /**
     * Increased Emotion
     */
    public void increase() {
        if (emotion < Max_Value) showIncreasedAnimation();
        emotion = Math.min(Max_Value, emotion + Increase_Step);
        System.out.printf("[EmotionState::increase]-Current Emotion=%d\n", emotion);
    }

    /**
     * Animation showing increased emotion
     */
    private void showIncreasedAnimation() {
        Image increasingImg = resourceGetter.get(Constant.ImageShow.emotionIncreasingImage);
        imageView.setImage(increasingImg);
        imageView.setStyle("-fx-background:transparent;");
        // Set the position relative to the parent container
        imageView.setX(0);
        imageView.setY(0);
        imageView.setLayoutX(60);
        imageView.setLayoutY(0);
        // Set the height of the picture display
        imageView.setFitHeight(80);
        // Keep the width and height ratio
        imageView.setPreserveRatio(true);
        imageView.setVisible(true);

        double millis = Constant.UserInterface.ActionRunTime * 1000;
        // Moving animation
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(millis), imageView);
        translateTransition.setInterpolator(Interpolator.EASE_BOTH);
        translateTransition.setFromY(40);
        translateTransition.setToY(0);

        // Fade in and fade out animation
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(millis), imageView);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0);
        // Parallel execution of animation
        ParallelTransition parallelTransition = new ParallelTransition();
        parallelTransition.getChildren().addAll(
                fadeTransition,
                translateTransition
        );
        parallelTransition.play();
    }

    public ImageView getImageView() {
        return imageView;
    }
}
