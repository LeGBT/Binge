package examples.bouncing_balls;

import fr.legbt.binge.items.*;
import fr.legbt.binge.*;
import java.awt.geom.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Balls extends Ball{
	private double speed;
	private transient BouncingGame game;
	private Color color;


	public Balls(Binge game, int x, int y, int diameter, double speed){
		super(game,x,y,diameter);	
		this.game = (BouncingGame) game;
		xspeed = speed;
		yspeed = speed + 3;
		this.speed = speed;
		this.color = Color.GREEN;
		//	setListener();
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

	public void onLoaded(Binge game){
		this.game = (BouncingGame) game;
	}

	protected void onCollide(FixedItem fitem){
		game.upScore();
		if (fitem instanceof PlanYMax){yspeed = -yspeed;}
		if (fitem instanceof PlanYMin){yspeed = -yspeed;}
		if (fitem instanceof PlanXMax){xspeed = -xspeed;}
		if (fitem instanceof PlanXMin){this.unRegister(game);}
	}

	protected void onCollide(MovableItem mitem){
		game.upScore();
		//angle du vecteur entre les deux milieux !!!! ici pas de gestion des rayons autre que leurs distances !
		// calcul de la distance entre les centres :
		if (mitem instanceof Balls){
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
		}else{
			if (!mitem.collided){
				if(this.x>40){
					this.xspeed = -xspeed;

				}else{
					this.xspeed = -xspeed;
					this.yspeed = -yspeed;
				}
			}
		}
	}

	public void traceMe(Binge game){
		Graphics2D g2d = (Graphics2D) game.getGraphics();	
		Font f = new Font("Casual", Font.PLAIN, 32);
		g2d.setFont(f);
		g2d.setColor(this.color);	
		g2d.fill(this.getDisc());
		g2d.setColor(Color.BLACK);	
		g2d.drawString(Integer.toString((int)Math.round(this.xspeed)),this.x,this.y+this.getDiameter());
	}

	public void action(){
		this.move((int)(this.x+Math.round(this.xspeed)),(int)(this.y+Math.round(this.yspeed)));
		if(this.x<50){
			this.color = Color.RED;
		}
		if(this.x>50){
			this.color = Color.GREEN;
		}
	}
}
