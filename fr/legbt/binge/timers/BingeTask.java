package fr.legbt.binge.timers;

import java.util.*;
import fr.legbt.binge.Binge;


public class BingeTask extends TimerTask {
	private Binge binge;
	public BingeTask(Binge abinge){
		this.binge = abinge;
	}

	public void run(){
		binge.timedActions();
	}
}
