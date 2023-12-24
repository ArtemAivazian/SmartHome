package cz.cvut.fel.omo.semesrtalWork.item;

import cz.cvut.fel.omo.semesrtalWork.simulation.DataCollector;

public abstract class AItem {
    protected double usageTime;
    protected boolean isUsing = false;

    public boolean isUsing() {
        return isUsing;
    }

    public void  use(){
        isUsing = true;
    }
    public abstract void updateState(double elapsedTime);
}
