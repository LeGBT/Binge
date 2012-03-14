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

	protected Boolean collideWith(MovableItem mitem){
		if (mitem instanceof Rect){
			if (mitem.ynext + ((Rect)mitem).height >= y){ return true;} else {
				return false;}
		}
		if (mitem instanceof Ball){
			if (mitem.ynext+((Ball)mitem).diameter >= y){ return true;} else {
				return false;}
		}	
		return false;
	}

	public void traceMe(Binge game){
		game.getItemDrawZoneGraphics().fillRect(0,y,game.getWidth(),game.getHeight()-y);
	}
}
