package cz.cvut.fel.omo.semesrtalWork.events;

public abstract class ACommand {
   protected CommandParameters parameters;

   public ACommand(CommandParameters parameters) {
      this.parameters = parameters;
   }

   public abstract void execute();

//   void execute(ADevice device);
//   void execute(AItem item);
//   void execute(Pet pet);

}
