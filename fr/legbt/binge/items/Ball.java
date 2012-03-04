package fr.legbt.binge.items;

import java.awt.geom.Ellipse2D;
import java.awt.*;

/**
 * Ball is a simple disc item.
 */
public abstract class Ball extends Item{
	protected int xcenter;
	protected int ycenter;
	protected int radius;
	private Ellipse2D.Double theball;

	/**
	 * Constructor for Ball defined by the top left coordinate point of the smallest square containing the ball. 
	 */
	public Ball(CollisionsManager cm, int x, int y, int radius){
		super(cm,x,y);
		this.xcenter = x + radius;
		this.ycenter = y + radius;
		this.radius = radius;
		this.theball = new Ellipse2D.Double(x,y,radius,radius);
	}

	public void traceMe(Graphics g){
		((Graphics2D)g).fill(theball);
	}

	protected Boolean collideWith(Item item){
		if (item instanceof Ball){
			Ball it = (Ball) item; 
			int dist = (it.xcenter-this.xcenter)*(it.xcenter-this.xcenter) + (it.ycenter-this.ycenter)*(it.ycenter-this.ycenter);
			if (dist <= ((it.radius+this.radius)*(it.radius+this.radius))){
				return true;
			}
			return false;
		}
		if (item instanceof Rect){
			Rect it = (Rect) item;
			Ellipse2D.Double circle = new Ellipse2D.Double(this.x, this.y, this.radius, this.radius);
			if (circle.intersects(it.x, it.y, it.width, it.height)){
				return true;
			}
			return false;
		}
		return false;
	}
}	
