/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.nextbattle.quarry.support;

import java.util.logging.Level;
import net.nextbattle.quarry.main.MainClass;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;

/**
 *
 * @author Bodhi
 */
public class PluginSupport {

    public WorldGuard wg;
    public Factions fa;
    public CoreProtect cp;
    // PLANNED SUPPORT FOR PRISM
    //public Prism_ pm;

    public PluginSupport() {
        init();
    }

    public void logPlacement(String username, Location loc, int type, byte data) {
        if (cp != null) {
            cp.logPlacement(username, loc, type, data);
        }
    }

    public void logRemoval(String username, Location loc, int type, byte data) {
        if (cp != null) {
            cp.logRemoval(username, loc, type, data);
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
        if (Bukkit.getPluginManager().getPlugin("WorldGuard") != null) {
            wg = new WorldGuard();
            MainClass.plugin.getServer().getLogger().log(Level.INFO, "[NeXTQuarry] WorldGuard found & Attatched.");

        } else {
            wg = null;
        }
        if (Bukkit.getPluginManager().getPlugin("Factions") != null) {
            fa = new Factions();
            MainClass.plugin.getServer().getLogger().log(Level.INFO, "[NeXTQuarry] Factions found & Attatched.");

        } else {
            fa = null;
        }
        if (Bukkit.getPluginManager().getPlugin("CoreProtect") != null) {
            cp = new CoreProtect();
            MainClass.plugin.getServer().getLogger().log(Level.INFO, "[NeXTQuarry] CoreProtect found & Attatched.");

        } else {
            cp = null;
        }
        // PLANNED SUPPORT FOR PRISM
        /*if (Bukkit.getPluginManager().getPlugin("Prism") != null) {
            pm = new Prism_();
            MainClass.plugin.getServer().getLogger().log(Level.INFO, "[NeXTQuarry] Prism found & Attatched.");

        } else {
            pm = null;
        }*/
    }
}
