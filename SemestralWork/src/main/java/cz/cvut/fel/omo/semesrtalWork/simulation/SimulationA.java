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
            report.append("Sensor Type: " + sensor.getClass() + ". Has been added on house by address: " + house.getAddress() + "\n");
        }
        for (Floor floor : house.getFloors()) {

            for (ASensor sensor : floor.getSensorsOnFloor()) {
                report.append("Sensor Type: " + sensor.getClass() + ". Has been added on the " + floor.getLevel() + " floor\n");
            }
            for (Room room : floor.getRooms()) {
                for (ASensor sensor : room.getSensorsInRoom()) {
                    report.append("Sensor Type: " + sensor.getClass() + ". Has been added to the " + room.getName() + "\n");
                }

                for (ADevice device : room.getDevicesInRoom()) {
                    report.append("Device Type: " + device.getClass() + ". Has been added to the " + room.getName() + "\n");
                }

                for (Person person : room.getPeopleInRoom()) {
                    report.append("Person: " + person.getName() + ". Has been added to the " + room.getName() + "\n");
                }
                for (Pet pet : room.getPetInRoom()) {
                    report.append("Pet: " + pet.getName() + ". Has been added to the " + room.getName() + "\n");
                }
                for (Item item : room.getItemsInRoom()) {
                    report.append("Item Type: " + item.getClass() + ". Has been added to the " + room.getName() + "\n");
                }
            }
        }

        log(report.toString());
    }

//    private void logEventReport(Event event) {
//        StringBuilder report = new StringBuilder("EventReport: Event details\n");
//        // Log event details, including type, source, and target entities
//        // Example: report.append("Event Type: " + event.getType() + "\n");
//        // Example: report.append("Source Entity: " + event.getSource() + "\n");
//        // Example: report.append("Target Entity: " + event.getTarget() + "\n");
//        // ...
//
//        log(report.toString());
//    }

    private void logActivityAndUsageReport(Person person, ADevice device) {
        StringBuilder report = new StringBuilder("ActivityAndUsageReport: Activity and Usage details\n");
        // Log activity and usage details, including person, device, and usage count
        // Example: report.append("Person: " + person.getName() + "\n");
        // Example: report.append("Device: " + device.getName() + "\n");
        // Example: report.append("Usage Count: " + device.getUsageCount() + "\n");
        // ...

        log(report.toString());
    }

    private void logConsumptionReport(ADevice device, double electricityConsumption, double gasConsumption, double waterConsumption) {
        StringBuilder report = new StringBuilder("ConsumptionReport: Consumption details\n");
        // Log consumption details, including device and consumption values
        // Example: report.append("Device: " + device.getName() + "\n");
        // Example: report.append("Electricity Consumption: " + electricityConsumption + " kWh\n");
        // Example: report.append("Gas Consumption: " + gasConsumption + " cubic meters\n");
        // Example: report.append("Water Consumption: " + waterConsumption + " liters\n");
        // ...

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
        HeatSensor heatASensor = new HeatSensor();
        LightSensor lightASensor = new LightSensor();

        houseBuilder.addSensor(heatASensor);
        houseBuilder.addSensor(lightASensor);

        Skis skis = new Skis();
        roomBuilder.addItem(skis);
        Room storage = roomBuilder.getResult();


        Cattle cattle = new Cattle();
        Microwave microwave = new Microwave();
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
