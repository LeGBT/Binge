package examples.bounce;

import fr.legbt.binge.Binge;
import fr.legbt.binge.items.DataItem;
import fr.legbt.binge.items.ItemFactory;


public class Factory extends ItemFactory {

	public Factory(){
		super();
	}

	public Balls createBalls(Binge game, DataItem data, int line, int column){
		Balls b = new Balls(data,column,line,30,5d);
		b.setGame(game);
		return b;
	}

	public Pad createPad(Binge game, DataItem data, int line, int column){
		return new Pad(game,column);
	}

}
