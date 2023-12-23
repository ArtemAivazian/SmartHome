package cz.cvut.fel.omo.semesrtalWork.events;

import cz.cvut.fel.omo.semesrtalWork.observer.devices.ADevice;

public class TakeSkisCommand implements ICommand {
    private EventHandler handler;

    public TakeSkisCommand(EventHandler handler) {
        this.handler = handler;
    }

    @Override
    public void execute() {
        handler.takeSkies();
    }

    @Override
    public void execute(ADevice device) {
        System.out.println("!!?");
    }
}
