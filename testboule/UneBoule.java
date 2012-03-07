package testboule;

import fr.legbt.binge.items.*;
import fr.legbt.binge.*;
import java.awt.geom.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class UneBoule extends Ball{
	private double speed;

	public UneBoule(Binge game, int x, int y, int diameter, double speed){
		super(game,x,y,diameter);	
		xspeed = speed;
		yspeed = speed + 3;
		this.speed = speed;
		setListener();
	}

	public void onKeyDown(int key){
		//System.out.println(key);
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
		//angle du vecteur entre les deux milieux !!!! ici pas de gestion des rayons autre que leurs distances !
		// calcul de la distance entre les centres :
		double dist = Math.sqrt(Math.pow(item.getX()-this.getX() + ((Ball)item).getDiameter() - this.getDiameter(),2) + Math.pow(item.getY()-this.getY()+((Ball)item).getDiameter() - this.getDiameter(),2));
		//System.out.println("dist = " + dist);
		//vecteurs normaux à la collision :
		double nx = (item.getX() - this.x + ((Ball)item).getDiameter() - this.getDiameter())/((double)(dist));
		double ny = (item.getY() - this.y + ((Ball)item).getDiameter() - this.getDiameter())/((double)(dist));
		//vecteurs tangents :
		double gx = -ny;
		double gy = nx;

		double v1n = nx*this.getXSpeed() + ny*this.getYSpeed();
		double v1g = gx*this.getXSpeed() + gy*this.getYSpeed();
		double v2n = nx*item.getXSpeed() + ny*item.getYSpeed();
		double v2g = gx*item.getXSpeed() + gy*item.getYSpeed();

		this.xspeed = nx*v2n + gx*v1g;
		this.yspeed = ny*v2n + gy*v1g;
		item.setXSpeed(nx*v1n + gx*v2g);
		item.setYSpeed(ny*v1n + gy*v2g);
		//	System.out.println(Math.abs(this.xspeed + item.getXSpeed()) + Math.abs(this.yspeed + item.getYSpeed()) );
		//	System.out.println("+++++next///");
	}

	public void traceMe(Graphics g){
		Font f = new Font("Casual", Font.PLAIN, 32);
		g.setFont(f);
		g.drawString(Integer.toString((int)Math.round(this.xspeed)),this.x,this.y);
	}

	public void action(){
		this.move((int)(this.x+Math.round(this.xspeed)),(int)(this.y+Math.round(this.yspeed)));
	}

}
