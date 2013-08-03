package net.autumndusk.nextquarry.support;

import com.bekvon.bukkit.residence.Residence;
import com.bekvon.bukkit.residence.protection.FlagPermissions;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

/**
 * Code written by BeMacized (Bodhi Mulders) Visit http://www.autumndusk.net/
 * for more information
 */
public class PS_Residence {

    public boolean mayEditBlock(Block b, String player) {
        Player p = Bukkit.getServer().getPlayer(player);
        if (p != null) {
            FlagPermissions perms = Residence.getPermsByLoc(b.getLocation());
            boolean hasPermission = perms.playerHas(player, p.getLocation().getWorld().getName(), player, true);
            if (hasPermission) {
                return true;
            }
        }
        return false;
    }
}
