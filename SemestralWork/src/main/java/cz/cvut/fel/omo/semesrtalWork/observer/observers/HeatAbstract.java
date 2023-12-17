package cz.cvut.fel.omo.semesrtalWork.observer.observers;

public abstract class HeatAbstract extends ADevice {
    public HeatAbstract(ADevice deviceState) {
        super(deviceState);
    }

    @Override
    public void update() {
        execute();
    }

    public abstract void execute();


}
