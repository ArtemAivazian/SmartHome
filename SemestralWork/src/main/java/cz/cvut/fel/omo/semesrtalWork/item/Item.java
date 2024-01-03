package cz.cvut.fel.omo.semesrtalWork.item;

import cz.cvut.fel.omo.semesrtalWork.simulation.Action;

public abstract class Item extends Action {
    public void use(){
        isFree = false;
    }
    public abstract void updateState(double elapsedTime);
}
