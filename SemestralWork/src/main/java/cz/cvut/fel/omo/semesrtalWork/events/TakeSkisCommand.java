package cz.cvut.fel.omo.semesrtalWork.events;

public class TakeSkisCommand extends ACommand {

    public TakeSkisCommand(CommandParameters parameters) {
        super(parameters);
    }

    @Override
    public void execute() {
        if (parameters.getItem().isFree()){
            parameters.getItem().use();
            parameters.getHandler().takeSkies();
        }
    }
}
