package cz.cvut.fel.omo.semesrtalWork.observer.observers;

public abstract class LightAbstract extends ADevice {
    @Override
    public void update() {
        execute();
    }
    public abstract void execute();
}
