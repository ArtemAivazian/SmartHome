package cz.cvut.fel.omo.semesrtalWork.Inhabitans;

import cz.cvut.fel.omo.semesrtalWork.events.ICommand;

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
}
