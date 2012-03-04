package fr.legbt.binge.items;

import java.util.ArrayList;

public class ActionsManager {
	private ArrayList<Item> itemlist;
	private ArrayList<FixedItem> fixeditemlist;

	public ActionsManager(){
		itemlist = new ArrayList<Item>();
		fixeditemlist = new ArrayList<FixedItem>();
	}

	public void actionThemAll(){
		try{
			for(int i=0;i<itemlist.size();i++){
				Item item = itemlist.get(i);
				item.action();
			}

		}catch(Exception e){
			System.out.println("ActionManager segfault ? " + e);
		}
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
