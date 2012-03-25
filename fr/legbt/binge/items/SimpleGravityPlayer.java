package fr.legbt.binge.items;

import fr.legbt.binge.Binge;

public abstract class SimpleGravityPlayer extends Rect{
	private boolean jump;
	private boolean keyleftdown;
	private boolean keyrightdown;
	private int slidetime;
	private int slide;
	private int jumpkey;
	private int leftkey;
	private int rightkey;
	private int walkspeed;
	private int jumpheight;

	public SimpleGravityPlayer(Binge game,int column,int height,int width){
		super(game,"Player",1,column,height,width,null);
		this.jump = false;
		this.keyleftdown=false;
		this.keyrightdown=false;
		this.slidetime = 2;
		this.slide = 2;
		this.walkspeed = 12;
		this.leftkey = 65;
		this.rightkey = 73;
		this.jumpkey = 87;
		this.jumpheight = 20;
		setListener(game);
	}

	public void onKeyDown(int key){
		if( key == leftkey){ keyleftdown = true; keyrightdown = false;}
		if( key == rightkey){ keyrightdown = true; keyleftdown = false;}
		if( key == jumpkey){ jump = true;}
	}
	public void onKeyUp(int key){
		if( key == leftkey){ keyleftdown = false;}
		if( key == rightkey){ keyrightdown = false;}
		if( key == jumpkey){ jump = false;}
	}

	/**
	 * General actions on a gravity player,
	 * override this with :
	 * public void action(){
	 *		super.action();
	 *      // your actions
	 *      this.moveMe();
	 * }
	 */
	public void action(){
		if(keyleftdown){this.xspeed=-walkspeed;
		}else if(keyrightdown){
			this.xspeed=walkspeed;
		}else if(this.xspeed!=0){
			slide -=1;
			if(slide == 0){
				slide = slidetime;
				this.xspeed+=-(int)this.xspeed/Math.abs(this.xspeed);
			}
		}
		if ((jump == true)&&(this.getY() >= 537)){
			this.yspeed = -this.jumpheight;
		}else if(this.getY() != 539){
			this.yspeed += 1;
		}
	}

	public void onLoaded(Binge game){setListener(game);}

	/**
	 * auto move method
	 */
	public void moveMe(){this.move(this.getX()+(int)xspeed,this.getY()+(int)yspeed);}


	/**
	 * Determines if this player is jumping.
	 *
	 * @return The jump.
	 */
	public boolean getJump()
	{
		return this.jump;
	}

	/**
	 * Gets the slidetime for this instance.
	 *
	 * @return The slidetime.
	 */
	public int getSlidetime(){return this.slidetime;}

	/**
	 * Sets the slidetime for this instance.
	 *
	 * @param slidetime The slidetime.
	 */
	public void setSlidetime(int slidetime){this.slidetime = slidetime;}

	/**
	 * Gets the leftkey for this instance.
	 *
	 * @return The leftkey.
	 */
	public int getLeftkey(){return this.leftkey;}

	/**
	 * Sets the leftkey for this instance.
	 *
	 * @param leftkey The leftkey.
	 */
	public void setLeftkey(int leftkey){this.leftkey = leftkey;}

	/**
	 * Gets the rightkey for this instance.
	 *
	 * @return The rightkey.
	 */
	public int getRightkey(){return this.rightkey;}

	/**
	 * Sets the rightkey for this instance.
	 *
	 * @param rightkey The rightkey.
	 */
	public void setRightkey(int rightkey){this.rightkey = rightkey;}

	/**
	 * Gets the walkspeed for this instance.
	 *
	 * @return The walkspeed.
	 */
	public int getWalkspeed(){return this.walkspeed;}

	/**
	 * Sets the walkspeed for this instance.
	 *
	 * @param walkspeed The walkspeed.
	 */
	public void setWalkspeed(int walkspeed){this.walkspeed = walkspeed;}

	/**
	 * Gets the jumpheight for this instance.
	 *
	 * @return The jumpheight.
	 */
	public int getJumpheight()
	{
		return this.jumpheight;
	}

	/**
	 * Sets the jumpheight for this instance.
	 *
	 * @param jumpheight The jumpheight.
	 */
	public void setJumpheight(int jumpheight)
	{
		this.jumpheight = jumpheight;
	}
}
