package fr.legbt.binge.items;

import java.util.*;
import java.util.Map.*;
import java.awt.Rectangle;


public class CollisionsManager {
	private	ArrayList<Item> itemlist;	

	public void tryToMove(Item item,int x,int y){
		// Test every possible collisions	
		try{
			int itemidx = this.itemlist.indexOf(item);
			for (int i=0;i<=itemlist.size();i++){
				if (itemidx != i){
					//là
				}
			}
		} catch(Exception e){


		}
		item.setPosition(x,y);
	}

	public CollisionsManager(){
		itemlist = new ArrayList<Item>();
	}


	private void register(Item item){
		this.itemlist.add(item);
	}

	public Boolean  testCollisions(){
		Boolean test = new Boolean(false);
		for (int i =0; i<itemlist.size(); i++){
			ItemId theitemid = itemlist.get(i);
		}
		return true;
	}
	//int x = theitemid.;
	//int y = entry.getValue()[1];
	//int radius = entry.getValue()[2];
	//Item item = entry.getKey();
	/*		if (x-radius<=0){
			item.onCollision(0,y);
			test = true;
	}
	if (x+radius>=bound.width){
	item.onCollision(x+radius,y);
	test = true;
	}
	if (y-radius<=0){
	item.onCollision(x,0);
	test = true;
	}
	if (y+radius>=bound.height){
	item.onCollision(x,y+radius);
	test = true;
	}
	// tests de coins
	if ((x-radius<=0)&&(y-radius<=0)){
	item.onCollision(0,0);
	test = true;
	}
	if ((x-radius<=0)&&(y+radius>=bound.height)){
	item.onCollision(0,y+radius);
	test = true;
	}
	if ((x+radius>=bound.width)&&(y-radius<=0)){
	item.onCollision(x+radius,0);
	test = true;
	}
	if ((x+radius>=bound.width)&&(y+radius>=bound.height)){
	item.onCollision(x+radius,y+radius);
	test = true;
	}
	for(Map.Entry<Item,int[]> otherEnt : lesItems.entrySet()){
	int x2 = otherEnt.getValue()[0];
	int y2 = otherEnt.getValue()[1];
	int radiu2 = otherEnt.getValue()[2];
	Item item2 = otherEnt.getKey();
	if (! otherEnt.equals(entry)){
	if( Math.pow(x2-x,2)+ Math.pow(y2-y,2)-Math.pow(radius+radiu2,2) <=0){
	item.onCollision(x2,y2);
	test=true;
	}
	} 
	}

	if (!test)	item.onNoCollision();
} 
return test;
}
}
*/
public void clearMe(){
	itemlist.clear();
}
}
