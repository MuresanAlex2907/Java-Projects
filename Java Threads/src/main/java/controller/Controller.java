package controller;

import model.SimulationManager;
import view.ExecutionView;
import view.View;

public class Controller {

	View view=new View();
	ExecutionView ev=new ExecutionView();
	
	public Controller() {
		// TODO Auto-generated constructor stub
	   view.addStart(e->{
	   view.visibleFalse();
	   ev.visibleTrue();
	   SimulationManager sm=new SimulationManager(view.gettLimit()*1000,view.gettNrServers(),view.gettNrTasks(),
			   view.gettPrMin()*1000,view.gettPrMax()*1000
			   ,view.gettArMin()*1000,view.gettArMax()*1000,ev);
	 //  SimulationManager sm=new SimulationManager(10000,4,20,4000,5000,6,1000,2000,ev);
	   Thread t1=new Thread(sm);
	   t1.start();
	   
	   });
	
	}

}
