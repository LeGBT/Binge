package fr.legbt.binge.data;

import java.io.Serializable;
import fr.legbt.binge.items.*;
import fr.legbt.binge.*;


public class Level implements LevelModel, Serializable{
	private static final long serialVersionUID = 2l;
	private int lwidth;
	private int lheight;
	private DataItem[][] lvl;
	//	public ArrayList<Item> itemlist;

	protected void setLvl(DataItem[][] lvl){
		this.lvl = lvl;
	}
	protected DataItem[][] getLvl(){
		return this.lvl;
	}

	//	public ArrayList<Item> getItemList(){return itemlist;}
	//	public void addDataItem(DataItem ditem){itemlist.add(ditem);}

	//	public void printItemListNFO(){
	//		for(int i=0; i<itemlist.size() ;i++){
	//			itemlist.get(i).printNFO();
	//		}
	//	}

	public Level(int lw, int lh){
		this.lwidth = lw;
		this.lheight = lh;
		this.lvl = new DataItem[lw][lh]; 
		//		for(int line=0; line<lh; line++){
		//			for(int column=0; column<lw; column++){
		//				this.lvl[column][line] = new DataItem();
		//			}
		//		}
		//		this.itemlist = new ArrayList<Item>();
	}

	public DataItem[] getLine(int aline){
		if (aline>this.lheight){
			System.out.println("arg trop gros");
			return null;
		}
		DataItem[] theline = new DataItem[this.lwidth];
		for (int i=0; i<this.lwidth; i++){
			theline[i] = lvl[i][aline];
		}
		return theline;
	}

	public void setLine(int aline,DataItem[] line){
		for (int j=0; j<this.lwidth; j++){
			lvl[j][aline] = line[j];
		}
	}

	public DataItem getTile(int aline, int acolumn){
		return this.getLine(acolumn)[aline];	
	}

	public void setTile(int aline,int acolumn, DataItem tile){
		this.lvl[acolumn][aline] = tile;
	}

	public int getW(){return this.lwidth;}
	public int getH(){return this.lheight;}

	public static Level loadLvl(String lvlfile,Binge game){
		Level alvl = null;
		ItemShop shop = new ItemShop();
		try{
			alvl =  IOManager.readLevel(lvlfile);
		} catch(Exception e){
			System.out.println("level segfault :" + e);
			e.printStackTrace();
		}
		for(int line=0; line<alvl.lheight; line++){
			for(int column=0; column<alvl.lwidth; column++){
				DataItem	data = alvl.getLvl()[column][line];
				if (data != null) {
					shop.createItem(game,data,line,column);
				}
			}
		}
		return alvl;
	}
}
