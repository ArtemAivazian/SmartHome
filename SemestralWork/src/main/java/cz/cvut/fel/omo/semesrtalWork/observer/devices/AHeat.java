package cz.cvut.fel.omo.semesrtalWork.observer.devices;

import cz.cvut.fel.omo.semesrtalWork.observer.Threshold;

public abstract class AHeat extends ADevice {
    protected Threshold threshold;
    public abstract void execute();
}
