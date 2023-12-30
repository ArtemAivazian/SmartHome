package cz.cvut.fel.omo.semesrtalWork.simulation;

import cz.cvut.fel.omo.semesrtalWork.Inhabitans.*;
import cz.cvut.fel.omo.semesrtalWork.events.*;
import cz.cvut.fel.omo.semesrtalWork.item.AItem;
import cz.cvut.fel.omo.semesrtalWork.item.Bike;
import cz.cvut.fel.omo.semesrtalWork.item.Skis;
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
import cz.cvut.fel.omo.semesrtalWork.observer.noSensorDevs.Microwave;
import cz.cvut.fel.omo.semesrtalWork.observer.subjects.ASensor;
import cz.cvut.fel.omo.semesrtalWork.observer.subjects.HeatASensor;
import cz.cvut.fel.omo.semesrtalWork.observer.subjects.LightASensor;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class SimulationA extends SimulationFactory{
    protected EventHandler eventHandler = new EventHandler();
    private CommandParameters commandParameters;
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
//        LightASensor lightASensor = new LightASensor();
//        HeatASensor heatASensor = new HeatASensor();
//        Lamp lamp = new Lamp(lightASensor);

//        roomBuilder.addSensor(lightASensor);
//        roomBuilder.addSensor(heatASensor);
//        roomBuilder.addDevice(lamp);
//        Room childRoom = roomBuilder.getResult();

//        roomBuilder.addSensor(new HeatASensor());
//        Room adultRoom = roomBuilder.getResult();
        Skis skis = new Skis();
        roomBuilder.addItem(skis);
        Room storage = roomBuilder.getResult();


        Cattle cattle = new Cattle();
        Microwave microwave = new Microwave();
        roomBuilder.addDevice(cattle);
        roomBuilder.addDevice(microwave);
        Room kitchen = roomBuilder.getResult();

        Adult john = new Adult();
        Pet cat = new Pet();
        roomBuilder.addPerson(john);
        roomBuilder.addPet(cat);
        Room johnRoom = roomBuilder.getResult();

        //Floors
//        floorBuilder.addRoom(childRoom);
        floorBuilder.addRoom(storage);
        floorBuilder.addRoom(kitchen);
        floorBuilder.addRoom(johnRoom);
//        floorBuilder.addSensor(new LightASensor());
        Floor first = floorBuilder.getResult();

        //House
//        houseBuilder.addSensor(new HeatASensor());
//        houseBuilder.addSensor(new LightASensor());
        houseBuilder.addFloor(first);
        House house = houseBuilder.getResult();


//        childRoom.addSensor(new LightASensor());
//        lamp.changeState(new DeviceBrokenState(lamp, State.BROKEN));
//
//        Cattle cattle = new Cattle();
//        Adult adult = new Adult();
//        adultRoom.addDevice(cattle);
//        adultRoom.addPerson(adult);



//        Pet cat = new Pet();
//        adultRoom.addPet(cat);



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

    private Skis findFreeSkis(House house)  {
        for (Floor floor : house.getFloors()) {
            for (Room room : floor.getRooms()) {
                for (AItem item : room.getItemsInRoom()) {
                    if (item instanceof Skis && item.isFree) {
                        return (Skis) item;
                    }
                }
            }
        }
        return null;
    }

    private void updateHouseState(House house) {
        System.out.println(elapsedTime);
        if (elapsedTime == 8) { // 6 sec, it will ignore, because john will not be free at this time(he will eat food), 8 - skies are taken,because john will be free
            for (Floor floor : house.getFloors()) {
                for (Room room : floor.getRooms()) {
                    for (Person inhabitant : room.getPeopleInRoom()) {
                        if (inhabitant.isFree) {
                            Skis skis = findFreeSkis(house);
                            commandParameters = new CommandParameters(eventHandler, skis);
                            inhabitant.setCommand(new TakeSkisCommand(commandParameters));
                            inhabitant.executeCommand();
                        }
                    }
                }
            }
        }
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
                for (Person inhabitant : room.getPeopleInRoom()) {
                    inhabitant.updateState(elapsedTime);
                    check(inhabitant, house);
                }
                for (Pet pet : room.getPetInRoom()) {
                    pet.updateState(elapsedTime);
                }
            }
        }
    }


    private void check(Person person, House house){
        if (person.isFree()){
            if (person.isHungry()){
                commandParameters = new CommandParameters(eventHandler, person);
                MakeFoodCommand makeFoodCommand = new MakeFoodCommand(commandParameters);
                Cattle cattle = findFreeCattle(house);
                Microwave microwave = findFreeMicrowave(house);
                commandParameters = new CommandParameters(eventHandler, cattle);
                makeFoodCommand.add(new TurnOnCattleCommand(commandParameters));
                makeFoodCommand.add(new MakeTeaCommand(commandParameters));
                commandParameters = new CommandParameters(eventHandler, microwave);
                makeFoodCommand.add(new TurnOnMicrowaveCommand(commandParameters));
                makeFoodCommand.add(new WarmUpFoodCommand(commandParameters));
                //TO-DO add off cattle and off microwave
                person.setCommand(makeFoodCommand);
                person.executeCommand();
            }

        }
    }

    private Microwave findFreeMicrowave(House house) {
        for (Floor floor : house.getFloors()) {
            for (Room room : floor.getRooms()) {
                for (ADevice device : room.getDevicesInRoom()) {
                    if (device instanceof Microwave && device.isFree) {
                        return (Microwave) device;
                    }
                }
            }
        }
        return null;
    }

    private Cattle findFreeCattle(House house) {
        for (Floor floor : house.getFloors()) {
            for (Room room : floor.getRooms()) {
                for (ADevice device : room.getDevicesInRoom()) {
                    if (device instanceof Cattle && device.isFree) {
                        return (Cattle) device;
                    }
                }
            }
        }
        return null;
    }

}
