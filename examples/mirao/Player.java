package examples.mirao;

import fr.legbt.binge.items.SimpleGravityPlayer;
import fr.legbt.binge.items.FixedItem;
import fr.legbt.binge.items.MovableItem;
import fr.legbt.binge.items.PlanYMax;
import fr.legbt.binge.Binge;


public class Player extends SimpleGravityPlayer{

	public Player(Binge game,int column){
		super(game,column,100,40);
	}

	public void action(){
		super.action();
		this.moveMe();
	}

	public void onCollide(FixedItem fitem){
		if ((fitem.getClass() == PlanYMax.class)&&(this.getJump() == false)){
			this.yspeed = 0;
		}	
	}
	public void onCollide(MovableItem mitem){}
}
