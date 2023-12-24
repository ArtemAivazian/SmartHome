package cz.cvut.fel.omo.semesrtalWork.events;

import cz.cvut.fel.omo.semesrtalWork.observer.devices.ADevice;

public class EventHandler {
    public void turnOnCattle() {
        System.out.println("TurnOnCattle");
    }
    public void turnOnMicrowave() {
        System.out.println("TurnOnMicrowave");
    }
    public void turnOffMicrowave() {
        System.out.println("TurnOffMicrowave");
    }

    public void turnOffCattle() {
        System.out.println("TurnOffCattle");
    }

    public void takeSkies() {
        System.out.println("Skis are taken");
    }

    public void feedPet() {
        System.out.println("Feeding pet");
    }

    public void eatFood() {
        System.out.println("Person is eating food");
    }
}
