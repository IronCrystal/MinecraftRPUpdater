package ironcrystal.minecraftrpupdater;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class MinecraftRPUpdater extends JavaPlugin {
	
	@Override
	public void onEnable() {
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Updater(), 0, 24000L);
		
		/**
		 * Commands
		 */
		Commands commands = new Commands();
		getCommand("update").setExecutor(commands);
	}
	
	@Override
	public void onDisable() {
		
	}

}
