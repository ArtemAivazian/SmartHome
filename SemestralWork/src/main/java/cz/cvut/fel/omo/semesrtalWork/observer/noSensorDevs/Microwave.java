package cz.cvut.fel.omo.semesrtalWork.observer.noSensorDevs;

import cz.cvut.fel.omo.semesrtalWork.observer.devices.ADevice;

public class Microwave extends ADevice {

    public Microwave(double electricityConsumption, double functionality) {
        super(electricityConsumption, 0, 0, functionality);
    }

    @Override
    public void updateState(double elapsedTime) {

    }
}
