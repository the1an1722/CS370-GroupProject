package com.desktoppet.state;
/**
 * Description: All the status of Pet
 *
 * @author Shengliang Yu
 */

public class Status {
    private static Status totalState;
    private final CleanlinessState cleanlinessState;
    private final EmotionState emotionState;
    private final StaminaState staminaState;

    private Status() {
        emotionState = new EmotionState();
        staminaState = new StaminaState();
        cleanlinessState = new CleanlinessState();
    }

    public static Status getInstance() {
        if (totalState == null) totalState = new Status();
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
