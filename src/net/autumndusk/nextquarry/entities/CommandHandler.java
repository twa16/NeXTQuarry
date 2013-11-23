package net.autumndusk.nextquarry.entities;

import net.autumndusk.nextquarry.main.MainClass;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CommandHandler implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender cs, Command cmnd, String string, String[] args) {
        if (cmnd.getName().equalsIgnoreCase("nextquarry")) {
            if (args.length == 1 && args[0].equals("items")) {
                if (!(cs instanceof Player)) {
                    cs.sendMessage(ChatColor.GOLD + MainClass.lang.noconsole);
                    return false;
                }
                Player p = (Player) cs;
                if (!p.hasPermission("nextquarry.admin")) {
                    cs.sendMessage(ChatColor.GOLD + MainClass.lang.nogiveperm);
                    return true;
                }
                Inventory inv = Bukkit.createInventory(null, 18, "NeXTQuarry Items");
                for (ItemStack is : MainClass.citems.items) {
                    inv.addItem(is);
                }
                p.openInventory(inv);
                return true;
            }
            
            if (args.length == 1 && args[0].equals("craft")) {
                if (!(cs instanceof Player)) {
                    cs.sendMessage(ChatColor.GOLD + MainClass.lang.noconsole);
                    return false;
                }
                Player p = (Player) cs;
                if (!p.hasPermission("newxtquarry.user.craft")) {
                    cs.sendMessage(ChatColor.GOLD + MainClass.lang.nogiveperm);
                    return true;
                }
                Inventory inv = Bukkit.createInventory(null, 18, "NeXTQuarry Crafting");
                for (ItemStack is : MainClass.citems.items) {
                    inv.addItem(is);
                }
                p.openInventory(inv);
                return true;
            }

            cs.sendMessage(ChatColor.GOLD + "----["+MainClass.lang.plugininfo+"]----");
            cs.sendMessage(ChatColor.GOLD + "NeXTQuarry v1.8.0 - "+MainClass.lang.codedby+" BeMacized");
            //cs.sendMessage(ChatColor.GOLD + MainClass.lang.website + "WEBSITEHERE");
            cs.sendMessage(ChatColor.GOLD + "BukkitDev: http://dev.bukkit.org/server-mods/nextquarry/");
            if (cs instanceof Player) {
                Player p = (Player) cs;
                cs.sendMessage(ChatColor.GOLD + "----["+MainClass.lang.perms+"]----");
                if (p.hasPermission("nextquarry.user.tier1")) {
                    cs.sendMessage(ChatColor.GREEN + MainClass.lang.tier1allow);
                } else {
                    cs.sendMessage(ChatColor.RED + MainClass.lang.tier1deny);
                }
                if (p.hasPermission("nextquarry.user.tier2")) {
                    cs.sendMessage(ChatColor.GREEN + MainClass.lang.tier2allow);
                } else {
                    cs.sendMessage(ChatColor.RED + MainClass.lang.tier2deny);
                }
                if (p.hasPermission("nextquarry.user.tier3")) {
                    cs.sendMessage(ChatColor.GREEN + MainClass.lang.tier3allow);
                } else {
                    cs.sendMessage(ChatColor.RED + MainClass.lang.tier3deny);
                }
                 if (p.hasPermission("nextquarry.user.craft")) {
                    cs.sendMessage(ChatColor.GREEN + MainClass.lang.craftallow);
                } else {
                    cs.sendMessage(ChatColor.RED + MainClass.lang.craftdeny);
                }
                if (MainClass.config.privatequarries) {
                    if (p.hasPermission("nextquarry.admin")) {
                        cs.sendMessage(ChatColor.GREEN + MainClass.lang.breakallquarries);
                        cs.sendMessage(ChatColor.GREEN + MainClass.lang.editallquarries);
                    } else if (p.hasPermission("nextquarry.user.remove")) {
                        cs.sendMessage(ChatColor.GOLD + MainClass.lang.breakprivatequarries);
                        if (p.hasPermission("nextquarry.user.edit")) {
                            cs.sendMessage(ChatColor.GOLD + MainClass.lang.editprivatequarries);
                        } else {
                            cs.sendMessage(ChatColor.RED + MainClass.lang.noeditquarries);
                        }
                    } else {
                        cs.sendMessage(ChatColor.RED + MainClass.lang.nobreakquarries);
                        if (p.hasPermission("nextquarry.user.edit")) {
                            cs.sendMessage(ChatColor.GOLD + MainClass.lang.editprivatequarries);
                        } else {
                            cs.sendMessage(ChatColor.RED + MainClass.lang.noeditquarries);
                        }
                    }

                } else {
                    if (p.hasPermission("nextquarry.admin")) {
                        cs.sendMessage(ChatColor.GREEN + MainClass.lang.editallquarries);
                    }
                    if (p.hasPermission("nextquarry.admin") || p.hasPermission("nextquarry.user.remove")) {
                        cs.sendMessage(ChatColor.GREEN + MainClass.lang.breakallquarries);
                    } else {
                        cs.sendMessage(ChatColor.RED + MainClass.lang.nobreakquarries);
                    }
                    if (p.hasPermission("nextquarry.user.edit")) {
                        cs.sendMessage(ChatColor.GREEN + MainClass.lang.editallquarries);
                    } else {
                        cs.sendMessage(ChatColor.RED + MainClass.lang.noeditquarries);
                    }
                }
            }
            return true;
        }

        return true;
    }
}
