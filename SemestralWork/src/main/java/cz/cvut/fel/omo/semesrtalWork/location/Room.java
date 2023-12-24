package cz.cvut.fel.omo.semesrtalWork.location;

import cz.cvut.fel.omo.semesrtalWork.Inhabitans.Person;
import cz.cvut.fel.omo.semesrtalWork.Inhabitans.Pet;
import cz.cvut.fel.omo.semesrtalWork.item.AItem;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.ADevice;
import cz.cvut.fel.omo.semesrtalWork.observer.subjects.ASensor;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private List<ASensor> sensorsInRoom= new ArrayList<>();
    private List<Person> peopleInRoom = new ArrayList<>();
    private List<Pet> petInRoom = new ArrayList<>();
    private List<ADevice> devicesInRoom = new ArrayList<>();
    private List<AItem> itemsInRoom = new ArrayList<>();

    public void addSensor(ASensor sensor) {
        sensorsInRoom.add(sensor);
    }
    public void addDevice(ADevice device) {
        devicesInRoom.add(device);
    }
    public void addItem(AItem item) {
        itemsInRoom.add(item);
    }
    public void addPerson(Person person) {
        peopleInRoom.add(person);
    }
    public void addPet(Pet pet) {
        petInRoom.add(pet);
    }


    public List<ADevice> getDevicesInRoom() {
        return devicesInRoom;
    }
    public List<ASensor> getSensorsInRoom() {
        return sensorsInRoom;
    }
    public List<AItem> getItemsInRoom() {
        return itemsInRoom;
    }
    public List<Person> getPeopleInRoom() {
        return peopleInRoom;
    }
    public List<Pet> getPetInRoom() {
        return petInRoom;
    }
}
