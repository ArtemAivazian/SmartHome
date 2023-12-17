package cz.cvut.fel.omo.semesrtalWork.location;

import cz.cvut.fel.omo.semesrtalWork.observer.observers.ADevice;
import cz.cvut.fel.omo.semesrtalWork.observer.subjects.ASensor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class House {
    private List<Floor> floors = new ArrayList<>();
    private List<ASensor> sensorsOnHouse = new ArrayList<>();

    public void addFloor(Floor floor) {
        floors.add(floor);
    }
    public void addSensor(ASensor sensor) {
        sensorsOnHouse.add(sensor);
    }
}
