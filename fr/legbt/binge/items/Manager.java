package fr.legbt.binge.items;

import java.util.ArrayList;

public class Manager{
	protected ArrayList<Item> itemlist;
	protected ArrayList<FixedItem> fixeditemlist;

	public Manager(){
		itemlist = new ArrayList<Item>();
		fixeditemlist = new ArrayList<FixedItem>();
	}

	public void register(Item item){
		this.itemlist.add(item);
	}

	public void register(FixedItem fixeditem){
		this.fixeditemlist.add(fixeditem);
	}

	public void clearMe(){
		itemlist.clear();
		fixeditemlist.clear();
	}



}
