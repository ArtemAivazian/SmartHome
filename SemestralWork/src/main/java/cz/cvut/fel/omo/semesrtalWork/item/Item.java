package cz.cvut.fel.omo.semesrtalWork.item;

import cz.cvut.fel.omo.semesrtalWork.simulation.Action;

public abstract class Item extends Action {
    private String type;
    public void use(){
        isFree = false;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public abstract void updateState(double elapsedTime);
}
