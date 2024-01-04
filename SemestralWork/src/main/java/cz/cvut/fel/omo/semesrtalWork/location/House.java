package cz.cvut.fel.omo.semesrtalWork.location;

import cz.cvut.fel.omo.semesrtalWork.observer.subjects.ASensor;

import java.util.ArrayList;
import java.util.List;

public class House {
    private List<Floor> floors = new ArrayList<>();
    private List<ASensor> sensorsOnHouse = new ArrayList<>();
    private String address;

    public void addFloor(Floor floor) {
        floors.add(floor);
    }
    public void addSensor(ASensor sensor) {
        sensorsOnHouse.add(sensor);
    }

    public List<ASensor> getSensorsOnHouse() {
        return sensorsOnHouse;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
