package cz.cvut.fel.omo.semesrtalWork.Inhabitans;

import cz.cvut.fel.omo.semesrtalWork.events.ICommand;
import cz.cvut.fel.omo.semesrtalWork.item.AItem;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.ADevice;

public abstract class AInhabitant {
    protected ICommand command;
    protected boolean isHungry = false;
    protected double fullness = 100;

    public void setCommand(ICommand command) {
        this.command = command;
    }
    public abstract void updateState(double elapsedTime);
}
