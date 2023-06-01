package me.lava.slashdupe;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Slashdupe extends JavaPlugin {

    @Override
    public void onEnable() {
        Objects.requireNonNull(this.getCommand("dupe")).setExecutor(new DupeCmd());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
