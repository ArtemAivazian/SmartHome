package cz.cvut.fel.omo.semesrtalWork.events;

public class MakeTeaCommand extends ACommand {

    public MakeTeaCommand(CommandParameters parameters) {
        super(parameters);
    }

    @Override
    public void execute() {
        parameters.getHandler().makeTea();
    }
}
