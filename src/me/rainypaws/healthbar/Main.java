package me.rainypaws.healthbar;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new MobListener(), this);
    }

    @Override
    public void onDisable() {

    }
}

