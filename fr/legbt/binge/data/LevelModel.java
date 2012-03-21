package fr.legbt.binge.data;

import fr.legbt.binge.items.*;
//import java.util.ArrayList;


public interface LevelModel {
	public DataItem[] getLine(int aline);
	public void setLine(int aline,DataItem[] line);
	public DataItem getTile(int aline,int acolumn);
	public void setTile(int aline,int acolumn,DataItem tile);
	public int getW();
	public int getH();
//	public void addDataItem(DataItem ditem);
//	public ArrayList<Item> getItemList();
}
