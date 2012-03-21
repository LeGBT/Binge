package examples.bounce;

import fr.legbt.binge.Binge;
import fr.legbt.binge.LevelEditor;
import fr.legbt.binge.items.Borders;
import fr.legbt.binge.items.ItemFactory;

public class BouncingGame extends Binge{
	private static Counter score;

	public BouncingGame(ItemFactory factory, String name, String lvlfile, int width, int height, int framerate){
		super(factory,name,lvlfile,width,height,framerate);
	}
	public static void main(String arg[]){
		Factory factory = new Factory();
		BouncingGame jeux = new BouncingGame(factory,"jeux de boules","level",1280,720,20);
		score = new Counter(jeux,0,30,30);
		if((arg.length != 0)){
			System.out.println("reloaded");
			new Pad(jeux,1);
			new Balls(jeux,6,6,30,4);
			new Balls(jeux,5,6,30,2);
			new Balls(jeux,6,5,30,4);
			new Balls(jeux,8,4,30,2);
			new Balls(jeux,4,1,30,3);
			new Balls(jeux,2,5,30,1);
			new Balls(jeux,6,4,30,2);
			new Balls(jeux,5,3,30,2);
			new Balls(jeux,5,2,30,2);
			new Balls(jeux,5,1,30,2);
			new Balls(jeux,5,7,30,2);
			new Balls(jeux,6,8,30,2);
			new Balls(jeux,6,9,30,2);
			new Balls(jeux,7,10,30,2);
			new Balls(jeux,8,11,30,2);
			new Borders(jeux, 1200,0,700,50);
			new LevelEditor(jeux,"level");
			//	jeux.load();
		}else{
			jeux.load("level");
		}
	}

	@SuppressWarnings("static-access")
	public void upScore(){
		this.score.addCount();
	}
}
