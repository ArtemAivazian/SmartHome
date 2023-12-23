package cz.cvut.fel.omo.semesrtalWork;

import cz.cvut.fel.omo.semesrtalWork.Inhabitans.Adult;
import cz.cvut.fel.omo.semesrtalWork.Inhabitans.Child;
import cz.cvut.fel.omo.semesrtalWork.Inhabitans.Pet;
import cz.cvut.fel.omo.semesrtalWork.events.EventHandler;
import cz.cvut.fel.omo.semesrtalWork.events.MakeFoodComposite;
import cz.cvut.fel.omo.semesrtalWork.events.TurnOnCattleCommand;
import cz.cvut.fel.omo.semesrtalWork.events.TurnOnMicrowaveCommand;
import cz.cvut.fel.omo.semesrtalWork.item.Bike;
import cz.cvut.fel.omo.semesrtalWork.location.Floor;
import cz.cvut.fel.omo.semesrtalWork.location.House;
import cz.cvut.fel.omo.semesrtalWork.location.Room;
import cz.cvut.fel.omo.semesrtalWork.location.builder.*;
import cz.cvut.fel.omo.semesrtalWork.observer.lightdevices.Lamp;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.deviceState.DeviceBrokenState;
import cz.cvut.fel.omo.semesrtalWork.observer.devices.deviceState.State;
import cz.cvut.fel.omo.semesrtalWork.observer.noSensorDevs.Cattle;
import cz.cvut.fel.omo.semesrtalWork.observer.subjects.HeatASensor;
import cz.cvut.fel.omo.semesrtalWork.observer.subjects.LightASensor;
import cz.cvut.fel.omo.semesrtalWork.simulation.SimulationA;
import cz.cvut.fel.omo.semesrtalWork.simulation.SimulationFactory;

public class Main {
    public static void main(String[] args) {
        SimulationA simulation = new SimulationA();
        simulation.create();
    }
}