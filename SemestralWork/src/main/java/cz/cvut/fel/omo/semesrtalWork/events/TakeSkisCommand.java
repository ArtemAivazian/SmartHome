package cz.cvut.fel.omo.semesrtalWork.events;

import cz.cvut.fel.omo.semesrtalWork.item.AItem;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.ADevice;

public class TakeSkisCommand implements ICommand {
    private EventHandler handler;

    public TakeSkisCommand(EventHandler handler) {
        this.handler = handler;
    }

    @Override
    public void execute() {

    }

    @Override
    public void execute(ADevice device) {
        System.out.println("!!?");
    }

    @Override
    public void execute(AItem item) {
        if (!item.isUsing()){
            item.use();
            handler.takeSkies();
        } else {
            System.out.println("BahuY");
        }
    }
}
