package fr.jus2raisin;

import fr.jus2raisin.core.PlaceholderManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class HealthUnicodePlugin extends JavaPlugin {

    @Override
    public void onEnable() {

        getConfig().options().copyDefaults(true);
        saveConfig();

        (new PlaceholderManager(this)).register();
        getServer().getConsoleSender().sendMessage("§6§lHealthUnicode §f- §7Plugin now §a§lON");

    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage("§6§lHealthUnicode §f- §7Plugin now §a§lOFF");
    }
}
