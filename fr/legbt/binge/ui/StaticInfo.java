package fr.legbt.binge.ui;

import java.awt.*;
import fr.legbt.binge.Binge;
import fr.legbt.binge.items.PaintManager;

public abstract class StaticInfo{
	Binge game;

	public StaticInfo(Binge game){
		this.game = game;	
		this.game.registerUI(this);
	}

	public abstract void traceMe(Binge game);
}
