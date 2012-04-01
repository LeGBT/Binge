package fr.legbt.binge.items;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import fr.legbt.binge.Binge;




/**
 * Use the Tile class for all your collisions tile objects
 */
public class Tile extends FixedItem{
	private Rectangle2D.Double therect;
	int size;

	public  Tile(Binge game, int line, int column){
		super(game, "Tile", line, column, null);
		this.size = game.getRes();
		this.therect = new Rectangle2D.Double(this.getX(),this.getY(),size,size);
	}

	protected Boolean collideWith(MovableItem mitem) {
		if(mitem instanceof Rect){
			Rectangle2D.Double rect = ((Rect)mitem).getRect();
			if (rect.intersects(this.getX(),this.getY(),this.size,this.size)){
				return true;
			}
			return false;
		}
		return false;
	}

	protected void traceMe(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		therect.setFrame(this.getX(),this.getY(),size,size);
		g2.fill(therect);
	}

	public void onLoaded(Binge game) {
	}





}
