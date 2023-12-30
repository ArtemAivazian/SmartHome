package cz.cvut.fel.omo.semesrtalWork.events;

public class WarmUpFoodCommand implements ICommand{
    private CommandParameters parameters;

    public WarmUpFoodCommand(CommandParameters parameters) {
        this.parameters = parameters;
    }

    @Override
    public void execute() {
        parameters.getHandler().warmUpFood();
    }

}
