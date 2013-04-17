/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.nextbattle.quarry.support;

import java.util.logging.Level;
import net.nextbattle.quarry.main.MainClass;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;

/**
 *
 * @author Bodhi
 */
public class PluginSupport {

    public WorldGuard wg;
    public Factions fa;

    public PluginSupport() {
        init();
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
    }
}
