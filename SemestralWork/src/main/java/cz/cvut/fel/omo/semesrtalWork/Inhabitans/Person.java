package cz.cvut.fel.omo.semesrtalWork.Inhabitans;

import cz.cvut.fel.omo.semesrtalWork.events.ICommand;
import cz.cvut.fel.omo.semesrtalWork.item.AItem;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.ADevice;
import cz.cvut.fel.omo.semesrtalWork.simulation.AAction;

import java.util.List;

public class Person extends AAction {
    protected ICommand command;
    protected boolean isHungry = false;
    protected double fullness = 100;
    public ICommand getCommand() {
        return command;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public double getFullness() {
        return fullness;
    }

    public void setCommand(ICommand command) {
        this.command = command;
    }
    public void executeCommand() {
        if (command != null)
            command.execute();
        command = null;
    }

    public void executeCommand(ADevice device) {
        if (command != null)
            command.execute(device);
        command = null;
    }


    public void executeCommand(AItem item) {
        if (command != null)
            command.execute(item);
        command = null;
    }
    public void executeCommand(Pet pet) {
        if (command != null)
            command.execute(pet);
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

}
