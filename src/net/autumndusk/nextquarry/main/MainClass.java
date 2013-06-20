package net.autumndusk.nextquarry.main;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import net.autumndusk.nextquarry.entities.CommandHandler;
import net.autumndusk.nextquarry.entities.Configuration;
import net.autumndusk.nextquarry.entities.CustomItems;
import net.autumndusk.nextquarry.entities.Language;
import net.autumndusk.nextquarry.entities.Quarry;
import net.autumndusk.nextquarry.metrics.Metrics;
import net.autumndusk.nextquarry.support.PluginSupport;
import net.autumndusk.nextquarry.updater.Updater;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class MainClass extends JavaPlugin {

    public static Plugin plugin;
    public static Configuration config;
    public static CustomItems citems;
    public static int timer;
    public static int savetimer;
    public static CommandHandler ch;
    public static PluginSupport ps;
    public static Language lang;

    public static void main(String[] args) {
        System.out.println("NeXTQuarry is a plugin for MineCraft servers based on CraftBukkit.");
        System.out.println("Please place NeXTQuarry.jar (this file) in the plugins directory of your CraftBukkit installation.");
        System.out.println("You can then use it by launching the Craftbukkit server.");
    }

    @Override
    public void onEnable() {
        //Define plugin
        plugin = this;

        //Event Listener
        getServer().getPluginManager().registerEvents(new GeneralEventListener(), plugin);

        //Data Folders
        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdir();
        }
        File quarrydir = new File(plugin.getDataFolder(), "/quarries");
        if (!quarrydir.exists()) {
            quarrydir.mkdir();
        }

        //Languages
        if (!(new File(plugin.getDataFolder(), "lang.yml")).exists()) {
            plugin.saveResource("lang.yml", false);
        }
        Language.loadFile();

        //Initialize Command Handler
        ch = new CommandHandler();
        getCommand("nextquarry").setExecutor(ch);

        //Config
        if (!(new File(plugin.getDataFolder(), "config.yml")).exists()) {
            plugin.saveDefaultConfig();
        }
        plugin.reloadConfig();
        Configuration.loadConfig();

        //Initialize Custom Items
        citems = new CustomItems();
        citems.addRecipes();

        //Plugin Support
        ps = new PluginSupport();

        //Updater
        try {
            Updater updater = null;
            if (config.autoupdate) {
                updater = new Updater(this, "nextquarry", this.getFile(), Updater.UpdateType.DEFAULT, true);
                Updater.updateResultCustom(updater);
            } else if (config.autoupdate) {
                updater = new Updater(this, "nextquarry", this.getFile(), Updater.UpdateType.NO_DOWNLOAD, true);
                Updater.updateResultCustom(updater);
            }
        } catch (Exception e) {
        }
        
        //Load Quarries
        File dir = new File(plugin.getDataFolder(), "/quarries");
        for (File child : dir.listFiles()) {
            Quarry.LoadQuarry(child);
        }

        //Plugin Metrics
        if (config.send_usage_data) {
            try {
                Metrics metrics = new Metrics(this);
                Metrics.initMetrics(metrics);
                metrics.start();
            } catch (IOException e) {
            }
        }

        //Main Timer
        timer = getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                for (Quarry q : Quarry.quarrylist) {
                    q.doTick();
                }
            }
        }, 0, 5L);

        savetimer = getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                getServer().getLogger().log(Level.INFO, "NeXTQuarry: " + lang.saving);
                Quarry.saveAll();
                getServer().getLogger().log(Level.INFO, "NeXTQuarry: " + lang.saved);
            }
        }, 20L * (config.save_interval), 20L * (config.save_interval));
    }

    @Override
    public void onDisable() {
        getServer().getScheduler().cancelTask(timer);
        getServer().getScheduler().cancelTask(savetimer);
        getServer().getLogger().log(Level.INFO, "NeXTQuarry: " + lang.saving);
        Quarry.saveAll();
        getServer().getLogger().log(Level.INFO, "NeXTQuarry: " + lang.saved);
    }
}