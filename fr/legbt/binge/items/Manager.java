package fr.legbt.binge.items;

import java.util.ArrayList;
import fr.legbt.binge.ui.*;

public class Manager{
	protected ArrayList<MovableItem> movableitemlist;
	protected ArrayList<FixedItem> fixeditemlist;
	protected ArrayList<StaticInfo> staticinfolist;

	public Manager(){
		movableitemlist = new ArrayList<MovableItem>();
		fixeditemlist = new ArrayList<FixedItem>();
		staticinfolist = new ArrayList<StaticInfo>();
	}

	public void register(MovableItem mitem){this.movableitemlist.add(mitem);}
	public void register(FixedItem fitem){this.fixeditemlist.add(fitem);}
	public void register(StaticInfo sti){this.staticinfolist.add(sti);}
	public void unRegister(MovableItem mitem){this.movableitemlist.remove(movableitemlist.indexOf(mitem));}
	public void unRegister(FixedItem fitem){this.movableitemlist.remove(movableitemlist.indexOf(fitem));}
	public void unRegister(StaticInfo sti){this.movableitemlist.remove(movableitemlist.indexOf(sti));}

	public void clearMe(){
		movableitemlist.clear();
		fixeditemlist.clear();
		staticinfolist.clear();
	}
}
