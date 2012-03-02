package fr.legbt.binge.items;

/**
 * PlanXMax describe a right vertical half plan item for simple bounding collisions.
 */
public abstract class PlanXMax extends Plan{

	protected int x;

	/**
	 * Xmax Plan construction 
	 */
	public PlanXMax(CollisionsManager cm, int x){
		super(cm);
		this.x = x;
	}

	protected Boolean collideWith(Item item){
		if (item instanceof Rect){
			if (item.x+((Rect)item).width >= x){ return true;} else {
				return false;}
		}
		if (item instanceof Ball){
			if (item.x+2*((Ball)item).radius >= x){ return true;} else {
				return false;}
		}	
		return false;
	}
}
