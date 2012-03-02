package fr.legbt.binge.items;

/**
 * Plan describe a right vertical half plan item for simple bounding collisions.
 */
public abstract class PlanYMax extends Plan{

	protected int y;

	/**
	 * Xmax Plan construction 
	 */
	public PlanYMax(CollisionsManager cm, int y){
		super(cm);
		this.y = y;
	}

	protected Boolean collideWith(Item item){
		if (item instanceof Rect){
			if (item.y + ((Rect)item).height >= y){ return true;} else {
				return false;}
		}
		if (item instanceof Ball){
			if (item.y+2*((Ball)item).radius >= y){ return true;} else {
				return false;}
		}	
		return false;
	}
}
