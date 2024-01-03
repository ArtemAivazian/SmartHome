package cz.cvut.fel.omo.semesrtalWork.events;

public class TurnOffCattleCommand extends ACommand {

    public TurnOffCattleCommand(CommandParameters parameters) {
        super(parameters);
    }

    @Override
    public void execute() {
        parameters.getDevice().stopUsage();
        parameters.getHandler().turnOffCattle();
    }

}
