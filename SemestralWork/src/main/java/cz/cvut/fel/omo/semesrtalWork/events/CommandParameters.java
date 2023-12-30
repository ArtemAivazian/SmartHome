package cz.cvut.fel.omo.semesrtalWork.events;

import cz.cvut.fel.omo.semesrtalWork.Inhabitans.Person;
import cz.cvut.fel.omo.semesrtalWork.Inhabitans.Pet;
import cz.cvut.fel.omo.semesrtalWork.item.AItem;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.ADevice;
import cz.cvut.fel.omo.semesrtalWork.simulation.AAction;

public class CommandParameters {
    private EventHandler handler;
    private Person person;
    private AItem item;
    private ADevice device;
    private Pet pet;


    public CommandParameters(EventHandler handler, Person person) {
        this.handler = handler;
        this.person = person;
    }
    public CommandParameters(EventHandler handler, AItem item) {
        this.handler = handler;
        this.item = item;
    }

    public CommandParameters(EventHandler handler, ADevice device) {
        this.handler = handler;
        this.device = device;
    }

    public CommandParameters(EventHandler handler, Pet pet) {
        this.handler = handler;
        this.pet = pet;
    }

    public ADevice getDevice() {
        return device;
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

    public AItem getItem() {
        return item;
    }
}
