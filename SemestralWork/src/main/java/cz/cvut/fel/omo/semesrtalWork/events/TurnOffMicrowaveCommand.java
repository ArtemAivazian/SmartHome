package cz.cvut.fel.omo.semesrtalWork.events;

public class TurnOffMicrowaveCommand implements ICommand{
    private EventHandler handler;

    public TurnOffMicrowaveCommand(EventHandler handler) {
        this.handler = handler;
    }

    @Override
    public void execute() {
        handler.turnOffMicrowave();
    }
}
