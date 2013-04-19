package net.nextbattle.quarry.entities;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import net.nextbattle.quarry.main.MainClass;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Configuration {

    private ArrayList<Material> cantbreak;
    private boolean privatequarries;
    private boolean autoupdate;
    private boolean updatenotify;
    private boolean continue_when_unloaded;
    private boolean continue_when_offline;
    private boolean dev_join_message;
    private boolean send_usage_data;
    public Material speed_upgrade = Material.WATCH;
    public Material wrench_tool = Material.BLAZE_ROD;
    public Material fuel_tool = Material.BUCKET;
    public Material fuel_upgrade = Material.TRAP_DOOR;
    public Material chest_miner = Material.GOLD_AXE;

    public static void loadConfig() {
        FileConfiguration fc = new YamlConfiguration().loadConfiguration(new File(MainClass.plugin.getDataFolder(), "config.yml"));
        MainClass.config = new Configuration(fc.getBoolean("private-quarries"), false, fc.getBoolean("auto-update"), fc.getBoolean("update-notify"), fc.getBoolean("continue-when-unloaded"), fc.getBoolean("continue-when-offline"), fc.getBoolean("dev-join-message"), fc.getBoolean("send-usage-data"));
        List<?> list = fc.getList("ignored-blocks");
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                try {
                MainClass.config.addCantBreak(Material.getMaterial(Integer.parseInt(list.get(i).toString())));
                }
                catch (Exception e) {}
            }
        }
        MainClass.config.speed_upgrade = Material.getMaterial(fc.getInt("speed_upgrade"));
        MainClass.config.wrench_tool = Material.getMaterial(fc.getInt("wrench_tool"));
        MainClass.config.fuel_tool = Material.getMaterial(fc.getInt("fuel_tool"));
        MainClass.config.fuel_upgrade = Material.getMaterial(fc.getInt("fuel_upgrade"));
        MainClass.config.chest_miner = Material.getMaterial(fc.getInt("chest_miner"));        
    }
    
    public boolean getSendUsageData()
    {
        return send_usage_data;
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
        cantbreak = new ArrayList<>();
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
        send_usage_data = true;
    }

    public Configuration(boolean privatequarries, boolean default_cantbreak, boolean autoupdate, boolean updatenotify, boolean continue_when_unloaded, boolean continue_when_offline, boolean dev_join_message, boolean send_usage_data) {
        cantbreak = new ArrayList<>();
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
        this.send_usage_data = send_usage_data;
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
