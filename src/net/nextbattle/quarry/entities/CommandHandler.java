package net.nextbattle.quarry.entities;

import net.nextbattle.quarry.main.MainClass;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHandler implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender cs, Command cmnd, String string, String[] strings) {
        if (cmnd.getName().equalsIgnoreCase("nextquarry")) {
            cs.sendMessage(ChatColor.GOLD + "----[NeXTQuarry Plugin Info]----");
            cs.sendMessage(ChatColor.GOLD + "NeXTQuarry v1.3.0 BETA - Coded by BeMacized");
            cs.sendMessage(ChatColor.GOLD + "Website: http://www.nextbattle.net/");
            if (cs instanceof Player) {
                Player p = (Player) cs;
                cs.sendMessage(ChatColor.GOLD + "----[NeXTQuarry Permissions]----");
                if (p.hasPermission("nextquarry.user.tier1")) {
                    cs.sendMessage(ChatColor.GREEN + "You are allowed to place tier 1 quarries.");
                } else {
                    cs.sendMessage(ChatColor.RED + "You are NOT allowed to place tier 1 quarries.");
                }
                if (p.hasPermission("nextquarry.user.tier2")) {
                    cs.sendMessage(ChatColor.GREEN + "You are allowed to place tier 2 quarries.");
                } else {
                    cs.sendMessage(ChatColor.RED + "You are NOT allowed to place tier 2 quarries.");
                }
                if (p.hasPermission("nextquarry.user.tier3")) {
                    cs.sendMessage(ChatColor.GREEN + "You are allowed to place tier 3 quarries.");
                } else {
                    cs.sendMessage(ChatColor.RED + "You are NOT allowed to place tier 3 quarries.");
                }
                if (MainClass.config.privatequarries) {
                    if (p.hasPermission("nextquarry.admin")) {
                        cs.sendMessage(ChatColor.GREEN + "You are allowed to break all quarries.");
                        cs.sendMessage(ChatColor.GREEN + "You are allowed to edit all quarries.");
                    } else if (p.hasPermission("nextquarry.user.remove")) {
                        cs.sendMessage(ChatColor.GOLD + "You are allowed to break YOUR quarries only.");
                        if (p.hasPermission("nextquarry.user.edit")) {
                            cs.sendMessage(ChatColor.GOLD + "You are allowed to edit YOUR quarries only.");
                        } else {
                            cs.sendMessage(ChatColor.RED + "You are NOT allowed to edit quarries.");
                        }
                    } else {
                        cs.sendMessage(ChatColor.RED + "You are NOT allowed to break quarries.");
                        if (p.hasPermission("nextquarry.user.edit")) {
                            cs.sendMessage(ChatColor.GOLD + "You are allowed to edit YOUR quarries only.");
                        } else {
                            cs.sendMessage(ChatColor.RED + "You are NOT allowed to edit quarries.");
                        }
                    }

                } else {
                    if (p.hasPermission("nextquarry.admin")) {
                        cs.sendMessage(ChatColor.GREEN + "You are allowed to edit all quarries.");
                    }
                    if (p.hasPermission("nextquarry.admin") || p.hasPermission("nextquarry.user.remove")) {
                        cs.sendMessage(ChatColor.GREEN + "You are allowed to break all quarries.");
                    } else {
                        cs.sendMessage(ChatColor.RED + "You are NOT allowed to break quarries.");
                    }
                    if (p.hasPermission("nextquarry.user.edit")) {
                            cs.sendMessage(ChatColor.GREEN + "You are allowed to edit all quarries.");
                    } else {
                        cs.sendMessage(ChatColor.RED + "You are NOT allowed to edit quarries.");
                    }
                }
            }
            return true;
        }
        return true;
    }
}
