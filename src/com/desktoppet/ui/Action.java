package com.desktoppet.ui;

/**
 * Description: Action
 *
 * @author Shengliang Yu
 */

public class Action {

    /**
     * Current Action
     */
    private final String path;

    /**
     * Action sustaining time, if it is -1, the action will be maintained
     */
    private final double time;

    /**
     * Check it is that a temporary action
     */
    private final boolean isTemporaryAction;

    /**
     * If it is a temporary action, it should be restored to this action within this time
     */
    private String recoverPath;

    /**
     * Check it can that be interrupted
     */
    private final boolean interruptable;

    /**
     * If the action is continuous, the maintenance time is PerpetualTime
     */
    public static final double PerpetualTime = -1.0;

    private Action(String path, double time, boolean isTemporaryAction, String recoverPath, boolean interruptable) {
        this.path = path;
        this.time = time;
        this.isTemporaryAction = isTemporaryAction;
        this.recoverPath = recoverPath;
        this.interruptable = interruptable;
    }

    private Action(String path, double time, boolean isTemporaryAction, boolean interruptible) {
        this.path = path;
        this.time = time;
        this.isTemporaryAction = isTemporaryAction;
        this.interruptable = interruptible;
    }

    /**
     * Create temporary and interruptible actions
     *
     * @param path
     * @param time
     * @param recoverPath
     * @return
     */
    public static Action creatTemporaryInterruptible(String path, double time, String recoverPath) {
        return new Action(path, time, true, recoverPath, true);
    }

    /**
     * Create temporary and incorruptible actions
     *
     * @param path
     * @return
     */
    public static Action creatContinuousInterruptible(String path) {
        return new Action(path, PerpetualTime, false, true);
    }

    /**
     * Create short-lived, non-interruptible actions
     *
     * @param path
     * @param time
     * @param recoverPath
     * @return
     */
    public static Action creatTemporaryUninterruptible(String path, double time, String recoverPath) {
        return new Action(path, time, true, recoverPath, false);
    }

    public double getTime() {
        return time;
    }

    public String getPath() {
        return path;
    }

    public String getRecoverPath() {
        return recoverPath;
    }

    public boolean isTemporaryAction() {
        return isTemporaryAction;
    }

    public boolean isInterruptible() {
        return interruptable;
    }
}
