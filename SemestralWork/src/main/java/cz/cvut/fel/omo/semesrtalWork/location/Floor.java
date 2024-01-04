package cz.cvut.fel.omo.semesrtalWork.location;

import cz.cvut.fel.omo.semesrtalWork.observer.subjects.ASensor;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private List<Room> rooms = new ArrayList<>();
    private List<ASensor> sensorsOnFloor = new ArrayList<>();


    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void addSensor(ASensor sensor) {
        sensorsOnFloor.add(sensor);
    }

    public List<ASensor> getSensorsOnFloor() {
        return sensorsOnFloor;
    }

    public List<Room> getRooms() {
        return rooms;
    }
}
