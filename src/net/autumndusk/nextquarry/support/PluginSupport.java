package net.autumndusk.nextquarry.support;

import java.util.logging.Level;
import net.autumndusk.nextquarry.main.MainClass;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;

public class PluginSupport {

    public PS_WorldGuard wg;
    public PS_Factions fa;
    public PS_CoreProtect cp;
    public PS_LogBlock lb;
    public PS_Residence re;

    public PluginSupport() {
        init();
    }

    public void logPlacement(String username, Location loc, int type, byte data) {
        if (cp != null) {
            try {
                cp.logPlacement(username, loc, type, data);
            } catch (Exception e) {
                cp = null;
                Bukkit.getServer().getLogger().log(Level.INFO, "[NeXTQuarry] An error occurred with CoreProtect. CoreProtect has been detatched from NeXTQuarry.");
            }
        }
        if (lb != null) {
            try {
                lb.logPlacement(username, loc, type, data);
            } catch (Exception e) {
                lb = null;
                Bukkit.getServer().getLogger().log(Level.INFO, "[NeXTQuarry] An error occurred with LogBlock. LogBlock has been detatched from NeXTQuarry.");
            }
        }
    }

    public void logRemoval(String username, Location loc, int type, byte data) {
        if (cp != null) {
            try {
                cp.logRemoval(username, loc, type, data);
            } catch (Exception e) {
                cp = null;
                Bukkit.getServer().getLogger().log(Level.INFO, "[NeXTQuarry] An error occurred with CoreProtect. CoreProtect has been detatched from NeXTQuarry.");
            }
        }
        if (lb != null) {
            try {
                lb.logRemoval(username, loc, type, data);
            } catch (Exception e) {
                lb = null;
                Bukkit.getServer().getLogger().log(Level.INFO, "[NeXTQuarry] An error occurred with LogBlock. LogBlock has been detatched from NeXTQuarry.");
            }
        }
    }

    public boolean mayEditBlock(Block b, String playername) {
        boolean mayedit = true;
        if (wg != null) {
            if (mayedit) {
                mayedit = wg.mayEditBlock(b, playername);
            }
        }
        if (fa != null) {
            if (mayedit) {
                mayedit = fa.mayEditBlock(b, playername);
            }
        }
        return mayedit;
    }

    private void init() {
        if (Bukkit.getPluginManager().getPlugin("WorldGuard") != null && MainClass.config.worldguard_enabled) {
            wg = new PS_WorldGuard();
            MainClass.plugin.getServer().getLogger().log(Level.INFO, "[NeXTQuarry] WorldGuard found & Attatched.");

        } else {
            wg = null;
        }
        if (Bukkit.getPluginManager().getPlugin("Factions") != null && MainClass.config.factions_enabled) {
            fa = new PS_Factions();
            MainClass.plugin.getServer().getLogger().log(Level.INFO, "[NeXTQuarry] Factions found & Attatched.");

        } else {
            fa = null;
        }
        if (Bukkit.getPluginManager().getPlugin("CoreProtect") != null && MainClass.config.coreprotect_enabled) {
            cp = new PS_CoreProtect();
            MainClass.plugin.getServer().getLogger().log(Level.INFO, "[NeXTQuarry] CoreProtect found & Attatched.");

        } else {
            cp = null;
        }
        if (Bukkit.getPluginManager().getPlugin("LogBlock") != null  && MainClass.config.logblock_enabled) {
            lb = new PS_LogBlock();
            MainClass.plugin.getServer().getLogger().log(Level.INFO, "[NeXTQuarry] LogBlock found & Attatched.");
        } else {
            lb = null;
        }
        if (Bukkit.getPluginManager().getPlugin("Residence") != null  && MainClass.config.residence_enabled) {
            re = new PS_Residence();
            MainClass.plugin.getServer().getLogger().log(Level.INFO, "[NeXTQuarry] Residence found & Attatched.");
        } else {
            re = null;
        }
    }
}
