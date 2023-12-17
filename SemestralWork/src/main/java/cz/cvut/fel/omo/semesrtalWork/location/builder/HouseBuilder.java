package cz.cvut.fel.omo.semesrtalWork.location.builder;

import cz.cvut.fel.omo.semesrtalWork.location.Floor;
import cz.cvut.fel.omo.semesrtalWork.location.House;
import cz.cvut.fel.omo.semesrtalWork.observer.observers.ADevice;
import cz.cvut.fel.omo.semesrtalWork.observer.subjects.ASensor;

public class HouseBuilder implements IBuilder{
    private House house;

    public HouseBuilder() {
        this.reset();
    }

    public void reset() {
        house = new House();
    }

    public void addFloor(Floor floor) {
        house.addFloor(floor);
    }
    @Override
    public void addSensor(ASensor sensor) {
        house.addSensor(sensor);
    }

    public House getResult() {
        House result = house;
        reset();
        return result;
    }
}
