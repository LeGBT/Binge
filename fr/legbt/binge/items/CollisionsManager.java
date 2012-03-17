package fr.legbt.binge.items;

import java.util.*;
import java.util.Map.*;
import java.awt.Rectangle;


public class CollisionsManager extends Manager {

	public void tryToMove(){
		boolean collisions = false;
		boolean canmove=true;
		// Test only once each possible collisions	
		// Boolean test = false;
		try{
			for (int i=0;i<movableitemlist.size();i++){
				collisions = false;
				canmove = true;
				MovableItem itemi = movableitemlist.get(i);
				for (int j=i+1;j<movableitemlist.size();j++){
					MovableItem itemj = movableitemlist.get(j);
					if (itemi.collideWith(itemj)){
						collisions = true;
						if(itemi.collided){canmove = true;}else{canmove = false;}
						itemj.onCollide(itemi);
						itemi.collided = true;
						itemj.collided = true;
						if(!canmove){
						//	itemi.ynext = itemi.getY();
							itemj.xnext = itemj.getX();
							itemj.ynext = itemj.getY();
						}
					}
				}
				if (!collisions){itemi.collided = false;}
				for (int j=0;j<fixeditemlist.size();j++){
					FixedItem itemj = fixeditemlist.get(j);
					if (itemj.collideWith(itemi)){
						itemi.onCollide(itemj);
						itemi.xnext = itemi.getX();
						itemi.ynext = itemi.getY();
					}
				}
				itemi.setPosition(itemi.xnext,itemi.ynext);
			}
		} catch(Exception e){
			System.out.println("collisionmanager segfault ?" );
			e.printStackTrace();
		}
	}

	public CollisionsManager(){
		super();
	}

	public void testCollisions(){
		this.tryToMove();
	}
}
