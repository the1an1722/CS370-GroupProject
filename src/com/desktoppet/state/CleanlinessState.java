package com.desktoppet.state;

/**
 * Description: CleanlinessState
 *
 * @author Shengliang Yu
 */
public class CleanlinessState {

    private int cleanliness = 60;

    public static final int Reduce_Step = 2;
    public static final int Max_Value = 100;
    public static final int Min_Value = 0;

    /**
     * Decreased Cleanliness
     */
    public void reduce() {
        cleanliness = Math.max(Min_Value, cleanliness - Reduce_Step);
    }

    /**
     * Increased Cleanliness
     *
     * @param num
     */
    public void increase(int num) {
        cleanliness = Math.min(Max_Value, cleanliness + num);
        System.out.printf("[CleanlinessState::increase(%d)]-Current Cleanliness=%d\n", num, cleanliness);
    }

    /**
     * Can it increase anymore
     *
     * @return
     */
    public boolean canIncrease() {
        return cleanliness < Max_Value;
    }

}
