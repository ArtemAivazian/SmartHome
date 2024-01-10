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

import java.io.IOException;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class SimulationA extends SimulationFactory{

    private static final Logger logger = Logger.getLogger(SimulationA.class.getName());
    private static final String LOG_FILE = "report.txt";

    public SimulationA() {
        configureLogger();
    }

    private void configureLogger() {
        try {
            FileHandler fileHandler = new FileHandler(LOG_FILE, true);
            SimpleFormatter simpleFormatter = new SimpleFormatter();
            fileHandler.setFormatter(simpleFormatter);
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void logHouseConfigurationReport(House house) {
        StringBuilder report = new StringBuilder("HouseConfigurationReport: Configuration data of the house\n");
        // Log house configuration data, including hierarchy and inhabitants
        report.append("House Name: " + house.getAddress() + "\n");
        for (ASensor sensor : house.getSensorsOnHouse()) {
            report.append("Sensor Type: " + sensor.getType() + ". Has been added on house by address: " + house.getAddress() + "\n");
        }
        for (Floor floor : house.getFloors()) {

            for (ASensor sensor : floor.getSensorsOnFloor()) {
                report.append("Sensor Type: " + sensor.getType() + ". Has been added on the " + floor.getLevel() + " floor\n");
            }
            for (Room room : floor.getRooms()) {
                for (ASensor sensor : room.getSensorsInRoom()) {
                    report.append("Sensor Type: " + sensor.getType() + ". Has been added to the " + room.getName() + "\n");
                }

                for (ADevice device : room.getDevicesInRoom()) {
                    report.append("Device Type: " + device.getType() + ". Has been added to the " + room.getName() + "\n");
                }

                for (Person person : room.getPeopleInRoom()) {
                    report.append("Person: " + person.getName() + ". Has been added to the " + room.getName() + "\n");
                }
                for (Pet pet : room.getPetInRoom()) {
                    report.append("Pet: " + pet.getName() + ". Has been added to the " + room.getName() + "\n");
                }
                for (Item item : room.getItemsInRoom()) {
                    report.append("Item Type: " + item.getType() + ". Has been added to the " + room.getName() + "\n");
                }
            }
        }

        log(report.toString());
    }

    private void logEventReport(House house) {
        StringBuilder report = new StringBuilder("EventReport: Event details\n");
        for (ASensor sensor : house.getSensorsOnHouse()) {
            if (sensor.isTurnOn()) {
                report.append("Sensor: " + sensor.getType() + " is turn on\n");
            }else {
                report.append("Sensor: " + sensor.getType() + " is turn off\n");
            }
        }
        for (Floor floor : house.getFloors()) {
            for (ASensor sensor : floor.getSensorsOnFloor()) {
                if (sensor.isTurnOn()) {
                    report.append("Sensor: " + sensor.getType() + " is turn on\n");
                }else {
                    report.append("Sensor: " + sensor.getType() + " is turn off\n");
                }
            }
            for (Room room : floor.getRooms()) {
                for (ASensor sensor : room.getSensorsInRoom()) {
                    if (sensor.isTurnOn()) {
                        report.append("Sensor: " + sensor.getType() + " is turn on\n");
                    } else {
                        report.append("Sensor: " + sensor.getType() + " is turn off\n");
                    }
                }
                for (ADevice device : room.getDevicesInRoom()) {
                    if (!device.isFree) {
                        report.append("Device: " + device.getType() + " is not available\n");
                    } else {
                        report.append("Device: " + device.getType() + " is available\n");
                    }
                }
                for (Person person : room.getPeopleInRoom()) {
                    if (!person.isFree){
                        report.append("Person: " + person.getName() + " is not available\n");
                    } else
                    {
                        report.append("Person: " + person.getName() + " is available\n");
                    }
                }
                for (Pet pet : room.getPetInRoom()) {
                    if (!pet.isFree){
                        report.append("Pet: " + pet.getName() + " is not available\n");
                    }
                    else {
                        report.append("Pet: " + pet.getName() + " is available\n");
                    }
                }
                for (Item item : room.getItemsInRoom()) {
                    if (!item.isFree()){
                        report.append("Item: " + item.getType() + " is not available\n");
                    }
                    else {
                        report.append("Item: " + item.getType() + " is available\n");
                    }
                }
            }
        }

        log(report.toString());
    }

    private void logActivityAndUsageReport(House house) {
        StringBuilder report = new StringBuilder("ActivityAndUsageReport: Activity and Usage details\n");
        for (Floor floor : house.getFloors()) {
            for (Room room : floor.getRooms()) {
                for (ADevice device : room.getDevicesInRoom()) {
                    report.append("Device: " + device.getType() + "\n");
                    report.append("Usage Count: " + device.getUsageCout() + "\n");
                    report.append("---------------------------------------------------\n");
                }
            }
        }
        log(report.toString());
    }

    private void logConsumptionReport(House house) {
        StringBuilder report = new StringBuilder("ConsumptionReport: Consumption details\n");
        for (ASensor sensor : house.getSensorsOnHouse()) {
            report.append("Sensor: " + sensor.getType() + "\n");
            report.append("Electricity Consumption: " + sensor.getElectricityConsumption() + " kWh\n");
            report.append("Gas Consumption: " + sensor.getGasConsumption() + " cubic meters\n");
            report.append("Water Consumption: " + sensor.getWaterConsumption() + " liters\n");
            report.append("Functionality: " + sensor.getFunctionality() + " %\n");
            report.append("---------------------------------------------------\n");
        }
        for (Floor floor : house.getFloors()) {
            for (ASensor sensor : floor.getSensorsOnFloor()) {
                report.append("Sensor: " + sensor.getType() + "\n");
                report.append("Electricity Consumption: " + sensor.getElectricityConsumption() + " kWh\n");
                report.append("Gas Consumption: " + sensor.getGasConsumption() + " cubic meters\n");
                report.append("Water Consumption: " + sensor.getWaterConsumption() + " liters\n");
                report.append("Functionality: " + sensor.getFunctionality() + " %\n");
                report.append("---------------------------------------------------\n");
            }
            for (Room room : floor.getRooms()) {
                for (ASensor sensor : room.getSensorsInRoom()) {
                    report.append("Sensor: " + sensor.getType() + "\n");
                    report.append("Electricity Consumption: " + sensor.getElectricityConsumption() + " kWh\n");
                    report.append("Gas Consumption: " + sensor.getGasConsumption() + " cubic meters\n");
                    report.append("Water Consumption: " + sensor.getWaterConsumption() + " liters\n");
                    report.append("Functionality: " + sensor.getFunctionality() + " %\n");
                    report.append("---------------------------------------------------\n");
                }
                for (ADevice device : room.getDevicesInRoom()) {
                    report.append("Device: " + device.getType() + "\n");
                    report.append("Electricity Consumption: " + device.getElectricityConsumption()+ " kWh\n");
                    report.append("Gas Consumption: " + device.getGasConsumption() + " cubic meters\n");
                    report.append("Water Consumption: " + device.getWaterConsumption() + " liters\n");
                    report.append("Functionality: " + device.getFunctionality() + " %\n");
                    report.append("---------------------------------------------------\n");
                }
            }
        }

        log(report.toString());
    }

    private void log(String message) {
        logger.info(message);
    }

    @Override
    public void create() {
        //Builders
        HouseBuilder houseBuilder = new HouseBuilder();
        FloorBuilder floorBuilder = new FloorBuilder();
        RoomBuilder roomBuilder = new RoomBuilder();

        //Rooms
        HeatSensor heatSensor = new HeatSensor();
        heatSensor.setType("Heat Sensor");
        LightSensor lightSensor = new LightSensor();
        lightSensor.setType("Light Sensor");

        houseBuilder.addSensor(heatSensor);
        houseBuilder.addSensor(lightSensor);

        Skis skis = new Skis();
        skis.setType("Skies");
        roomBuilder.addItem(skis);
        Room storage = roomBuilder.getResult();
        storage.setName("Storage");


        Cattle cattle = new Cattle();
        cattle.setType("Cattle");
        Microwave microwave = new Microwave();
        microwave.setType("Microwave");
        roomBuilder.addDevice(cattle);
        roomBuilder.addDevice(microwave);
        Room kitchen = roomBuilder.getResult();
        kitchen.setName("Kitchen");

        Adult john = new Adult("John");
        Pet cat = new Pet("Marco");
        roomBuilder.addPerson(john);
        roomBuilder.addPet(cat);
        Room johnRoom = roomBuilder.getResult();
        johnRoom.setName("John Room");

        //Floors
        floorBuilder.addRoom(storage);
        floorBuilder.addRoom(kitchen);
        floorBuilder.addRoom(johnRoom);
        Floor first = floorBuilder.getResult();
        first.setLevel(1);

        Heater heaterJohn = new Heater(heatSensor);
        heaterJohn.setType("Heat Device");
        heatSensor.addHeatDevice(heaterJohn);
        Heater heaterKitchen = new Heater(heatSensor);
        heaterKitchen.setType("Heat Device");
        heatSensor.addHeatDevice(heaterKitchen);
        johnRoom.addDevice(heaterJohn);
        kitchen.addDevice(heaterKitchen);


        Lamp lampKitchen = new Lamp(lightSensor);
        lampKitchen.setType("Lamp");
        lightSensor.addLightDevice(lampKitchen);
        kitchen.addDevice(lampKitchen);

        WindowBlind windowBlindJohn = new WindowBlind(lightSensor);
        windowBlindJohn.setType("Window Blind");
        lightSensor.addLightDevice(windowBlindJohn);
        johnRoom.addDevice(windowBlindJohn);

        //House
        houseBuilder.addFloor(first);
        House house = houseBuilder.getResult();
        house.setAddress("Dejvicka 6, Praha 6, 16000");

        // Initialize simulation state
        elapsedTime = 0;
        // Start the simulation
        log("Start simulation!");
        logHouseConfigurationReport(house);
        run(house);
    }
    public void run(House house){

        double fps = 100;
        long startTime = System.currentTimeMillis();
        long passedTime;

        while (true){
            passedTime = System.currentTimeMillis();
            if (passedTime- startTime > fps){
                if (elapsedTime % 15 == 0 && elapsedTime != 0) {
                    logConsumptionReport(house);
                    logActivityAndUsageReport(house);
                    logEventReport(house);
                }
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
//        parameters.getDevice().setActionTime(2);
//        parameters.getDevice().setFree(false);
        //turn off
        for (Floor floor : house.getFloors()) {
            for (Room room : floor.getRooms()) {
                // Update devices in the room
                for (ADevice device : room.getDevicesInRoom()) {
                    if (!device.isFree && device.getActionTime() == 0) {
                        //no command because it is Smart House and nobody is needed to turn Off a device
                        device.stopUsage();
                        device.setFree(true);
                        System.out.println("Turn off " + device.getType());
                        device.updateState(elapsedTime);
                    }
                }
            }
        }
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
                for (ADevice device : room.getDevicesInRoom()) {
                    device.updateState(elapsedTime);
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
                if (cattle != null && microwave != null) {
                    commandParameters = new CommandParameters(eventHandler, cattle);
                    makeBreakfastCommand.add(new TurnOnCattleCommand(commandParameters));
                    makeBreakfastCommand.add(new MakeTeaCommand(commandParameters));
                    commandParameters = new CommandParameters(eventHandler, microwave);
                    makeBreakfastCommand.add(new TurnOnMicrowaveCommand(commandParameters));
                    makeBreakfastCommand.add(new WarmUpFoodCommand(commandParameters));

                    //make breakfast
                    person.setCommand(makeBreakfastCommand);
                    person.executeCommand();
                } else {
                    logger.info("Waiting for freeing devices");
                }
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
