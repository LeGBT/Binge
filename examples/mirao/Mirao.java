package examples.mirao;

import fr.legbt.binge.Binge;
import fr.legbt.binge.LevelEditor;
import fr.legbt.binge.graphics.BackgroundsStruct;
import fr.legbt.binge.items.PlanYMax;
import fr.legbt.binge.items.PlanXMax;
import fr.legbt.binge.items.Tile;


public class Mirao extends Binge{

	public Mirao(String lvlfile,BackgroundsStruct bg){
		super(lvlfile,bg);
	}


	public static void main(String arg[]){
		int[] bg = {3,5};
		int[] yoff = {150,450};
		BackgroundsStruct bgs = new BackgroundsStruct(bg,yoff);
		Mirao game = new Mirao("mirao",bgs);
		new PlanYMax(game,8);
		new PlanXMax(game,15);
		new Player(game,2);
		new Tile(game,2,6);
		new LevelEditor(game,"miraolvl");
	}
}
