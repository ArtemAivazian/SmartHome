package cz.cvut.fel.omo.semesrtalWork.events;

public class FeedPetCommand extends ACommand {

    public FeedPetCommand(CommandParameters parameters) {
        super(parameters);
    }

    @Override
    public void execute() {
        parameters.getPet().setFullness(100);
        parameters.getPet().setHungry(false);
        parameters.getHandler().feedPet();
    }
}
