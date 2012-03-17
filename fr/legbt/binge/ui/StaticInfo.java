package fr.legbt.binge.ui;

import java.awt.Graphics;
import fr.legbt.binge.Binge;


public abstract class StaticInfo{
	Binge game;

	public StaticInfo(Binge game){
		this.game = game;	
		this.game.registerUI(this);
	}
	public abstract void traceMe(Graphics g);
}
