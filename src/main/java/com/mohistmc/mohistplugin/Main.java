package com.mohistmc.mohistplugin;

import com.mohistmc.api.ServerAPI;
import com.mohistmc.api.event.BukkitHookForgeEvent;
import net.minecraftforge.event.ServerChatEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    public static Main plugin;

    @Override
    public void onEnable() {
        plugin = this;
        getConfig().options().copyDefaults(true);
        saveConfig();
        saveDefaultConfig();
        reloadConfig();
        ServerAPI.putBukkitEvents(this, this);
        if (ServerAPI.hasMod("mohist")) { // only 1.20.1 +
            Bukkit.getLogger().info("Successful hook mohist mod!");
        }
    }

    public void onDisable() {
    }
}
