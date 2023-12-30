package cz.cvut.fel.omo.semesrtalWork.simulation;

import cz.cvut.fel.omo.semesrtalWork.events.EventHandler;

import java.util.Timer;

public abstract class SimulationFactory {

    protected Timer timer;
    protected double elapsedTime;

    public SimulationFactory() {
        this.timer = new Timer();
        this.elapsedTime = 0;
    }

    public abstract void create();
}