package com.desktoppet.state;

/**
 * Description: Stamina State
 *
 * @author Shengliang Yu
 */

public class StaminaState {

    private int stamina = 60;

    public static final int Reduce_Step = 2;
    public static final int Max_Value = 100;
    public static final int Min_Value = 0;

    /**
     * Decreased Stamina
     */
    public void reduce() {
        stamina = Math.max(Min_Value, stamina - Reduce_Step);
    }

    /**
     * Increased Stamina
     *
     * @param num Increased amount
     */
    public void increase(int num) {
        stamina = Math.min(Max_Value, stamina + num);
        System.out.printf("[StaminaState::increase(%d)]-Current Stamina=%d\n", num, stamina);
    }

    /**
     * Can it increase anymore
     *
     * @return
     */
    public boolean canIncrease() {
        return stamina < Max_Value;
    }

}
