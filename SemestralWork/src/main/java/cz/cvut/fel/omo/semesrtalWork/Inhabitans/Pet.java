package cz.cvut.fel.omo.semesrtalWork.Inhabitans;

import cz.cvut.fel.omo.semesrtalWork.simulation.Action;

public class Pet extends Action {
    protected boolean isHungry = false;
    protected double fullness = 100;
    private String name;

    public Pet(String name) {
        this.name = name;
    }

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

    public boolean isHungry() {
        return isHungry;
    }

    public double getFullness() {
        return fullness;
    }

    public void setHungry(boolean hungry) {
        isHungry = hungry;
    }

    public void setFullness(double fullness) {
        this.fullness = fullness;
    }

    public String getName() {
        return name;
    }
}
