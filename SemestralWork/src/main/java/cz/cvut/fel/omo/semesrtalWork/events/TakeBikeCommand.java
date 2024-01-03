package cz.cvut.fel.omo.semesrtalWork.events;

public class TakeBikeCommand extends ACommand {

    public TakeBikeCommand(CommandParameters parameters) {
        super(parameters);
    }


    @Override
    public void execute() {
        if (parameters.getItem().isFree()){
            parameters.getItem().use();
            parameters.getHandler().takeBike();
        }
    }
}
