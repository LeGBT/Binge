package fr.legbt.binge.items;

import java.awt.geom.Rectangle2D;
import java.awt.*;
import fr.legbt.binge.*;

/**
 * Plan describe a half plan item for simple bounding collisions.
 */
public abstract class Plan extends FixedItem{
	private Rectangle2D lerect;
	//final static int XMAX = 3;
	//final static int XMIN = 12;
	//final static int YMAX = 5;
	//final static int YMIN = 10;


	/**
	 * Simple Plan class
	 */
	public Plan(Binge game){
		super(game);
		this.lerect = new Rectangle2D.Double(0,0,0,0);
	}

	public abstract void traceMe(Binge game);
	protected void action(){}
	public void onLoaded(Binge game){}
	
}
