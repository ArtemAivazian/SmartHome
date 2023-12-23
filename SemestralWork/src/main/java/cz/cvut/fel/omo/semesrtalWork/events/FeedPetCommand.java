package cz.cvut.fel.omo.semesrtalWork.events;

import cz.cvut.fel.omo.semesrtalWork.observer.devices.ADevice;

public class FeedPetCommand implements ICommand {
    private EventHandler handler;

    public FeedPetCommand(EventHandler handler) {
        this.handler = handler;
    }

    @Override
    public void execute() {
        handler.feedPet();
    }

    @Override
    public void execute(ADevice device) {
        System.out.println("!!?");
    }
}
