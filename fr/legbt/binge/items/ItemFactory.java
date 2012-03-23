package fr.legbt.binge.items;

import fr.legbt.binge.Binge;


public class ItemFactory {

	public PlanXMax createPlanXMax(Binge game,DataItem data, int line, int column){
		PlanXMax p = new PlanXMax(data,column);
		p.setGame(game);
		return p;
	}	
	public PlanXMin createPlanXMin(Binge game,DataItem data, int line, int column){
		PlanXMin p = new PlanXMin(data, column);
		p.setGame(game);
		return p;
	}	
	public PlanYMax createPlanYMax(Binge game,DataItem data, int line, int column){
		PlanYMax p = new PlanYMax(data, line);
		p.setGame(game);
		return p;
	}	
	public PlanYMin createPlanYMin(Binge game,DataItem data, int line, int column){
		PlanYMin p = new PlanYMin(data, line);
		p.setGame(game);
		return p;
	}	
}
