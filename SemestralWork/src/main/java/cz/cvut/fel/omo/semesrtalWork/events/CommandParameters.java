package cz.cvut.fel.omo.semesrtalWork.events;

import cz.cvut.fel.omo.semesrtalWork.Inhabitans.Person;
import cz.cvut.fel.omo.semesrtalWork.Inhabitans.Pet;
import cz.cvut.fel.omo.semesrtalWork.item.Item;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.ADevice;

public class CommandParameters {
    private EventHandler handler;
    private Person person;
    private Item item;
    private ADevice ADevice;
    private Pet pet;


    public CommandParameters(EventHandler handler, Person person) {
        this.handler = handler;
        this.person = person;
    }
    public CommandParameters(EventHandler handler, Item item) {
        this.handler = handler;
        this.item = item;
    }

    public CommandParameters(EventHandler handler, ADevice ADevice) {
        this.handler = handler;
        this.ADevice = ADevice;
    }

    public CommandParameters(EventHandler handler, Pet pet) {
        this.handler = handler;
        this.pet = pet;
    }

    public ADevice getDevice() {
        return ADevice;
    }

    public Pet getPet() {
        return pet;
    }

    public EventHandler getHandler() {
        return handler;
    }
    public Person getPerson() {
        return person;
    }

    public Item getItem() {
        return item;
    }
}
