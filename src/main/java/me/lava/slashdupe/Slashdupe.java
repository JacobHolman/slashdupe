package me.lava.slashdupe;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Slashdupe extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig(); // Save the config.yml to the plugins folder

        Objects.requireNonNull(this.getCommand("dupe")).setExecutor(new DupeCmd(this));
    }

    /**
     * Get a section of the config with a string
     * @param path Path to config section
     * @return The value stored at the path
     */
    public String getConfigString(String path) {
        return getConfig().getString(path);
    }
}
