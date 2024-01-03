package cz.cvut.fel.omo.semesrtalWork.observer.devices;

public abstract class SmokeAbstract extends ADevice {

    public void update() {
        execute();
    }
    public abstract void execute();
}
