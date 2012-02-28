package fr.legbt.binge.timers;

import java.util.*;
import fr.legbt.binge.Binge;

public class BingeTask extends TimerTask {
	private Binge plugin;
	public BingeTask(Binge plugin){
		this.plugin = plugin;
	}

	public void run(){
		plugin.timedActions();
	}
}
