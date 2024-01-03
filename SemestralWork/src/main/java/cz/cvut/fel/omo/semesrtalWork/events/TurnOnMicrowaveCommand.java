package cz.cvut.fel.omo.semesrtalWork.events;

public class TurnOnMicrowaveCommand extends ACommand {

    public TurnOnMicrowaveCommand(CommandParameters parameters) {
        super(parameters);
    }

    @Override
    public void execute() {
        parameters.getDevice().use();
        parameters.getHandler().turnOnMicrowave();
    }
}
