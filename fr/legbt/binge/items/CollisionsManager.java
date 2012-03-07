package fr.legbt.binge.items;

import java.util.*;
import java.util.Map.*;
import java.awt.Rectangle;


public class CollisionsManager extends Manager {

	public void tryToMove(){
		// Test only once each possible collisions	
		// Boolean test = false;
		try{
			for (int i=0;i<itemlist.size();i++){
				Item itemi = itemlist.get(i);
				for (int j=i+1;j<itemlist.size();j++){
						Item itemj = itemlist.get(j);
						if (itemi.collideWith(itemj)){
							itemj.onCollide(itemi);
							itemi.xnext = itemi.x;
							itemi.ynext = itemi.y;
							itemj.xnext = itemj.x;
							itemj.ynext = itemj.y;
					}
				}
				for (int j=0;j<fixeditemlist.size();j++){
					FixedItem itemj = fixeditemlist.get(j);
					if (itemj.collideWith(itemi)){
						itemi.onCollide(itemj);
						itemi.xnext = itemi.x;
						itemi.ynext = itemi.y;
					}
				}
				itemi.setPosition(itemi.xnext,itemi.ynext);
			}
		} catch(Exception e){
			System.out.println("segfault ?" + e);
		}
	}

	public CollisionsManager(){
		super();
	}

	public void testCollisions(){
		this.tryToMove();
	}
}
