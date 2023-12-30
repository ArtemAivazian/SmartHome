package cz.cvut.fel.omo.semesrtalWork.events;

public class MakeTeaCommand implements ICommand{
    private CommandParameters parameters;

    public MakeTeaCommand(CommandParameters parameters) {
        this.parameters = parameters;
    }

    @Override
    public void execute() {
        parameters.getHandler().makeTea();
    }
}
