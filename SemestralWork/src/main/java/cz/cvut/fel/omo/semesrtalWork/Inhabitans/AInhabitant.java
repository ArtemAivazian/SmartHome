package cz.cvut.fel.omo.semesrtalWork.Inhabitans;

import cz.cvut.fel.omo.semesrtalWork.events.ICommand;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.ADevice;

public class AInhabitant {
    private ICommand command;

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
}
