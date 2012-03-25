package examples.bounce;

import fr.legbt.binge.items.*;
import fr.legbt.binge.*;
import java.awt.*;


public class Balls extends Disc{
	private Color color;

	public Balls(BouncingGame game, int column, int line, int diameter, double speed){
		super(game,"Balls",column,line,diameter,putRaw("speed",new Double(speed)));	
		this.game = game;
		xspeed = speed;
		yspeed = speed + 3;
		this.color = Color.GREEN;
	}
	public Balls(DataItem data, int column, int line, int diameter){
		super(data,line,column,diameter);	
		xspeed = (Double) data.getRaw().get("speed");
		yspeed = (Double) data.getRaw().get("speed") + 3;
		this.color = Color.GREEN;
	}

	public void onKeyDown(int key){}
	public void onKeyUp(int key){}

	public void onLoaded(Binge game){
		this.game = (BouncingGame) game;
	}

	protected void onCollide(FixedItem fitem){
		((BouncingGame)game).upScore();
		if (fitem instanceof PlanYMax){yspeed = -yspeed;}
		if (fitem instanceof PlanYMin){yspeed = -yspeed;}
		if (fitem instanceof PlanXMax){xspeed = -xspeed;}
		if (fitem instanceof PlanXMin){this.unRegister(game);}
	}

	protected void onCollide(MovableItem mitem){
		((BouncingGame)game).upScore();
		//angle du vecteur entre les deux milieux !!!! ici pas de gestion des rayons autre que leurs distances !
		// calcul de la distance entre les centres :
		if (mitem instanceof Balls){
			double dist = Math.sqrt(Math.pow(mitem.getX()-this.getX() + ((Disc)mitem).getDiameter() - this.getDiameter(),2) + Math.pow(mitem.getY()-this.getY()+((Disc)mitem).getDiameter() - this.getDiameter(),2));
			//vecteurs normaux à la collision :
			double nx = (mitem.getX() - this.getX() + ((Disc)mitem).getDiameter() - this.getDiameter())/dist;
			double ny = (mitem.getY() - this.getY() + ((Disc)mitem).getDiameter() - this.getDiameter())/dist;
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
			if (!mitem.getCollided()){
				if(this.getX()>40){
					this.xspeed = -xspeed;

				}else{
					this.xspeed = -xspeed;
					this.yspeed = -yspeed;
				}
			}
		}
	}

	public void traceMe(Graphics g){
		Graphics2D g2d = (Graphics2D) g;	
		Font f = new Font("Casual", Font.PLAIN, 32);
		g2d.setFont(f);
		g2d.setColor(this.color);	
		g2d.fill(this.getDisc());
		g2d.setColor(Color.BLACK);	
		g2d.drawString(Integer.toString((int)Math.round(this.xspeed)),this.getX(),this.getY()+this.getDiameter());
	}

	public void action(){
		this.move((int)(this.getX()+Math.round(this.xspeed)),(int)(this.getY()+Math.round(this.yspeed)));
		if(this.getX()<50){
			this.color = Color.RED;
		}
		if(this.getX()>50){
			this.color = Color.GREEN;
		}
	}
}
