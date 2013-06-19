package net.nextbattle.quarry.entities;

import net.nextbattle.quarry.main.MainClass;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHandler implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender cs, Command cmnd, String string, String[] args) {
        if (cmnd.getName().equalsIgnoreCase("nextquarry")) {
            if (args.length == 1 && args[0].equals("give")) {
                cs.sendMessage(ChatColor.GOLD + MainClass.lang.itemlist + " tier1, tier2, tier3, wrench, speedupgrade, fuelinjector, fuelfinder, fuelupgrade, smelter, liquidminer & chestminer.");
                return true;
            }
            if (args.length == 2 && args[0].equals("give")) {
                if (!(cs instanceof Player)) {
                    cs.sendMessage(ChatColor.GOLD + MainClass.lang.noconsole);
                    return false;
                }
                
                Player p = (Player) cs;

                if (!p.hasPermission("nextquarry.admin")) {
                    cs.sendMessage(ChatColor.GOLD + MainClass.lang.nogiveperm);
                    return true;
                }
                if (args[1].equals("tier1")) {
                    p.getInventory().addItem(MainClass.citems.quarry_tier1);
                } else if (args[1].equals("tier2")) {
                    p.getInventory().addItem(MainClass.citems.quarry_tier2);
                } else if (args[1].equals("tier3")) {
                    p.getInventory().addItem(MainClass.citems.quarry_tier3);
                } else if (args[1].equals("wrench")) {
                    p.getInventory().addItem(MainClass.citems.wrench_tool);
                } else if (args[1].equals("speedupgrade")) {
                    p.getInventory().addItem(MainClass.citems.speed_upgrade);
                } else if (args[1].equals("fuelinjector")) {
                    p.getInventory().addItem(MainClass.citems.fuel_tool);
                } else if (args[1].equals("fuelfinder")) {
                    p.getInventory().addItem(MainClass.citems.fuel_finder_upgrade);
                } else if (args[1].equals("chestminer")) {
                    p.getInventory().addItem(MainClass.citems.chest_miner);
                }else if (args[1].equals("smelter")) {
                    p.getInventory().addItem(MainClass.citems.smelter_upgrade);
                } else if (args[1].equals("fuelupgrade")) {
                    p.getInventory().addItem(MainClass.citems.fuel_efficiency_upgrade);
                }  else if (args[1].equals("liquidminer")) {
                    p.getInventory().addItem(MainClass.citems.liquid_miner);
                } else {
                    p.sendMessage(ChatColor.GOLD + MainClass.lang.itemnoexist);
                    p.sendMessage(ChatColor.GOLD + MainClass.lang.itemlist+ " tier1, tier2, tier3, wrench, speedupgrade, fuelinjector, fuelfinder, fuelupgrade, smelter, liquidminer & chestminer.");
                }
                return true;
            }

            cs.sendMessage(ChatColor.GOLD + "----["+MainClass.lang.plugininfo+"]----");
            cs.sendMessage(ChatColor.GOLD + "NeXTQuarry v1.6.0 - "+MainClass.lang.codedby+" AutumnDusk");
            cs.sendMessage(ChatColor.GOLD + MainClass.lang.website + " http://www.autumndusk.net/");
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
