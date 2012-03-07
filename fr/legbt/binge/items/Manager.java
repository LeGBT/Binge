package fr.legbt.binge.items;

import java.util.ArrayList;

public class Manager{
	protected ArrayList<MovableItem> movableitemlist;
	protected ArrayList<FixedItem> fixeditemlist;

	public Manager(){
		movableitemlist = new ArrayList<MovableItem>();
		fixeditemlist = new ArrayList<FixedItem>();
	}

	void registerToFixed(FixedItem fitem){
		this.fixeditemlist.add(fitem);
	}
	void registerToMovable(MovableItem mitem){
		this.movableitemlist.add(mitem);
	}

	public void register(MovableItem mitem){
		this.movableitemlist.add(mitem);
	}

	public void register(FixedItem fitem){
		this.fixeditemlist.add(fitem);
	}

	public void clearMe(){
		movableitemlist.clear();
		fixeditemlist.clear();
	}
}
