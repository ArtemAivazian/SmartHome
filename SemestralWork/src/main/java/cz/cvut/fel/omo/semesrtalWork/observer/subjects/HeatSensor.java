package cz.cvut.fel.omo.semesrtalWork.observer.subjects;

public class HeatSensor extends Sensor {
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        notifyHeatDevices();
    }
}
