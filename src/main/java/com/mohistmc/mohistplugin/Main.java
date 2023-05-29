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
        ServerAPI.registerBukkitEvents(this, this);
        if (ServerAPI.hasMod("pixelmon")) {
            Bukkit.getLogger().info("Successful hook pixelmon mod!");
        }
    }

    public void onDisable() {
    }

    @EventHandler
    public void onTest(BukkitHookForgeEvent e) {
        if (e.getEvent() instanceof ServerChatEvent) {
            ServerChatEvent chatEvent = (ServerChatEvent) e.getEvent();
            Bukkit.getLogger().info(chatEvent.getMessage());
        }
    }
}
