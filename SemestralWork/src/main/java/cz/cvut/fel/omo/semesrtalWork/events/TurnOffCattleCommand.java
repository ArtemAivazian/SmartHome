package cz.cvut.fel.omo.semesrtalWork.events;

public class TurnOffCattleCommand implements ICommand{
    private EventHandler handler;

    public TurnOffCattleCommand(EventHandler handler) {
        this.handler = handler;
    }

    @Override
    public void execute() {
        handler.turnOffCattle();
    }
}
