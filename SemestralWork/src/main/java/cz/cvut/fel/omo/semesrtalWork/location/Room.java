package cz.cvut.fel.omo.semesrtalWork.location;

import cz.cvut.fel.omo.semesrtalWork.Inhabitans.AInhabitant;
import cz.cvut.fel.omo.semesrtalWork.observer.observers.ADevice;
import cz.cvut.fel.omo.semesrtalWork.observer.subjects.ASensor;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private List<ASensor> sensorsInRoom= new ArrayList<>();
    private List<AInhabitant> inhabitantsInRoom = new ArrayList<>();
    private List<ADevice> devicesInRoom = new ArrayList<>();

    public void addSensor(ASensor sensor) {
        sensorsInRoom.add(sensor);
    }
    public void addDevice(ADevice device) {
        devicesInRoom.add(device);
    }




}
