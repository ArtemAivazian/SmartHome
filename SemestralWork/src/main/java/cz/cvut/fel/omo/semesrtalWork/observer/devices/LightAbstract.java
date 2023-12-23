package cz.cvut.fel.omo.semesrtalWork.observer.devices;

public abstract class LightAbstract extends ADevice {

    public void update() {
        execute();
    }
    public abstract void execute();
}
