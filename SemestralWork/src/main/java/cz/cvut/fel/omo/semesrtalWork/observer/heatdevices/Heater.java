package cz.cvut.fel.omo.semesrtalWork.observer.heatdevices;

import cz.cvut.fel.omo.semesrtalWork.observer.observers.HeatAbstract;
import cz.cvut.fel.omo.semesrtalWork.observer.subjects.HeatSensor;
import cz.cvut.fel.omo.semesrtalWork.observer.subjects.LightSensor;

public class Heater extends HeatAbstract {

    private HeatSensor heatSensor;
    private int treasholder = 5;
    public Heater(HeatSensor heatSensor) {
        this.heatSensor = heatSensor;
    }

    public Heater(HeatSensor heatSensor, int treasholder) {
        this.heatSensor = heatSensor;
        this.treasholder = treasholder;
    }

    @Override
    public void execute() {
        if (heatSensor.getValue() < treasholder)
            System.out.println("Heater has been turned on");
        else
            System.out.println("Heater has been turned off");
    }
}
