package cz.cvut.fel.omo.semesrtalWork.location.builder;

import cz.cvut.fel.omo.semesrtalWork.Inhabitans.AInhabitant;
import cz.cvut.fel.omo.semesrtalWork.item.AItem;
import cz.cvut.fel.omo.semesrtalWork.location.Room;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.ADevice;
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
    public void addItem(AItem item) {
        room.addItem(item);
    }
    public void addInhabitant(AInhabitant inhabitant) {
        room.addInhabitant(inhabitant);
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
