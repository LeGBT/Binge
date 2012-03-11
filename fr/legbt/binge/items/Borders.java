package fr.legbt.binge.items;

import fr.legbt.binge.Binge;

public class Borders {
	private PlanXMax xmax;
	private PlanXMin xmin;
	private PlanYMax ymax;
	private PlanYMin ymin;

	public Borders(Binge game,int xx, int xn, int yx, int ym){
		xmax = new PlanXMax(game,xx);
		xmin = new PlanXMin(game,xn);
		ymax = new PlanYMax(game,yx);
		ymin = new PlanYMin(game,ym);
	}
}
