package fr.legbt.binge.items;

import java.awt.*;
import java.awt.geom.*;
import fr.legbt.binge.Binge;

public class Ball extends Item{
	private Ellipse2D.Double laballe;
	private int xspeed;
	private int yspeed;

	public Ball(){
		this.xspeed = 1;
		this.yspeed = 1;
		this.laballe = new Ellipse2D.Double(10.,10.,20.,20.);
	}
	public Ball(int unetaille, int unespeed){
		this.xspeed = unespeed;
		this.yspeed = unespeed;
		this.laballe = new Ellipse2D.Double(10,10,unetaille,unetaille);
	}
	public Ball(int unetaille, int xspeed, int yspeed, int xpos, int ypos){
		this.xspeed = xspeed;
		this.yspeed = yspeed;
		this.laballe = new Ellipse2D.Double(xpos,ypos,unetaille,unetaille);
	}


	public void onCollision(int xout,int yout){
		Double norm = new Double(0.0);
		Double xs = new Double((double) xspeed);
		Double ys = new Double((double) yspeed);
		Double j = new Double(xs*(xout-xcenter)+ys*(yout-ycenter)); //vecteur normal
		norm = 1.0/(Math.pow(xout-xcenter,2)+Math.pow(yout-ycenter,2));
		xs = (double) Math.round(xs - 2.0*norm*j*((double)xout-xcenter));
		xspeed = xs.intValue();
		ys = (double)Math.round(ys - 2.0*norm*j*((double)yout-ycenter));
		yspeed = ys.intValue();
		laballe.x += xspeed;
		laballe.y += yspeed;
	}

	public void onNoCollision(){
		laballe.x += xspeed;
		laballe.y += yspeed;
	}

	public void traceMe(){
		//g.fillRect(laballe.x,laballe.y,laballe.width,laballe.height);
		((Graphics2D)this.g).fill(laballe);
	}

	public Boolean register(CollisionsManager cm){
		xcenter = ((int)laballe.x)+(int)Math.round(radius/2.0); 
		ycenter = ((int)laballe.y)+(int)Math.round(radius/2.0); 
		int[] box = new int[] {xcenter,ycenter,Math.round(radius/2)};
	return false;	
	//	return cm.registerBall();
	}
	public void onKeyUp(int keycode){}
	public void onKeyDown(int keycode){}

}	
