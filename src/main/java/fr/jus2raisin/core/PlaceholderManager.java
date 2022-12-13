package fr.jus2raisin.core;

import fr.jus2raisin.HealthUnicodePlugin;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;



public class PlaceholderManager extends PlaceholderExpansion {

    HealthUnicodePlugin healthUnicodePlugin;
    public PlaceholderManager(HealthUnicodePlugin healthUnicodePlugin) {
        this.healthUnicodePlugin = healthUnicodePlugin;
    }


    @Override
    public @NotNull String getIdentifier() {
        return this.healthUnicodePlugin.getDescription().getName();
    }

    @Override
    public @NotNull String getAuthor() {
        return this.healthUnicodePlugin.getDescription().getAuthors().get(0);
    }

    @Override
    public @NotNull String getVersion() {
        return this.healthUnicodePlugin.getDescription().getVersion();
    }

    @Override
    public String onRequest(OfflinePlayer player, @NotNull String params) {
        final String[] args = params.split("_");

        if (args[0].equalsIgnoreCase("health")) {
            return this.healthUnicodePlugin.getConfig().getString(String.valueOf(this.doubleToInt(player.getPlayer().getHealth())));
        }
        return null;
    }

    private int doubleToInt(double number) {
        return (int) Math.round(number);
    }

}
