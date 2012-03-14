package fr.legbt.binge.data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.zip.*;

public class IOManager {
	public static void writeLvl(Level lvl,String lvlfile) throws Exception  {
		FileOutputStream out = null;
		GZIPOutputStream zout = null;
		ObjectOutputStream oos = null;
		try{
			out = new FileOutputStream(lvlfile+".bgcd"); //BinGe Comperss Data
			zout = new GZIPOutputStream(out); //BinGe Comperss Data
			oos = new ObjectOutputStream(zout);
			oos.writeObject(lvl);
		} finally {
			if (out != null){
				oos.close();
				zout.close();
				out.close();
			}

		}
	}
		//small test

		public static Level readLevel(String lvlfile) throws Exception {
			int w;
			int h;
			FileInputStream input = new FileInputStream(lvlfile+".bgcd"); 
			GZIPInputStream zinput = new GZIPInputStream(input);
			ObjectInputStream ois = new ObjectInputStream(zinput);
			try {
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
