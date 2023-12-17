package cz.cvut.fel.omo.semesrtalWork.observer.subjects;

public class HeatASensor extends ASensor {
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        notifyHeatDevices();
    }

    @Override
    public void build() {
        System.out.println("Create HeatSensor");
    }
}
