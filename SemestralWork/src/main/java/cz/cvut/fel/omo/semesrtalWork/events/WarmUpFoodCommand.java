package cz.cvut.fel.omo.semesrtalWork.events;

public class WarmUpFoodCommand extends ACommand {

    public WarmUpFoodCommand(CommandParameters parameters) {
        super(parameters);
    }

    @Override
    public void execute() {
        parameters.getDevice().setActionTime(2);
        parameters.getDevice().setFree(false);
        parameters.getHandler().warmUpFood();
    }

}
