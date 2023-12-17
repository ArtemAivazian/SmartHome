package cz.cvut.fel.omo.semesrtalWork.location.builder;

import cz.cvut.fel.omo.semesrtalWork.location.Floor;
import cz.cvut.fel.omo.semesrtalWork.location.House;
import cz.cvut.fel.omo.semesrtalWork.location.Room;
import cz.cvut.fel.omo.semesrtalWork.observer.subjects.ASensor;

public class FloorBuilder implements IBuilder{
    private Floor floor;
    public FloorBuilder() {
       this.reset();
    }
    public void addRoom(Room room) {
        floor.addRoom(room);
    }
    @Override
    public void addSensor(ASensor sensor) {
        floor.addSensor(sensor);
    }
    public void reset() {
        this.floor = new Floor();
    }
    public Floor getResult() {
        return floor;
    }


}
