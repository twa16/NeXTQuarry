/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.nextbattle.quarry.entities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.nextbattle.quarry.main.MainClass;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author Bodhi
 */
public class Configuration {

    private ArrayList<Material> cantbreak;
    private boolean privatequarries;
    private boolean autoupdate;
    private boolean updatenotify;
    private boolean continue_when_unloaded;
    private boolean continue_when_offline;
    private boolean dev_join_message;

    public static void loadConfig() {
        FileConfiguration fc = new YamlConfiguration().loadConfiguration(new File(MainClass.plugin.getDataFolder(), "config.yml"));
        MainClass.config = new Configuration(fc.getBoolean("private-quarries"), false, fc.getBoolean("auto-update"), fc.getBoolean("update-notify"), fc.getBoolean("continue-when-unloaded"), fc.getBoolean("continue-when-offline"), fc.getBoolean("dev-join-message"));
        List<?> list = fc.getList("ignored-blocks");
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                try {
                MainClass.config.addCantBreak(Material.getMaterial(Integer.parseInt(list.get(i).toString())));
                }
                catch (Exception e) {}
            }
        }
    }
    
    public boolean getDevJoinMsg()
    {
        return dev_join_message;
    }
    
    public boolean getContinue_when_unloaded()
    {
        return continue_when_unloaded;
    }
    public boolean getContinue_when_offline()
    {
        return continue_when_offline;
    }
    public boolean getAutoUpdate() {
        return autoupdate;
    }

    public boolean getUpdateNotify() {
        return updatenotify;
    }
    
    public Configuration() {
        cantbreak = new ArrayList<Material>();
        cantbreak.add(Material.BEDROCK);
        cantbreak.add(Material.OBSIDIAN);
        cantbreak.add(Material.STATIONARY_WATER);
        cantbreak.add(Material.STATIONARY_LAVA);
        cantbreak.add(Material.WATER);
        cantbreak.add(Material.LAVA);
        privatequarries = true;
        autoupdate = false;
        updatenotify = true;
        continue_when_unloaded = false;
        continue_when_offline = false;
        dev_join_message = true;
    }

    public Configuration(boolean privatequarries, boolean default_cantbreak, boolean autoupdate, boolean updatenotify, boolean continue_when_unloaded, boolean continue_when_offline, boolean dev_join_message) {
        cantbreak = new ArrayList<Material>();
        this.autoupdate = autoupdate;
        if (default_cantbreak) {
            cantbreak.add(Material.BEDROCK);
            cantbreak.add(Material.OBSIDIAN);
            cantbreak.add(Material.STATIONARY_WATER);
            cantbreak.add(Material.STATIONARY_LAVA);
            cantbreak.add(Material.WATER);
            cantbreak.add(Material.LAVA);
        }
        this.privatequarries = privatequarries;
        this.updatenotify = updatenotify;
        this.dev_join_message = dev_join_message;
    }

    public void addCantBreak(Material mat) {
        if (!cantbreak.contains(mat) && mat != null) {
            cantbreak.add(mat);
        }
    }

    public ArrayList<Material> getCantBreak() {
        return cantbreak;
    }

    public boolean getPrivateQuarries() {
        return privatequarries;
    }
}
