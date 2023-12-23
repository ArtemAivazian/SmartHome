package cz.cvut.fel.omo.semesrtalWork.events;

import cz.cvut.fel.omo.semesrtalWork.observer.devices.ADevice;

public class TurnOffMicrowaveCommand implements ICommand{
    private EventHandler handler;

    public TurnOffMicrowaveCommand(EventHandler handler) {
        this.handler = handler;
    }

    @Override
    public void execute() {
        System.out.println("!!?");
    }
    @Override
    public void execute(ADevice device) {
        device.stopUsage();
        handler.turnOffMicrowave();
    }
}