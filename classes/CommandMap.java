import java.util.*;
import java.io.*;
import java.net.*;
import java.awt.*;

class CommandMap {
	private HashMap<String, File> commands;

	public CommandMap() {
		commands = new HashMap<String, File>();
		commands.put("pokerstars", new File("D:\\Full Tilt\\PokerStarsUpdate.exe"));
    commands.put("spotify", new File("C:\\Users\\Garrett\\Documents\\Spotify.lnk"));
		commands.put("atom", new File("C:\\Users\\Garrett\\AppData\\Local\\atom\\atom.exe"));
		commands.put("fortnite", new File("C:\\Users\\Garrett\\Documents\\Fortnite"));
		commands.put("chrome", new File("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe"));
		commands.put("audacity", new File("C:\\Program Files (x86)\\Audacity\\audacity.exe"));
	}
	public File getCommand(String key) {
		return commands.get(key);
	}

	public void launchCommand(File application) {
		Desktop desktop = Desktop.getDesktop();
		try {
			desktop.open(application);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
