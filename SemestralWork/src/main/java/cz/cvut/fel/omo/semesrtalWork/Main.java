package cz.cvut.fel.omo.semesrtalWork;

import cz.cvut.fel.omo.semesrtalWork.events.EventHandler;
import cz.cvut.fel.omo.semesrtalWork.events.FeedPetCommand;
import cz.cvut.fel.omo.semesrtalWork.events.TakeSkisCommand;

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

        var handler = new EventHandler();
        var feed_pet = new FeedPetCommand(handler);
        var take_skis = new TakeSkisCommand(handler);
        var pedro = new Adult();


        //feeding executing
        pedro.setCommand(feed_pet);
        pedro.invokeEvent();

        //taking skis executing
        pedro.setCommand(take_skis);
        pedro.invokeEvent();

    }
}