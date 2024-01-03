package cz.cvut.fel.omo.semesrtalWork.events;

public class TurnOffMicrowaveCommand extends ACommand {
    public TurnOffMicrowaveCommand(CommandParameters parameters) {
        super(parameters);
    }

    @Override
    public void execute() {
        parameters.getDevice().stopUsage();
        parameters.getHandler().turnOffMicrowave();
    }
}
