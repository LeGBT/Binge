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
		xspeed = speed;
		yspeed = speed;
		this.speed = speed;
		setListener();
	}

	public void onKeyDown(int key){
		System.out.println(key);
		//		switch (key){
		//			case KeyEvent.VK_LEFT:	xspeed = -speed;break;
		//			case KeyEvent.VK_RIGHT:	xspeed = +speed;break;
		//			case KeyEvent.VK_UP:	yspeed = -speed;break;
		//			case KeyEvent.VK_DOWN:	yspeed = +speed;break;
		//		}	

	}
	public void onKeyUp(int key){
		//		switch (key){
		//			case KeyEvent.VK_LEFT:	xspeed = 0;break;
		//			case KeyEvent.VK_RIGHT:	xspeed = 0;break;
		//			case KeyEvent.VK_UP:	yspeed = 0;break;
		//			case KeyEvent.VK_DOWN:	yspeed = 0;break;
		//		}	
	}

	protected void onCollide(FixedItem item){
		if (item instanceof PlanYMax){yspeed = -yspeed;}
		if (item instanceof PlanYMin){yspeed = -yspeed;}
		if (item instanceof PlanXMax){xspeed = -xspeed;}
		if (item instanceof PlanXMin){xspeed = -xspeed;}
	}

	protected void onCollide(Item item){
		//angle du vecteur entre les deux milieux !!!! ici pas de gestion des rayons !
		// il manque une normalisation !!!
		Double theta = Math.atan(new Double(this.ynext-item.ynext)/(new Double(xnext-item.xnext)));
		Double cos2theta = Math.cos(theta*2);
		Double sin2thetaover2 = (Math.sin(theta*2))/2;
		this.xspeed = (int)(-this.xspeed*cos2theta - this.yspeed*sin2thetaover2);
		this.yspeed = (int)(-this.xspeed*sin2thetaover2 + this.yspeed*cos2theta);
	//	System.out.println(this.xspeed);
	//	System.out.println(this.yspeed);
	//	System.out.println("+++++next///");
	}

	public void action(){
		this.move(this.x+this.xspeed,this.y+this.yspeed);
	}

}
