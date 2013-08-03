package net.autumndusk.nextquarry.support;


import com.massivecraft.factions.entity.BoardColls;
import com.massivecraft.factions.entity.Faction;
import com.massivecraft.factions.entity.UPlayer;
import com.massivecraft.mcore.ps.PS;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class PS_Factions {
    public boolean mayEditBlock(Block b, String player) {
        Player p = Bukkit.getServer().getPlayer(player);
        if (p != null) {
            UPlayer uplayer = UPlayer.get(p);
            Faction faction = BoardColls.get().getFactionAt(PS.valueOf(b.getLocation()));
            if (faction.isNone()) {
                return true;
            }
            if (faction.equals(uplayer.getFaction()))
            {
                return true;
            }
        }
        return false;
    }
}
