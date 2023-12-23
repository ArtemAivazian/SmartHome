package cz.cvut.fel.omo.semesrtalWork.events;

import cz.cvut.fel.omo.semesrtalWork.observer.devices.ADevice;

public interface ICommand {

   void execute();

   void execute(ADevice device);
}
