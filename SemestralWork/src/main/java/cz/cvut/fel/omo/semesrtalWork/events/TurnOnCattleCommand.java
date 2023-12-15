package cz.cvut.fel.omo.semesrtalWork.events;

public class TurnOnCattleCommand implements ICommand{
    private EventHandler handler;

    public TurnOnCattleCommand(EventHandler handler) {
        this.handler = handler;
    }

    @Override
    public void execute() {
        handler.turnOnCattle();
    }
}
