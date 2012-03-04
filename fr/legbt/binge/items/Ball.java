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

	protected Ellipse2D.Double getDisc(){
		return this.theball;
	}

	// add xcenter to setXY
	void setXY(int x, int y){
		this.x =x;
		this.y =y;
		this.xcenter = x + diameter/2;
		this.ycenter = y + diameter/2;
	}

	protected Boolean collideWith(Item item){
		if (item instanceof Ball){
			Ball it = (Ball) item; 
			Double dist = Math.pow((it.xnext-this.xnext +  it.diameter/2 - this.diameter/2),2) + Math.pow((it.ynext-this.ynext + it.diameter/2 - this.diameter/2),2);
			if (dist <= ((it.diameter/2+this.diameter/2)*(it.diameter/2+this.diameter/2))){
				return true;
			}
			return false;
		}
		if (item instanceof Rect){
			Rect it = (Rect) item;
			Ellipse2D.Double circle = this.theball;
			if (circle.intersects(it.xnext, it.ynext, it.width, it.height)){
				return true;
			}
			return false;
		}
		return false;
	}
}	
