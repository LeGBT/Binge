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

	protected void onCollide(FixedItem fitem){
		if (fitem instanceof PlanYMax){yspeed = -yspeed;}
		if (fitem instanceof PlanYMin){yspeed = -yspeed;}
		if (fitem instanceof PlanXMax){xspeed = -xspeed;}
		if (fitem instanceof PlanXMin){xspeed = -xspeed;}
	}

	protected void onCollide(MovableItem mitem){
		//angle du vecteur entre les deux milieux !!!! ici pas de gestion des rayons autre que leurs distances !
		// calcul de la distance entre les centres :
		double dist = Math.sqrt(Math.pow(mitem.getX()-this.getX() + ((Ball)mitem).getDiameter() - this.getDiameter(),2) + Math.pow(mitem.getY()-this.getY()+((Ball)mitem).getDiameter() - this.getDiameter(),2));
		//System.out.println("dist = " + dist);
		//vecteurs normaux à la collision :
		double nx = (mitem.getX() - this.x + ((Ball)mitem).getDiameter() - this.getDiameter())/((double)(dist));
		double ny = (mitem.getY() - this.y + ((Ball)mitem).getDiameter() - this.getDiameter())/((double)(dist));
		//vecteurs tangents :
		double gx = -ny;
		double gy = nx;

		double v1n = nx*this.getXSpeed() + ny*this.getYSpeed();
		double v1g = gx*this.getXSpeed() + gy*this.getYSpeed();
		double v2n = nx*mitem.getXSpeed() + ny*mitem.getYSpeed();
		double v2g = gx*mitem.getXSpeed() + gy*mitem.getYSpeed();

		this.xspeed = nx*v2n + gx*v1g;
		this.yspeed = ny*v2n + gy*v1g;
		mitem.setXSpeed(nx*v1n + gx*v2g);
		mitem.setYSpeed(ny*v1n + gy*v2g);
		//	System.out.println(Math.abs(this.xspeed + mitem.getXSpeed()) + Math.abs(this.yspeed + mitem.getYSpeed()) );
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
