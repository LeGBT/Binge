package fr.legbt.binge.items;

import fr.legbt.binge.Binge;


/**
 * Create a Border instance to create a collision border with the arguments
 */
public class Borders {
	@SuppressWarnings("unused")
	private PlanXMax xmaxline;
	@SuppressWarnings("unused")
	private PlanXMin xminline;
	@SuppressWarnings("unused")
	private PlanYMax ymaxline;
	@SuppressWarnings("unused")
	private PlanYMin yminline;
/**
 * The game instance is mandatory to register correctly the border to collisions and repaints.
 */
	public Borders(Binge game,int xmaxline, int xminline, int ymaxline, int yminline){
		this.xmaxline = new PlanXMax(game,xmaxline);
		this.xminline = new PlanXMin(game,xminline);
		this.ymaxline = new PlanYMax(game,ymaxline);
		this.yminline = new PlanYMin(game,yminline);
	}
}
