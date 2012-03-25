package fr.legbt.binge.graphics;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.io.File;
import javax.imageio.ImageIO;


public class TexturesLoader {
	private HashMap<String,BufferedImage> textures;

	public TexturesLoader(){
		textures = new HashMap<String,BufferedImage>();
		try{
			String[] list = new File("./textures").list();
			for (int i=0; i<list.length; i++){
				File file = new File("./textures/"+list[i]);
				BufferedImage img = ImageIO.read(file);
				this.textures.put(list[i],img);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public BufferedImage get(String image){
		if(textures.containsKey(image)){
			return textures.get(image);
		}else {
			System.out.println("no such texture : "+image);
			System.out.println("available textures : "+textures.keySet());
			return null;
		}
	}


}
