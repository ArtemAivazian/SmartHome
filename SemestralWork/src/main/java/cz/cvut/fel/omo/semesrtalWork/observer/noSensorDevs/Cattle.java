package cz.cvut.fel.omo.semesrtalWork.observer.noSensorDevs;

import cz.cvut.fel.omo.semesrtalWork.observer.Threshold;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.ADevice;

public class Cattle extends ADevice {


    public Cattle(double electricityConsumption, double functionality) {
        super(electricityConsumption, 0, 0, functionality);
    }


    @Override
    public void updateState(double elapsedTime) {
        electricityConsumption -= elapsedTime * 0.1;
        functionality -= elapsedTime * 0.15;
    }
}
