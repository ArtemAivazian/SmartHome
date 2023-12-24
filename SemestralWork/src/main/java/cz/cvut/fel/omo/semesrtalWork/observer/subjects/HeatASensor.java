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
    public void updateState(double elapsedTime) {
        functionality -= 0.0000001;
        electricityConsumption += 0.1;
    }
}
