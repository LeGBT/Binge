package fr.legbt.binge.items;

/**
 * Ball is a simple disc item.
 */
public abstract class Ball extends Item{
	protected int x;
	protected int y;
	protected int xcenter;
	protected int ycenter;
	protected int radius;

	/**
	 * Constructor for Ball defined by the top left coordinate point of the smallest square containing the ball. 
	 */
	public Ball(int x, int y, int radius){
		this.xcenter = x + radius;
		this.ycenter = y + radius;
		this.radius = radius;
		this.x = x;
		this.y = y;
	}
}	
