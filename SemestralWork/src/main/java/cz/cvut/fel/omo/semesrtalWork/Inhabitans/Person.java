package cz.cvut.fel.omo.semesrtalWork.Inhabitans;

import cz.cvut.fel.omo.semesrtalWork.events.ACommand;
import cz.cvut.fel.omo.semesrtalWork.simulation.Action;

public class Person extends Action {
    protected ACommand command;
    protected boolean isHungry = false;
    protected double fullness = 100;

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public ACommand getCommand() {
        return command;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public double getFullness() {
        return fullness;
    }

    public void setCommand(ACommand command) {
        this.command = command;
    }
    public void executeCommand() {
        if (command != null)
            command.execute();
        command = null;
    }

    public void updateState(double elapsedTime) {
        if (!isFree){
            actionTime--;
            if (actionTime == 0){
                isFree = true;
            }
        }
        if (!isHungry) {
            fullness -= 20;
            if (fullness <= 0 ){
                isHungry = true;
            }
        } else {
            System.out.println("Person is hungry");
        }
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
