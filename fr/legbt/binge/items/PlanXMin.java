package fr.legbt.binge.items;

import java.awt.geom.Rectangle2D;
import java.awt.*;
import fr.legbt.binge.*;

/**
 * Plan describe a right vertical half plan item for simple bounding collisions.
 */
public class PlanXMin extends Plan{
	private static final long serialVersionUID = 1l;
	protected int x;

	/**
	 * Xmax Plan construction 
	 */
	public PlanXMin(Binge game, int x){
		super(game);
		this.x = x;
	}

	protected Boolean collideWith(MovableItem mitem){
		if (mitem instanceof Rect){
			if (mitem.xnext <= x){ return true;} else {
				return false;}
		}
		if (mitem instanceof Ball){
			if (mitem.xnext <= x){ return true;} else {
				return false;}
		}	
		return false;
	}
	public void traceMe(Binge game){
		game.getGraphics().fillRect(0,0,x,game.getHeight());
	}

}
