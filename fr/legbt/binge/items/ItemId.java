package fr.legbt.binge.items;

/**
 * ItemId is a preItem class that impletents everything needed by the collision manager and can be extended to create a "virtual" invisible item that create collisions.
 */
public class ItemId {
	final int PLAN = 0;
	final int BALL = 1;
	final int RECT = 2;
	final int XMAX = 10;
	final int YMAX = 20;
	final int XMIN = 11;
	final int YMIN = 21;

	private int itemtype = RECT;
	public  int xcenter = 0;
	public  int ycenter = 0;
	public  int radius;
	private int plantest;
	private int xyminmax;
	private int height = 1;
	private int width  = 1;
	public int x = 0;
	public int y = 0;

	/**
	 * Default constructor.
	 */
	public ItemId(){
		this.itemtype = RECT;
		this.xcenter = 0;
		this.ycenter = 0;
		this.height = 0;
		this.width = 0;
	}
	/**
	 * Constructor for a PLAN item type.
	 */
	public ItemId(int test,int minmax){
		this.itemtype = PLAN;
		this.xyminmax = minmax;
		this.plantest = test;
		this.xcenter = minmax;
		this.ycenter = minmax;
		this.x = minmax;
		this.y = minmax;
	}
	/**
	 * Constructor for a BALL item type.
	 */
	public ItemId(int x, int y, int radius){
		this.itemtype = BALL;
		this.xcenter = x+radius;
		this.ycenter = y+radius;
		this.radius = radius;
		this.x = x;
		this.y = y;
	}
	/**
	 * Constructor for a RECT item type.
	 */
	public ItemId(int x, int y,int height, int width){
		this.itemtype = RECT;
		this.xcenter = xcenter + width/2;
		this.ycenter = ycenter + height/2;
		this.height = height;
		this.width = width;
		this.x = x;
		this.y = y;
	}
}
