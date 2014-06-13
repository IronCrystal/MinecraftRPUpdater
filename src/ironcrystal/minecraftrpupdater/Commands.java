package ironcrystal.minecraftrpupdater;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Commands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("update") && sender.hasPermission("MinecraftRP.update")) {
			Bukkit.broadcastMessage(ChatColor.GREEN + "[MinecraftRPUpdater] Downloading new version of MinecraftRP!");
			Bukkit.broadcastMessage(ChatColor.GREEN + "[MinecraftRPUpdater] There may be some lag. Please be patient.");
			
			File file = new File("plugins/MinecraftRP.jar");
			URL url = null;
			try {
				url = new URL("https://drone.io/github.com/IronCrystal/MinecraftRP/files/target/MinecraftRP-0.0.1-SNAPSHOT.jar");
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			try {
				FileUtils.copyURLToFile(url, file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			Bukkit.getServer().reload();
			Bukkit.broadcastMessage(ChatColor.GREEN + "[MinecraftRPUpdator] Update complete!");
			Bukkit.broadcastMessage(ChatColor.GREEN + "[MinecraftRPUpdator] There may or may not be new features!");
		}
		return false;
	}

}
