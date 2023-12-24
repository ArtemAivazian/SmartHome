package cz.cvut.fel.omo.semesrtalWork.events;

import cz.cvut.fel.omo.semesrtalWork.item.AItem;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.ADevice;

public class TurnOffCattleCommand implements ICommand{
    private EventHandler handler;

    public TurnOffCattleCommand(EventHandler handler) {
        this.handler = handler;
    }

    @Override
    public void execute() {
        System.out.println("!!?");
    }

    @Override
    public void execute(ADevice device) {
        device.stopUsage();
        handler.turnOffCattle();
    }

    @Override
    public void execute(AItem item) {

    }
}
