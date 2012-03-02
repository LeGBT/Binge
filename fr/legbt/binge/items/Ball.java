package fr.legbt.binge.items;

/**
 * Ball is a simple disc item.
 */
public abstract class Ball extends Item{
	protected int xcenter;
	protected int ycenter;
	protected int radius;

	/**
	 * Constructor for Ball defined by the top left coordinate point of the smallest square containing the ball. 
	 */
	public Ball(CollisionsManager cm, int x, int y, int radius){
		super(cm,x,y);
		this.xcenter = x + radius;
		this.ycenter = y + radius;
		this.radius = radius;
	}
}	
