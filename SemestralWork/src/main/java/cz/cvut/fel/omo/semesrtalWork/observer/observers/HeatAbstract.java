package cz.cvut.fel.omo.semesrtalWork.observer.observers;

public abstract class HeatAbstract extends ADevice {
    @Override
    public void update() {
        execute();
    }

    public abstract void execute();


}
