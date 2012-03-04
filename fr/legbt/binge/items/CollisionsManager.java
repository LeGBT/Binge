package fr.legbt.binge.items;

import java.util.*;
import java.util.Map.*;
import java.awt.Rectangle;


public class CollisionsManager {
	private	ArrayList<Item> itemlist;	
	private	ArrayList<FixedItem> fixeditemlist;	

	public void tryToMove(){
		// Test every possible collisions	
		Boolean test = false;
		try{
			for (int i=0;i<itemlist.size();i++){
				Item itemi = itemlist.get(i);
				for (int j=0;j<itemlist.size();j++){
					if (j != i){
						Item itemj = itemlist.get(j);
						if (itemi.collideWith(itemj)){
							itemi.xnext = itemi.x;
							itemj.xnext = itemj.x;
						}
					}
				}
				for (int j=0;j<fixeditemlist.size();j++){
					FixedItem itemj = fixeditemlist.get(j);
					if (itemj.collideWith(itemi)){
						itemi.xnext = itemi.x;
					}
				}
				//dépalcer les objets si tout est bon
				itemi.move(itemi.xnext,itemi.ynext);
			}
		} catch(Exception e){
			System.out.println("segfault ?" + e);
		}
	}

	public CollisionsManager(){
		itemlist = new ArrayList<Item>();
		fixeditemlist = new ArrayList<FixedItem>();
	}


	protected void register(Item item){
		this.itemlist.add(item);
	}
	protected void register(FixedItem item){
		this.fixeditemlist.add(item);
	}

	public void testCollisions(){
		this.tryToMove();
	}

	public void clearMe(){
		itemlist.clear();
		fixeditemlist.clear();
	}
}
