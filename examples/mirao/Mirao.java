package examples.mirao;

import fr.legbt.binge.Binge;
import fr.legbt.binge.LevelEditor;
import fr.legbt.binge.items.PlanYMax;
import fr.legbt.binge.items.PlanXMax;


public class Mirao extends Binge{

	public Mirao(String lvlfile){
		super(lvlfile);
	}


	public static void main(String arg[]){
		Mirao game = new Mirao("mirao");
		new PlanYMax(game,8);
		new PlanXMax(game,15);
		new Player(game,2);
		new LevelEditor(game,"miraolvl");

	}
}
