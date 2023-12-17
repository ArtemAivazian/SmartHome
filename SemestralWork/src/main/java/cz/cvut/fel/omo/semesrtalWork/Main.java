package cz.cvut.fel.omo.semesrtalWork;

import cz.cvut.fel.omo.semesrtalWork.Inhabitans.Adult;
import cz.cvut.fel.omo.semesrtalWork.Inhabitans.Child;
import cz.cvut.fel.omo.semesrtalWork.Inhabitans.Pet;
import cz.cvut.fel.omo.semesrtalWork.item.Bike;
import cz.cvut.fel.omo.semesrtalWork.location.Floor;
import cz.cvut.fel.omo.semesrtalWork.location.House;
import cz.cvut.fel.omo.semesrtalWork.location.Room;
import cz.cvut.fel.omo.semesrtalWork.location.builder.*;
import cz.cvut.fel.omo.semesrtalWork.observer.lightdevices.Lamp;
import cz.cvut.fel.omo.semesrtalWork.observer.subjects.HeatASensor;
import cz.cvut.fel.omo.semesrtalWork.observer.subjects.LightASensor;

public class Main {
    public static void main(String[] args) {

//        //Create sensors
//        var heatSensor = new HeatSensor();
//        var lightSensor = new LightSensor();
//
//        //Create heat devices
//        var heater = new Heater(heatSensor);
//        //Create light devices
//        var lamp = new Lamp(lightSensor);
//        var solarPanel = new SolarPanel(lightSensor);
//        var windowBlind = new WindowBlind(lightSensor);
//
//        //Add to the light sensor light devices
//        lightSensor.addLightDevice(lamp);
//        lightSensor.addLightDevice(solarPanel);
//        lightSensor.addLightDevice(windowBlind);
//
//        //Add to the heat sensor heat devices
//        heatSensor.addHeatDevice(heater);
//
//        //set light sensor to 100
//        lightSensor.setValue(0);
//        heatSensor.setValue(10);

//        var handler = new EventHandler();
//        var feed_pet = new FeedPetCommand(handler);
//        var take_skis = new TakeSkisCommand(handler);
//        var pedro = new Adult();
//
//
//        //feeding executing
//        pedro.setCommand(feed_pet);
//        pedro.invokeEvent();
//
//        //taking skis executing
//        pedro.setCommand(take_skis);
//        pedro.invokeEvent();

        //Builders
        HouseBuilder houseBuilder = new HouseBuilder();
        FloorBuilder floorBuilder = new FloorBuilder();
        RoomBuilder roomBuilder = new RoomBuilder();

        //Rooms
        LightASensor lightASensor = new LightASensor();
        HeatASensor heatASensor = new HeatASensor();
        Lamp lamp = new Lamp(lightASensor);

        roomBuilder.addSensor(lightASensor);
        roomBuilder.addSensor(heatASensor);
        roomBuilder.addDevice(lamp);
        Room childRoom = roomBuilder.getResult();

        childRoom.addInhabitand(new Pet());
        roomBuilder.addSensor(new HeatASensor());
        Room adultRoom = roomBuilder.getResult();

        //Floors
        floorBuilder.addRoom(childRoom);
        floorBuilder.addRoom(adultRoom);
        floorBuilder.addSensor(new LightASensor());
        Floor first = floorBuilder.getResult();

        //House
        houseBuilder.addSensor(new HeatASensor());
        houseBuilder.addSensor(new LightASensor());
        houseBuilder.addFloor(first);
        House house = houseBuilder.getResult();


        childRoom.addSensor(new LightASensor());
        childRoom.addItem(new Bike());
        childRoom.addInhabitand(new Child());
        childRoom.addInhabitand(new Adult());





    }
}