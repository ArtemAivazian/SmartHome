package cz.cvut.fel.omo.semesrtalWork.events;

import cz.cvut.fel.omo.semesrtalWork.Inhabitans.Pet;
import cz.cvut.fel.omo.semesrtalWork.item.AItem;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.ADevice;

public class TakeBikeCommand implements ICommand {
    private CommandParameters parameters;

    public TakeBikeCommand(CommandParameters parameters) {
        this.parameters = parameters;
    }


    @Override
    public void execute() {
        if (parameters.getItem().isFree()){
            parameters.getItem().use();
            parameters.getHandler().takeBike();
        }
    }
}