package cz.cvut.fel.omo.semesrtalWork.events;

public class TurnOnMicrowaveCommand implements ICommand{
    private EventHandler handler;

    public TurnOnMicrowaveCommand(EventHandler handler) {
        this.handler = handler;
    }

    @Override
    public void execute() {
        handler.turnOnMicrowave();
    }
}
