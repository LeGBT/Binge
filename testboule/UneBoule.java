package testboule;

import fr.legbt.binge.items.*;
import fr.legbt.binge.*;
import java.awt.geom.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class UneBoule extends Ball{
	private int speed;

	public UneBoule(Binge game, int x, int y, int radius, int speed){
		super(game,x,y,radius);	
		xspeed = 0;
		yspeed = 0;
		this.speed = speed;
		setListener();
	}

	public void onKeyDown(int key){
		switch (key){
			case KeyEvent.VK_LEFT:	xspeed = -speed;break;
			case KeyEvent.VK_RIGHT:	xspeed = +speed;break;
			case KeyEvent.VK_UP:	yspeed = -speed;break;
			case KeyEvent.VK_DOWN:	yspeed = +speed;break;
		}	

	}
	public void onKeyUp(int key){
		switch (key){
			case KeyEvent.VK_LEFT:	xspeed = 0;break;
			case KeyEvent.VK_RIGHT:	xspeed = 0;break;
			case KeyEvent.VK_UP:	yspeed = 0;break;
			case KeyEvent.VK_DOWN:	yspeed = 0;break;
		}	
	}

	public void action(){
		this.move(this.x+this.xspeed,this.y+this.yspeed);
	}

}
