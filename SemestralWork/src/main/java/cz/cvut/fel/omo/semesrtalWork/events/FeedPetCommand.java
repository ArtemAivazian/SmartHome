package cz.cvut.fel.omo.semesrtalWork.events;

public class FeedPetCommand implements ICommand {
    private EventHandler handler;

    public FeedPetCommand(EventHandler handler) {
        this.handler = handler;
    }

    @Override
    public void execute() {
        handler.feedPet();
    }
}
