package cz.cvut.fel.omo.semesrtalWork.events;

public class TakeSkisCommand implements ICommand {
    private EventHandler handler;

    public TakeSkisCommand(EventHandler handler) {
        this.handler = handler;
    }

    @Override
    public void execute() {
        handler.takeSkies();
    }
}
