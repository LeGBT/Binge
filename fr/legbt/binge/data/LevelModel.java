package fr.legbt.binge.data;

import fr.legbt.binge.items.*;
import java.util.ArrayList;


public interface LevelModel {
	public int[] getLine(int aline);
	public void setLine(int aline,int[] line);
	public int getTile(int aline,int acolumn);
	public void setTile(int aline,int acolumn,int tile);
	public int getW();
	public int getH();
	public void addItem(Item item);
	public ArrayList<Item> getItemList();
}
