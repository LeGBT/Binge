package fr.legbt.binge.items;

import java.awt.geom.Rectangle2D;
import java.awt.*;
import fr.legbt.binge.*;

/**
 * Plan describe a right vertical half plan item for simple bounding collisions.
 */
public class PlanYMax extends Plan{

	protected int y;

	/**
	 * Xmax Plan construction 
	 */
	public PlanYMax(Binge game, int y){
		super(game);
		this.y = y;
	}

	protected Boolean collideWith(Item item){
		if (item instanceof Rect){
			if (item.y + ((Rect)item).height >= y){ return true;} else {
				return false;}
		}
		if (item instanceof Ball){
			if (item.y+((Ball)item).diameter >= y){ return true;} else {
				return false;}
		}	
		return false;
	}

	public void traceMe(Graphics g){
		g.fillRect(0,y,game.getWidth(),game.getHeight()-y);
	}
}
