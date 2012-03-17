package fr.legbt.binge.items;

import fr.legbt.binge.Binge;


/**
 * Create a Border instance to create a collision border with the arguments
 */
public class Borders {
	@SuppressWarnings("unused")
	private PlanXMax xmax;
	@SuppressWarnings("unused")
	private PlanXMin xmin;
	@SuppressWarnings("unused")
	private PlanYMax ymax;
	@SuppressWarnings("unused")
	private PlanYMin ymin;
/**
 * The game instance is mandatory to register correctly the border to collisions and repaints.
 */
	public Borders(Binge game,int xmax, int xmin, int ymax, int ymin){
		this.xmax = new PlanXMax(game,xmax);
		this.xmin = new PlanXMin(game,xmin);
		this.ymax = new PlanYMax(game,ymax);
		this.ymin = new PlanYMin(game,ymin);
	}
}
