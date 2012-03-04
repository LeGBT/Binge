package fr.legbt.binge.items;

import java.awt.geom.Rectangle2D;
import java.awt.*;
import fr.legbt.binge.*;

/**
 * PlanXMax describe a right vertical half plan item for simple bounding collisions.
 */
public class PlanXMax extends Plan{
	protected int x;

	/**
	 * Xmax Plan construction 
	 */
	public PlanXMax(Binge game, int x){
		super(game);
		this.x = x;
	}

	protected Boolean collideWith(Item item){
		if (item instanceof Rect){
			if (item.x+((Rect)item).width >= x){ return true;} else {
				return false;}
		}
		if (item instanceof Ball){
			if (item.x+2*((Ball)item).radius >= x){ return true;} else {
				return false;}
		}	
		return false;
	}

	public void traceMe(Graphics g){
		g.fillRect(x,0,game.getWidth()-x,game.getWidth());
	}	
}
