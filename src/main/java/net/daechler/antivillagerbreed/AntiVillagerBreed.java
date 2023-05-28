package net.daechler.antivillagerbreed;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.entity.Villager;
import org.bukkit.event.entity.EntityBreedEvent;

public class AntiVillagerBreed extends JavaPlugin implements Listener {

    // This method is called when the plugin is enabled
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + getName() + " has been enabled!");
    }

    // This method is called when the plugin is disabled
    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + getName() + " has been disabled!");
    }

    // Event handler to prevent villagers from breeding
    @EventHandler
    public void onEntityBreed(EntityBreedEvent event) {
        // If the breeder is a villager, cancel the event
        if (event.getBreeder() instanceof Villager) {
            event.setCancelled(true);
        }
    }
}
