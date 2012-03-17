package fr.legbt.binge.ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import fr.legbt.binge.Binge;


public abstract class StaticInfo{
	Binge game;
	Rectangle renderzone;

	public StaticInfo(Binge game){
		this.game = game;	
		this.game.registerUI(this);
		this.game.getUIShow().addRect(new Rectangle(0,0,0,0));
	}
	public abstract void traceMe(Graphics g);
	public void setRenderZone(Rectangle rect){
		this.game.getUIShow().addRect(rect);
	}
}
