package cz.cvut.fel.omo.semesrtalWork.location.builder;

import cz.cvut.fel.omo.semesrtalWork.location.Floor;
import cz.cvut.fel.omo.semesrtalWork.location.Room;
import cz.cvut.fel.omo.semesrtalWork.observer.observers.ADevice;
import cz.cvut.fel.omo.semesrtalWork.observer.subjects.ASensor;

public class RoomBuilder implements IBuilder{
    private Room room;
    public RoomBuilder() {
        this.reset();
    }
    @Override
    public void addSensor(ASensor sensor) {
        room.addSensor(sensor);
    }
    public void addDevice(ADevice device) {
        room.addDevice(device);
    }

    public void reset() {
        this.room = new Room();
    }
    public Room getResult() {
        Room result = room;
        reset();
        return result;
    }
}
