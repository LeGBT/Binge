package fr.legbt.binge.items;

import java.awt.geom.Ellipse2D;
import java.awt.*;
import fr.legbt.binge.Binge;

/**
 * Ball is a simple disc item.
 */
public abstract class Ball extends Item{
	protected int xcenter;
	protected int ycenter;
	protected int diameter;
	private Ellipse2D.Double theball;

	/**
	 * Constructor for Ball defined by the top left coordinate point of the smallest square containing the ball. 
	 */
	public Ball(Binge game, int x, int y, int diameter){
		super(game,x,y);
		this.xcenter = x + diameter/2;
		this.ycenter = y + diameter/2;
		this.diameter = diameter;
		this.theball = new Ellipse2D.Double(x,y,diameter,diameter);
	}

	public void traceMe(Graphics g){
		theball.setFrame(x,y,diameter,diameter);
		((Graphics2D)g).fill(theball);
	}

	protected Boolean collideWith(Item item){
		if (item instanceof Ball){
			Ball it = (Ball) item; 
			int dist = (it.xcenter-this.xcenter)*(it.xcenter-this.xcenter) + (it.ycenter-this.ycenter)*(it.ycenter-this.ycenter);
			if (dist <= ((it.diameter+this.diameter)*(it.diameter+this.diameter))){
				return true;
			}
			return false;
		}
		if (item instanceof Rect){
			Rect it = (Rect) item;
			Ellipse2D.Double circle = new Ellipse2D.Double(this.x, this.y, this.diameter, this.diameter);
			if (circle.intersects(it.x, it.y, it.width, it.height)){
				return true;
			}
			return false;
		}
		return false;
	}
}	
