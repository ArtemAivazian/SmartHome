package cz.cvut.fel.omo.semesrtalWork.observer.observers;

public abstract class LightAbstract extends ADevice {
    public LightAbstract(ADevice deviceState) {
        super(deviceState);
    }

    @Override
    public void update() {
        execute();
    }
    public abstract void execute();
}
