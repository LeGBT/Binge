package fr.legbt.binge.items;

import java.awt.geom.Rectangle2D;
import java.awt.*;
import fr.legbt.binge.*;

/**
 * Plan describe a right vertical half plan item for simple bounding collisions.
 */
public class PlanXMin extends Plan{
	protected int x;

	/**
	 * Xmax Plan construction 
	 */
	public PlanXMin(Binge game, int x){
		super(game);
		this.x = x;
	}

	protected Boolean collideWith(Item item){
		if (item instanceof Rect){
			if (item.xnext <= x){ return true;} else {
				return false;}
		}
		if (item instanceof Ball){
			if (item.xnext <= x){ return true;} else {
				return false;}
		}	
		return false;
	}
	public void traceMe(Graphics g){
		g.fillRect(0,0,x,game.getHeight());
	}

}
