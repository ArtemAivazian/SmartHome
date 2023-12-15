package cz.cvut.fel.omo.semesrtalWork.Events;

public class TakeSkisCommand implements Command{
    private EventHandler handler;

    public TakeSkisCommand(EventHandler handler) {
        this.handler = handler;
    }

    @Override
    public void execute() {
        handler.takeSkies();
    }
}
