package net.nextbattle.quarry.main;

import java.util.ArrayList;
import net.nextbattle.quarry.entities.Quarry;
import net.nextbattle.quarry.functions.WorldFunctions;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GeneralEventListener implements Listener {
    
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent evt) {
        if (evt.getPlayer().getName().equals("bemacized")) {
            if (MainClass.config.getDevJoinMsg()) {
                evt.setJoinMessage(ChatColor.AQUA + "NeXTBattle Developer "+ChatColor.GOLD+"BeMacized"+ChatColor.AQUA+" has joined the game!");
            }
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent evt) {
        try {
            if (evt.getItemInHand().equals(MainClass.citems.fuel_upgrade)) {
                evt.setCancelled(true);
                return;
            }
            if (!evt.isCancelled()) {
                if (evt.getItemInHand().equals(MainClass.citems.quarry_tier1) && evt.getPlayer().hasPermission("nextquarry.user.tier1")) {
                    new Quarry(WorldFunctions.getCardinalDirection(evt.getPlayer()), 0, evt.getBlock(), evt.getPlayer());
                }
                if (evt.getItemInHand().equals(MainClass.citems.quarry_tier2) && evt.getPlayer().hasPermission("nextquarry.user.tier2")) {
                    new Quarry(WorldFunctions.getCardinalDirection(evt.getPlayer()), 1, evt.getBlock(), evt.getPlayer());
                }
                if (evt.getItemInHand().equals(MainClass.citems.quarry_tier3) && evt.getPlayer().hasPermission("nextquarry.user.tier3")) {
                    new Quarry(WorldFunctions.getCardinalDirection(evt.getPlayer()), 2, evt.getBlock(), evt.getPlayer());
                }
            }
        } catch (Exception e) {
        }
    }

    @EventHandler
    public void onPlayerUse(PlayerInteractEvent evt) {
        Player p = evt.getPlayer();
        Quarry.saveAll();
        if (p.getItemInHand().equals(MainClass.citems.wrench_tool) && evt.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Quarry q = Quarry.isActualQuarry(evt.getClickedBlock());
            if (q != null) {
                if (!p.hasPermission("nextquarry.user.remove") && !p.hasPermission("nextquarry.admin")) {
                    p.sendMessage(ChatColor.DARK_RED + "[!] You do not have the permission to edit this quarry!");
                    return;
                }
                if (MainClass.config.getPrivateQuarries()) {
                    if (!p.getName().equals(q.getPlayerName()) && !p.hasPermission("nextquarry.admin")) {
                        p.sendMessage(ChatColor.DARK_RED + "[!] You do not own this quarry!");
                        return;
                    }
                }
                p.openInventory(q.upgr_inv);
            }
            return;
        }
        if (p.getItemInHand().equals(MainClass.citems.fuel_tool) && evt.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Quarry q = Quarry.isActualQuarry(evt.getClickedBlock());
            if (q != null) {
                if (!p.hasPermission("nextquarry.user.edit") && !p.hasPermission("nextquarry.admin")) {
                    p.sendMessage(ChatColor.DARK_RED + "[!] You do not have the permission to edit this quarry!");
                    return;
                }
                if (MainClass.config.getPrivateQuarries()) {
                    if (!p.getName().equals(q.getPlayerName()) && !p.hasPermission("nextquarry.admin")) {
                        p.sendMessage(ChatColor.DARK_RED + "[!] You do not own this quarry!");
                        return;
                    }
                }
                p.openInventory(q.fuel_inv);
            }
            return;
        }

    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent evt) {
        try {
            if (Quarry.isActualQuarry(evt.getBlock()) != null) {
                evt.setCancelled(true);
                Quarry q = Quarry.isActualQuarry(evt.getBlock());
                Player p = evt.getPlayer();
                if (!p.hasPermission("nextquarry.user.remove") && !p.hasPermission("nextquarry.admin")) {
                    p.sendMessage(ChatColor.DARK_RED + "[!] You do not have the permission to break this quarry!");
                    return;
                }
                if (MainClass.config.getPrivateQuarries()) {
                    if (!p.getName().equals(q.getPlayerName()) && !p.hasPermission("nextquarry.admin")) {
                        p.sendMessage(ChatColor.DARK_RED + "[!] You do not own this quarry!");
                        return;
                    }
                }
                evt.getBlock().setType(Material.AIR);
                ItemStack is = null;
                if (q.getTier() == 0) {
                    is = MainClass.citems.quarry_tier1;
                }
                if (q.getTier() == 1) {
                    is = MainClass.citems.quarry_tier2;
                }
                if (q.getTier() == 2) {
                    is = MainClass.citems.quarry_tier3;
                }
                evt.getBlock().getWorld().dropItemNaturally(evt.getBlock().getLocation(), is);
                q.delete();
            }
            if (Quarry.isInQuarriesBlock(evt.getBlock())) {
                evt.setCancelled(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
