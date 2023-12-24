package cz.cvut.fel.omo.semesrtalWork.events;

import cz.cvut.fel.omo.semesrtalWork.item.AItem;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.ADevice;

public class TurnOnCattleCommand implements ICommand{
    private EventHandler handler;

    public TurnOnCattleCommand(EventHandler handler) {
        this.handler = handler;
    }

    @Override
    public void execute() {
        System.out.println("!!?");
    }

    @Override
    public void execute(ADevice device) {
        device.use();
        handler.turnOnCattle();
    }

    @Override
    public void execute(AItem item) {

    }
}
