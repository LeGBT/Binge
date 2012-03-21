package fr.legbt.binge.items;

import fr.legbt.binge.Binge;


public class ItemFactory {

	public PlanXMax createPlanXMax(Binge game,DataItem data, int line, int column){
		return new PlanXMax(game, line*game.getRes());
	}	
	public PlanXMin createPlanXMin(Binge game,DataItem data, int line, int column){
		return new PlanXMin(game, line*game.getRes());
	}	
	public PlanYMax createPlanYMax(Binge game,DataItem data, int line, int column){
		return new PlanYMax(game, column*game.getRes());
	}	
	public PlanYMin createPlanYMin(Binge game,DataItem data, int line, int column){
		return new PlanYMin(game, column*game.getRes());
	}	
}
