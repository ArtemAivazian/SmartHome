package cz.cvut.fel.omo.semesrtalWork.events;

public class TurnOnCattleCommand extends ACommand {

    public TurnOnCattleCommand(CommandParameters parameters) {
        super(parameters);
    }

    @Override
    public void execute() {
        parameters.getDevice().use();
        parameters.getHandler().turnOnCattle();
    }
}
