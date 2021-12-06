package com.desktoppet.state;


/**
 * Description: All the status of Pet
 *
 * @author Shengliang Yu
 */

public class TotalState {

    private static TotalState totalState;
    private final CleanlinessState cleanlinessState;
    private final EmotionState emotionState;
    private final StaminaState staminaState;

    private TotalState() {
        emotionState = new EmotionState();
        staminaState = new StaminaState();
        cleanlinessState = new CleanlinessState();
    }

    public static TotalState getInstance() {
        if (totalState == null) totalState = new TotalState();
        return totalState;
    }

    public CleanlinessState getCleanlinessState() {
        return cleanlinessState;
    }

    public EmotionState getEmotionState() {
        return emotionState;
    }

    public StaminaState getStaminaState() {
        return staminaState;
    }
}
