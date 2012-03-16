package examples.bouncing_balls;

import java.awt.*;
import fr.legbt.binge.ui.StaticInfo;
import fr.legbt.binge.Binge;

public class Counter extends StaticInfo{
	private int count;
	private int xpos;
	private int ypos;

	public Counter(Binge game,int count, int x, int y){
		super(game);
		this.count = count;
		this.xpos = x;
		this.ypos = y;
	}

	public void addCount(){
		this.count += 1;
	}

	public void traceMe(Binge game){
		Graphics2D g2d = (Graphics2D) game.getGraphics();	
		Font f = new Font("Casual",Font.PLAIN, 40);
		g2d.setFont(f);
		g2d.setColor(Color.RED);	
		g2d.drawString(Integer.toString(count),this.xpos,this.ypos);
	}
}
