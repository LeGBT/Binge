package fr.legbt.binge.data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.zip.*;

public class IOManager {
	public static void storeLevel(Level lvl) throws Exception  {
		FileOutputStream out = null;
		GZIPOutputStream zout = null;
		ObjectOutputStream oos = null;
		try{
			out = new FileOutputStream("level.bgcd"); //BinGe Comperss Data
			zout = new GZIPOutputStream(out); //BinGe Comperss Data
			oos = new ObjectOutputStream(zout);
			oos.writeInt(1);
			oos.writeInt(12);
			oos.writeInt(2);
			oos.writeInt(1);
			oos.writeInt(14);
			oos.writeInt(lvl.getW());
			oos.writeInt(lvl.getH());
			oos.writeInt((lvl.getW()+lvl.getH()) % 31);
			oos.writeInt(14);
			oos.writeInt(1);
			oos.writeInt(2);
			oos.writeInt(12);
			oos.writeInt(1);
			oos.writeObject(lvl);
		} finally {
			if (out != null){
				oos.close();
				zout.close();
				out.close();
			}
		}
	}

	public static Level readLevel() throws Exception {
		int w;
		int h;
		FileInputStream input = new FileInputStream("level.bgcd"); 
		GZIPInputStream zinput = new GZIPInputStream(input);
		ObjectInputStream ois = new ObjectInputStream(zinput);
		try {
			ois.readInt();
			ois.readInt();
			ois.readInt();
			ois.readInt();
			ois.readInt();
			w = ois.readInt();	
			h = ois.readInt();
			if(h+w % 31 != ois.readInt()){
			new	Exception("bad file");}
			ois.readInt();
			ois.readInt();
			ois.readInt();
			ois.readInt();
			ois.readInt();
			return (Level) ois.readObject();
		} finally {
			if (input != null){
				ois.close();
				zinput.close();
				input.close();
			}
		}
	}
}
