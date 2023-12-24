package cz.cvut.fel.omo.semesrtalWork.simulation;

public abstract class AAction {
    protected boolean isFree = true;

    protected double actionTime;

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public double getActionTime() {
        return actionTime;
    }

    public void setActionTime(double actionTime) {
        this.actionTime = actionTime;
    }
}
