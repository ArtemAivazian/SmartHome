package cz.cvut.fel.omo.semesrtalWork.simulation;

import cz.cvut.fel.omo.semesrtalWork.Inhabitans.*;
import cz.cvut.fel.omo.semesrtalWork.events.*;
import cz.cvut.fel.omo.semesrtalWork.item.Item;
import cz.cvut.fel.omo.semesrtalWork.item.Skis;
import cz.cvut.fel.omo.semesrtalWork.location.Floor;
import cz.cvut.fel.omo.semesrtalWork.location.House;
import cz.cvut.fel.omo.semesrtalWork.location.Room;
import cz.cvut.fel.omo.semesrtalWork.location.builder.FloorBuilder;
import cz.cvut.fel.omo.semesrtalWork.location.builder.HouseBuilder;
import cz.cvut.fel.omo.semesrtalWork.location.builder.RoomBuilder;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.ADevice;
import cz.cvut.fel.omo.semesrtalWork.observer.heatdevices.Heater;
import cz.cvut.fel.omo.semesrtalWork.observer.lightdevices.Lamp;
import cz.cvut.fel.omo.semesrtalWork.observer.lightdevices.WindowBlind;
import cz.cvut.fel.omo.semesrtalWork.observer.noSensorDevs.Cattle;
import cz.cvut.fel.omo.semesrtalWork.observer.noSensorDevs.Microwave;
import cz.cvut.fel.omo.semesrtalWork.observer.subjects.ASensor;
import cz.cvut.fel.omo.semesrtalWork.observer.subjects.HeatSensor;
import cz.cvut.fel.omo.semesrtalWork.observer.subjects.LightSensor;
import java.util.Random;

public class SimulationA extends SimulationFactory{
    @Override
    public void create() {
//      //Create sensors
//        var heatSensor = new HeatASensor();
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
        HeatSensor heatASensor = new HeatSensor();
        LightSensor lightASensor = new LightSensor();
//        Lamp lamp = new Lamp(lightASensor);

//        roomBuilder.addSensor(lightASensor);
        houseBuilder.addSensor(heatASensor);
        houseBuilder.addSensor(lightASensor);

//        roomBuilder.addDevice(lamp);
//        Room childRoom = roomBuilder.getResult();

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

        Heater heaterJohn = new Heater(heatASensor);
        heatASensor.addHeatDevice(heaterJohn);
        Heater heaterKitchen = new Heater(heatASensor);
        heatASensor.addHeatDevice(heaterKitchen);
        johnRoom.addDevice(heaterJohn);
        kitchen.addDevice(heaterKitchen);


        Lamp lampKitchen = new Lamp(lightASensor);
        lightASensor.addLightDevice(lampKitchen);
        kitchen.addDevice(lampKitchen);

        WindowBlind windowBlindJohn = new WindowBlind(lightASensor);
        lightASensor.addLightDevice(windowBlindJohn);
        johnRoom.addDevice(windowBlindJohn);

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

        double fps = 500;
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
                for (Item item : room.getItemsInRoom()) {
                    if (item instanceof Skis && item.isFree) {
                        return (Skis) item;
                    }
                }
            }
        }
        return null;
    }

    private void updateHouseState(House house) {
        Random random = new Random();
        for (ASensor sensor : house.getSensorsOnHouse()) {
            if (sensor instanceof LightSensor){
                sensor.setValueLight(sensor.getValue() + random.nextInt(4) + 3);
                sensor.updateState(elapsedTime);
            }

            if (sensor instanceof HeatSensor){
                sensor.setValueHeat(sensor.getValue() + random.nextInt(4) + 8);
                sensor.updateState(elapsedTime);
            }
        }
        System.out.println(elapsedTime);
        if (elapsedTime == 9) { // 6 sec, it will ignore, because john will not be free at this time(he will eat food), 8 - skies are taken,because john will be free
            for (Floor floor : house.getFloors()) {
                for (Room room : floor.getRooms()) {
                    for (Person inhabitant : room.getPeopleInRoom()) {
                        if (inhabitant.isFree) {
                            Skis skis = findFreeSkis(house);
                            commandParameters = new CommandParameters(eventHandler, skis, inhabitant);
                            inhabitant.setCommand(new TakeSkisCommand(commandParameters));
                            inhabitant.executeCommand();
                        }
                    }
                }
            }
        }
        // Iterate over each room in the house
        for (Floor floor : house.getFloors()) {

            for (ASensor sensor : floor.getSensorsOnFloor()) {
                sensor.updateState(elapsedTime);
            }
            for (Room room : floor.getRooms()) {
                // Update sensors in the room
                for (ASensor sensor : room.getSensorsInRoom()) {
                    sensor.updateState(elapsedTime);
                }

                // Update devices in the room
                for (ADevice ADevice : room.getDevicesInRoom()) {
                    ADevice.updateState(elapsedTime);
                }

                // Update inhabitants in the room
                for (Person inhabitant : room.getPeopleInRoom()) {
                    inhabitant.updateState(elapsedTime);
                    checkPerson(inhabitant, house);
                }
                for (Pet pet : room.getPetInRoom()) {
                    pet.updateState(elapsedTime);
                    checkPet(pet, house);
                }
                for (Item item : room.getItemsInRoom()) {
                    item.updateState(elapsedTime);
                }
            }
        }
    }


    private void checkPerson(Person person, House house){
        if (person.isFree()){
            if (person.isHungry()){
                commandParameters = new CommandParameters(eventHandler, person);
                MakeBreakfastCommand makeBreakfastCommand = new MakeBreakfastCommand(commandParameters);
                Cattle cattle = findFreeCattle(house);
                Microwave microwave = findFreeMicrowave(house);
                commandParameters = new CommandParameters(eventHandler, cattle);
                makeBreakfastCommand.add(new TurnOnCattleCommand(commandParameters));
                makeBreakfastCommand.add(new MakeTeaCommand(commandParameters));
                commandParameters = new CommandParameters(eventHandler, microwave);
                makeBreakfastCommand.add(new TurnOnMicrowaveCommand(commandParameters));
                makeBreakfastCommand.add(new WarmUpFoodCommand(commandParameters));
                //TO-DO add off cattle and off microwave
                commandParameters = new CommandParameters(eventHandler, cattle);
                TurnOffCattleCommand offCattle = new TurnOffCattleCommand(commandParameters);
                commandParameters = new CommandParameters(eventHandler, microwave);
                TurnOffMicrowaveCommand offMicrowave = new TurnOffMicrowaveCommand(commandParameters);

                //make breakfast
                person.setCommand(makeBreakfastCommand);
                person.executeCommand();

                //turn off devices
                person.setCommand(offCattle);
                person.executeCommand();
                person.setCommand(offMicrowave);
                person.executeCommand();
            }

        }
    }

    private void checkPet(Pet pet, House house){
        Adult adult = findFreeAdult(house);
        if (pet.isHungry() && adult != null){
            commandParameters = new CommandParameters(eventHandler, adult, pet);
            FeedPetCommand feedPetCommand = new FeedPetCommand(commandParameters);
            adult.setCommand(feedPetCommand);
            adult.executeCommand();
        }
    }

    private Microwave findFreeMicrowave(House house) {
        for (Floor floor : house.getFloors()) {
            for (Room room : floor.getRooms()) {
                for (ADevice ADevice : room.getDevicesInRoom()) {
                    if (ADevice instanceof Microwave && ADevice.isFree) {
                        return (Microwave) ADevice;
                    }
                }
            }
        }
        return null;
    }

    private Cattle findFreeCattle(House house) {
        for (Floor floor : house.getFloors()) {
            for (Room room : floor.getRooms()) {
                for (ADevice ADevice : room.getDevicesInRoom()) {
                    if (ADevice instanceof Cattle && ADevice.isFree) {
                        return (Cattle) ADevice;
                    }
                }
            }
        }
        return null;
    }

    private Adult findFreeAdult(House house) {
        for (Floor floor : house.getFloors()) {
            for (Room room : floor.getRooms()) {
                for (Person person : room.getPeopleInRoom()) {
                    if (person instanceof Adult && person.isFree) {
                        return (Adult) person;
                    }
                }
            }
        }
        return null;
    }

}
