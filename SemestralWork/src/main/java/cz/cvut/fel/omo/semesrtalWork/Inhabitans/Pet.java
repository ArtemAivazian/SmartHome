package cz.cvut.fel.omo.semesrtalWork.Inhabitans;

import cz.cvut.fel.omo.semesrtalWork.simulation.AAction;

public class Pet extends AAction {
    protected boolean isHungry = false;
    protected double fullness = 100;

    public void updateState(double elapsedTime) {
        if (!isHungry) {
            fullness -= 10;
            if (fullness <= 0 ){
                isHungry = true;
            }
        } else {
            System.out.println("Pet is hungry");
        }
    }

    public void setHungry(boolean hungry) {
        isHungry = hungry;
    }

    public void setFullness(double fullness) {
        this.fullness = fullness;
    }
}
