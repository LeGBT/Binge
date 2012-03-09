package fr.legbt.binge.data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.*;

public class IOManager {
	public static void storeLevel(Level lvl) throws Exception  {
		FileOutputStream out = null;
		GZIPOutputStream zout = null;
		try{
			out = new FileOutputStream("test.bgcd"); //BinGe Comperss Data
			zout = new GZIPOutputStream(out); //BinGe Comperss Data
			zout.write(1);
			zout.write(12);
			zout.write(2);
			zout.write(1);
			zout.write(14);
			zout.write(lvl.getW());
			zout.write(lvl.getH());
			zout.write((lvl.getW()+lvl.getH()) % 31);
			zout.write(14);
			zout.write(1);
			zout.write(2);
			zout.write(12);
			zout.write(1);
			for(int i=0 ; i<lvl.getH() ; i++){
				for(int data : lvl.getLine(i)){
					zout.write(data);
				}
			}
		} finally {
			if (out != null){
				zout.close();
				out.close();
			}
		}
	}
}
