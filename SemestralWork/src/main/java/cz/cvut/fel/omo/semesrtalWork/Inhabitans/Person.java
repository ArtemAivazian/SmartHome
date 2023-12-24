package cz.cvut.fel.omo.semesrtalWork.Inhabitans;

import cz.cvut.fel.omo.semesrtalWork.events.ICommand;
import cz.cvut.fel.omo.semesrtalWork.item.AItem;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.ADevice;

public class Person extends AInhabitant{
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

    @Override
    public void updateState(double elapsedTime) {
        if (!isHungry) {
            fullness -= 5;
            if (fullness <= 0 ){
                isHungry = true;
            }
        } else {
            System.out.println("Person is hungry");
        }
    }
}
