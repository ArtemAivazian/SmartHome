package cz.cvut.fel.omo.semesrtalWork.location.builder;

import cz.cvut.fel.omo.semesrtalWork.Inhabitans.Person;
import cz.cvut.fel.omo.semesrtalWork.Inhabitans.Pet;
import cz.cvut.fel.omo.semesrtalWork.item.Item;
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
    public void addDevice(ADevice ADevice) {
        room.addDevice(ADevice);
    }
    public void addItem(Item item) {
        room.addItem(item);
    }
    public void addPerson(Person person) {
        room.addPerson(person);
    }
    public void addPet(Pet pet) {
        room.addPet(pet);
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
