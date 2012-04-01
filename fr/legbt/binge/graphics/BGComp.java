package fr.legbt.binge.graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;

import fr.legbt.binge.Binge;


public class BGComp extends JComponent{
	private static final long serialVersionUID = 0l;
	private BingePanel bpanel;
	private BufferedImage[] images;
	private int xshift;
	private int dist;
	private int tilenb;
	private int bglvl;
	private int yoff;

	public BGComp(BingePanel bpanel, int width, int height, int tilenb,int bglvl, int yoff){
		this.bpanel = bpanel;
		this.xshift = 0;
		this.dist = 70-bglvl*20;
		this.tilenb = tilenb;
		this.bglvl = bglvl;
		this.yoff = yoff;
		this.setDoubleBuffered(true);
		images = new BufferedImage[tilenb];
		for(int i=0;i<tilenb;i++){
			images[i] = Binge.getTexture(bglvl+"back"+(i+1)+".png");
		}
		this.setDoubleBuffered(true);	
		if(bglvl == 0){
			this.setOpaque(true);
		}else{
			this.setOpaque(false);
		}
	}

	protected void paintComponent(Graphics g){
		super.paintComponent(g);	
		Graphics2D g2 = (Graphics2D) g;
		if(bglvl == 0){
			g2.setColor(Color.LIGHT_GRAY);
			g2.fill(g2.getClipBounds());
		}
		for(int i=-1;i<5;i++){
			int j = -this.xshift/320 + i;
			int k = this.xshift%320;
			while(j<0){j+=tilenb;}
			while(j>tilenb-1){j-=tilenb;}
			g2.drawImage(images[j],k+320*i,yoff,null);
		}
	}

	/**
	 * Gets the xshift for this instance.
	 *
	 * @return The xshift.
	 */
	public int getXshift()
	{
		return this.xshift;
	}

	/**
	 * Sets the xshift for this instance.
	 *
	 * @param xshift send the delta distance of the observer to modify The xshift.
	 */
	public void addXshift(int delta)
	{
		this.xshift -= delta - (dist*delta)/100;
	}

	/**
	 * Gets the dist for this instance.
	 *
	 * @return The dist.
	 */
	public int getDist()
	{
		return this.dist;
	}

	/**
	 * Add to the dist for this instance.
	 *
	 * @param dist The dist.
	 */
	public void setDist(int dist)
	{
		this.dist = dist;
	}
}
