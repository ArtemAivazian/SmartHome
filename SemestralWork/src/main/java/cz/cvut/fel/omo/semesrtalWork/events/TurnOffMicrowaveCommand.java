package cz.cvut.fel.omo.semesrtalWork.events;

import cz.cvut.fel.omo.semesrtalWork.Inhabitans.Pet;
import cz.cvut.fel.omo.semesrtalWork.item.AItem;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.ADevice;

public class TurnOffMicrowaveCommand implements ICommand {
    private CommandParameters parameters;

    public TurnOffMicrowaveCommand(CommandParameters parameters) {
        this.parameters = parameters;
    }

    @Override
    public void execute() {
        parameters.getDevice().stopUsage();
        parameters.getHandler().turnOffMicrowave();
    }
}
