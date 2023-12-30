package cz.cvut.fel.omo.semesrtalWork.events;

import cz.cvut.fel.omo.semesrtalWork.Inhabitans.Pet;
import cz.cvut.fel.omo.semesrtalWork.item.AItem;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.ADevice;

public class FeedPetCommand implements ICommand {
    private CommandParameters parameters;

    public FeedPetCommand(CommandParameters parameters) {
        this.parameters = parameters;
    }

    @Override
    public void execute() {
        parameters.getPet().setFullness(100);
        parameters.getPet().setHungry(false);
        parameters.getHandler().feedPet();
    }
}
