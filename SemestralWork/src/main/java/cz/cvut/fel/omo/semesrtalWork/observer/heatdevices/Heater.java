package cz.cvut.fel.omo.semesrtalWork.observer.heatdevices;

import cz.cvut.fel.omo.semesrtalWork.observer.observers.HeatAbstract;
import cz.cvut.fel.omo.semesrtalWork.observer.subjects.HeatASensor;

public class Heater extends HeatAbstract {

    private HeatASensor heatSensor;
    private int treasholder = 5;
    public Heater(HeatASensor heatSensor) {
        this.heatSensor = heatSensor;
    }

    public Heater(HeatASensor heatSensor, int treasholder) {
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
