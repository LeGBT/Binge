package fr.legbt.binge.items;

import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
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
	public Plan(Binge game, String nametype){
		super(game,nametype);
		this.lerect = new Rectangle2D.Double(0,0,0,0);
	}
	public abstract void traceMe(Graphics g);
	protected void action(){}
	public void onLoaded(Binge game){}
	/**
	 * Gets the lerect for this instance.
	 *
	 * @return The lerect.
	 */
	public Rectangle2D getLerect()
	{
		return this.lerect;
	}
	
}
