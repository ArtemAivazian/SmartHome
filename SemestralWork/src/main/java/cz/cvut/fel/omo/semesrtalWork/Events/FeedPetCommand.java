package cz.cvut.fel.omo.semesrtalWork.Events;

public class FeedPetCommand implements Command{
    private EventHandler handler;

    public FeedPetCommand(EventHandler handler) {
        this.handler = handler;
    }

    @Override
    public void execute() {
        handler.feedPet();
    }
}
