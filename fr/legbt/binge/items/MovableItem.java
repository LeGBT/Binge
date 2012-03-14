
package fr.legbt.binge.items;

import java.awt.*;
import java.awt.event.*;
import fr.legbt.binge.Binge;


public abstract class MovableItem extends Item implements KeyListener {
	public Boolean collided;
	public Boolean collide;
	public Boolean wasneverfree;
	protected double xspeed;
	protected double yspeed;
	public int xnext;
	public int ynext;

	protected MovableItem(Binge game, int x, int y){
		super(game,x,y);
		this.xspeed = 0d;
		this.yspeed = 0d;
		this.xnext = x;
		this.ynext = y;
		this.wasneverfree = true;
		this.collided = false;
		this.collide = false;
	}

	final protected void move(int newx, int newy){
		this.xnext = newx;
		this.ynext = newy;
	}

	public void setGame(Binge game){
		game.registerItem(this);
	}
	public void unRegister(Binge game){
		game.unRegisterItem(this);
	}
	public int getX(){return this.x;}
	public int getY(){return this.y;}
	public double getXSpeed(){return this.xspeed;}
	public double getYSpeed(){return this.yspeed;}
	public void setXSpeed(double nxs){ this.xspeed = nxs;}
	public void setYSpeed(double nys){ this.yspeed = nys;}

	protected void setListener(Binge game){
		game.getFrame().addKeyListener(this);
	}
	protected void unSetListener(Binge game){
		game.getFrame().removeKeyListener(this);
	}

	public void keyPressed(KeyEvent key){
		this.onKeyDown(key.getKeyCode());
	}
	public void keyReleased(KeyEvent key){
		this.onKeyUp(key.getKeyCode());
	}
	public void keyTyped(KeyEvent key){}

	void setPosition(int x, int y){
		this.x = x;
		this.y = y;
	}

	protected abstract void onCollide(MovableItem mitem);
	protected abstract void onCollide(FixedItem fitem);
	protected abstract void onKeyUp(int keycode);
	protected abstract void onKeyDown(int keycode);
}
