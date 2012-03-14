package fr.legbt.binge.ui;

import java.awt.*;
import fr.legbt.binge.Binge;
import fr.legbt.binge.items.PaintManager;

public abstract class StaticInfo{
	Binge game;
	public PaintManager paintmanager;

	public StaticInfo(Binge game){
		this.paintmanager = game.paintmanager;
		paintmanager.register(this);
	}

	public abstract void traceMe(Binge game);
}
