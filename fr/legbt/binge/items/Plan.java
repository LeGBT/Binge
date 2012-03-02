package fr.legbt.binge.items;

/**
 * Plan describe a half plan item for simple bounding collisions.
 */
public abstract class Plan extends Item{
	final static int XMAX = 0;
	final static int XMIN = 1;
	final static int YMAX = 2;
	final static int YMIN = 3;

	protected int xyminmax;
	private int type;

	/**
	 * Constructor for Plan, test represent the type of plan with XMAX,XMIN,YMAX or YMIN his posible values. 
	 * minmax represent the plan coordinate, e.g. test=XMIN and minmax=5 represent the plan x<=5
	 */
	public Plan(CollisionsManager cm, int test, int minmax){
		super(cm);
		this.xyminmax = minmax;
		this. type = test;
	}

	void setXY(int x, int y){
		if ((this.type == XMAX)||(this.type == XMIN)){
			this.xyminmax = x;
		}
		if ((this.type == YMAX)||(this.type == YMIN)){
			this.xyminmax = y;
		}
	}

}
