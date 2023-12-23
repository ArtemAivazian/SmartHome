package cz.cvut.fel.omo.semesrtalWork.observer.devices;

public abstract class LightAbstract extends ADevice {

    public LightAbstract(double electricityConsumption, double gasConsumption, double waterConsumption, double functionality) {
        super(electricityConsumption, gasConsumption, waterConsumption, functionality);
    }

    public void update() {
        execute();
    }
    public abstract void execute();
}
