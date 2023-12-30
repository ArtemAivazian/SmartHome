package cz.cvut.fel.omo.semesrtalWork.events;

import cz.cvut.fel.omo.semesrtalWork.Inhabitans.Pet;
import cz.cvut.fel.omo.semesrtalWork.item.AItem;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.ADevice;

public class TurnOnCattleCommand implements ICommand {
    private CommandParameters parameters;

    public TurnOnCattleCommand(CommandParameters parameters) {
        this.parameters = parameters;
    }

    @Override
    public void execute() {
        parameters.getDevice().use();
        parameters.getHandler().turnOnCattle();
    }
}
