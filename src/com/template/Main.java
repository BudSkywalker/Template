package com.template;

import com.template.ge.Game;
import com.template.util.Commands;
import com.template.util.Config;
import com.template.util.Console;
import com.template.util.Log;

public class Main {	
	static Runnable console = new Console();
	
	static Game game = new Game();
	
	public static void main(String[] args) {
		Log.reset("latest.log");
		addConfig();
		Log.out("Configuration loaded");
		addCommands();
		Log.out("Commands loaded");
		if(Config.get("displayconsole").equals("true")) {
			console.run();
			Log.element("Console", "frmConsole", "Displayed");
		} else if(Config.get("displayconsole").equals("false")) {
		} else {
			Log.warning("Unknow argument " + Config.get("displayconsole") + " in config.properties. Must be true or false");
		}
		game.start();
	}
	
	public static void addCommands() {
		Commands.add("help", "help", "Displays all commands");
		Log.out("Help command added");
	}
	
	public static void addConfig() {
		Config.add("keeplogs", "true");
		Config.add("quicklaunch", "true");
		Config.add("displayconsole", "false");
		Config.store();
	}
}
