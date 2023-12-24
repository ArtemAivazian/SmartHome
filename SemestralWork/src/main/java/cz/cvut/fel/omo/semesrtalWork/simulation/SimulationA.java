package cz.cvut.fel.omo.semesrtalWork.simulation;

import cz.cvut.fel.omo.semesrtalWork.Inhabitans.*;
import cz.cvut.fel.omo.semesrtalWork.events.*;
import cz.cvut.fel.omo.semesrtalWork.item.AItem;
import cz.cvut.fel.omo.semesrtalWork.item.Bike;
import cz.cvut.fel.omo.semesrtalWork.location.Floor;
import cz.cvut.fel.omo.semesrtalWork.location.House;
import cz.cvut.fel.omo.semesrtalWork.location.Room;
import cz.cvut.fel.omo.semesrtalWork.location.builder.FloorBuilder;
import cz.cvut.fel.omo.semesrtalWork.location.builder.HouseBuilder;
import cz.cvut.fel.omo.semesrtalWork.location.builder.RoomBuilder;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.ADevice;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.deviceState.DeviceBrokenState;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.deviceState.State;
import cz.cvut.fel.omo.semesrtalWork.observer.lightdevices.Lamp;
import cz.cvut.fel.omo.semesrtalWork.observer.noSensorDevs.Cattle;
import cz.cvut.fel.omo.semesrtalWork.observer.subjects.ASensor;
import cz.cvut.fel.omo.semesrtalWork.observer.subjects.HeatASensor;
import cz.cvut.fel.omo.semesrtalWork.observer.subjects.LightASensor;

import java.util.Timer;
import java.util.TimerTask;

public class SimulationA extends SimulationFactory{

    @Override
    public void create() {
        //      //Create sensors
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

        childRoom.addInhabitant(new Pet());
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
        Child child1 = new Child();
        childRoom.addInhabitant(child1);
        childRoom.addInhabitant(new Adult());
        lamp.changeState(new DeviceBrokenState(lamp, State.BROKEN));

        EventHandler eventHandler = new EventHandler();
        MakeFoodComposite makeFoodComposite = new MakeFoodComposite();
        TurnOnCattleCommand turnOnCattleCommand = new TurnOnCattleCommand(eventHandler);
        TurnOnMicrowaveCommand turnOnMicrowaveCommand = new TurnOnMicrowaveCommand(eventHandler);
        makeFoodComposite.add(turnOnCattleCommand);
        makeFoodComposite.add(turnOnMicrowaveCommand);
        child1.setCommand(makeFoodComposite);
        child1.executeCommand();
        child1.executeCommand();//error


        Cattle cattle = new Cattle();
        Adult adult = new Adult();
        adultRoom.addDevice(cattle);
        adultRoom.addInhabitant(adult);
        adult.setCommand(new TurnOnCattleCommand(eventHandler));
        adult.executeCommand();



        Bike bike = new Bike();
        adult.setCommand(new TakeBikeCommand(eventHandler));
        adult.executeCommand(bike);

        Pet cat = new Pet();
        adult.setCommand(new FeedPetCommand(eventHandler));
        adult.executeCommand(cat);
        // Initialize simulation state
        elapsedTime = 0;
        // Start the simulation
        run(house);
    }



    public void run(House house){

        double fps = 1000;
        long startTime = System.currentTimeMillis();
        long passedTime;

        while (true){
            passedTime = System.currentTimeMillis();
            if (passedTime- startTime > fps){
                elapsedTime++;
                updateHouseState(house);
                startTime = passedTime;
            }
        }
    }

    private void checkRapidActionCondition(House house){

    }
    private void updateHouseState(House house) {
        // Iterate over each room in the house
        for (Floor floor : house.getFloors()) {
            for (Room room : floor.getRooms()) {
                // Update sensors in the room
                for (ASensor sensor : room.getSensorsInRoom()) {
                    sensor.updateState(elapsedTime);
                }

                // Update devices in the room
                for (ADevice device : room.getDevicesInRoom()) {
                    device.updateState(elapsedTime);
                }

                // Update inhabitants in the room
                for (AInhabitant inhabitant : room.getInhabitantsInRoom()) {
                    inhabitant.updateState(elapsedTime);
                }
            }
        }
    }


    private void check(AInhabitant inhabitant){

    }

}
