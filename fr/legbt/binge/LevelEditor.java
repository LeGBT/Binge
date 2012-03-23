package fr.legbt.binge;

import fr.legbt.binge.data.*;

public class LevelEditor {

	public LevelEditor(Binge game,String lvlfile){
		try{
			IOManager.writeLvl(game.getLvl(),lvlfile);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		game.load();
	}
}
