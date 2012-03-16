package fr.legbt.binge;

import fr.legbt.binge.data.*;

public class LevelEditor {
//	Binge game;
	//String lvlfile;

	public LevelEditor(Binge game,String lvlfile){
//		this.game = game;
		try{
			//Level blank = new Level(1,1);
			IOManager.writeLvl(game.getLvl(),lvlfile);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		game.load();
	}
}
