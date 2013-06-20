/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.autumndusk.nextquarry.entities;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import net.autumndusk.nextquarry.main.MainClass;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

/**
 *
 * @author AutumnDusk
 */
public class Language {
    
    public String saving = "Saving quarries...";
    public String saved = "All quarries saved.";
    public String itemlist = "Items to choose from:";
    public String noconsole = "You can't execute this command from the console.";
    public String nogiveperm = "You are not allowed to execute this command with the give parameter!";
    public String itemnoexist = "This item does not exist!";
    public String plugininfo = "NeXTQuarry Plugin Info";
    public String codedby = "Coded by";
    public String website = "Website:";
    public String perms = "NeXTQuarry Permissions";
    public String tier1allow = "You are allowed to place tier 1 quarries.";
    public String tier1deny = "You are NOT allowed to place tier 1 quarries.";
    public String tier2allow = "You are allowed to place tier 2 quarries.";
    public String tier2deny = "You are NOT allowed to place tier 2 quarries.";
    public String tier3allow = "You are allowed to place tier 3 quarries.";
    public String tier3deny = "You are NOT allowed to place tier 3 quarries.";
    public String breakallquarries = "You are allowed to break all quarries.";
    public String editallquarries = "You are allowed to edit all quarries.";
    public String breakprivatequarries = "You are allowed to break YOUR quarries only."; 
    public String editprivatequarries = "You are allowed to edit YOUR quarries only.";
    public String noeditquarries = "You are NOT allowed to edit quarries.";
    public String nobreakquarries = "You are NOT allowed to break quarries.";
    public String fuel_efficiency_upgrade = "Fuel Efficiency Upgrade";
    public String fuel_efficiency_upgrade_desc = "Makes the quarry last longer per unit of fuel";
    public String fuel_efficiency_upgrade_limit = "Max 3 per quarry";
    public String smelter_upgrade = "Smelter Upgrade";
    public String smelter_upgrade_desc = "Gives the quarry the ability to smelt ores";
    public String smelter_upgrade_limit = "Max 1 per quarry";
    public String liquid_miner = "Liquid Miner";
    public String liquid_miner_desc = "Allows buckets to be filled with found liquids";
    public String liquid_miner_limit = "Max 1 per quarry";
    public String speed_upgrade = "Speed Upgrade";
    public String speed_upgrade_desc = "Makes the quarry a bit faster";
    public String speed_upgrade_limit = "Max 3 per quarry";
    public String fuel_finder = "Fuel Finder";
    public String fuel_finder_desc = "Automatically transfers coal found to the fuel bay";
    public String fuel_finder_limit = "Max 1 per quarry";
    public String quarry_wrench = "Quarry Wrench";
    public String quarry_wrench_desc = "Right click a quarry with this to apply upgrades!";
    public String fuel_injector = "Fuel Injector";
    public String fuel_injector_desc = "Right click a quarry with this to inject fuel!";
    public String chest_miner = "Chest Mining Upgrade";
    public String chest_miner_desc = "Allows you to mine the contents of chests.";
    public String chest_miner_limit = "Max 1 per quarry";
    public String tier1_quarry = "Quarry [Tier 1]";
    public String tier2_quarry = "Quarry [Tier 2]";
    public String tier3_quarry = "Quarry [Tier 3]";
    public String mines_a = "Mines a";
    public String area = "area";
    public String fuel_bay = "Quarry: Fuel Bay";
    public String upgr_bay = "Quarry: Upgrade Slots";
    public String noquarryworld = "You are not allowed to place quarries in this world!";
    public String nopermeditquarry = "You do not have the permission to edit this quarry!";
    public String notyourquarry = "You do not own this quarry!";
    public String nopermbreakquarry = "You do not have the permission to break this quarry!";
       
    public static void loadFile() {
        FileConfiguration fc = new YamlConfiguration().loadConfiguration(new File(MainClass.plugin.getDataFolder(), "lang.yml"));
        MainClass.lang = new Language();
        MainClass.lang.area = fc.getString("area");
        MainClass.lang.breakallquarries = fc.getString("breakallquarries");
        MainClass.lang.breakprivatequarries = fc.getString("breakprivatequarries");
        MainClass.lang.chest_miner = fc.getString("chest_miner");
        MainClass.lang.chest_miner_desc = fc.getString("chest_miner_desc");
        MainClass.lang.chest_miner_limit = fc.getString("chest_miner_limit");
        MainClass.lang.codedby = fc.getString("codedby");
        MainClass.lang.editallquarries = fc.getString("editallquarries");
        MainClass.lang.editprivatequarries = fc.getString("editprivatequarries");
        MainClass.lang.fuel_bay = fc.getString("fuel_bay");
        MainClass.lang.fuel_efficiency_upgrade = fc.getString("fuel_efficiency_upgrade");
        MainClass.lang.fuel_efficiency_upgrade_desc = fc.getString("fuel_efficiency_upgrade_desc");
        MainClass.lang.fuel_efficiency_upgrade_limit = fc.getString("fuel_efficiency_upgrade_limit");
        MainClass.lang.fuel_finder = fc.getString("fuel_finder");
        MainClass.lang.fuel_finder_desc = fc.getString("fuel_finder_desc");
        MainClass.lang.fuel_finder_limit = fc.getString("fuel_finder_limit");
        MainClass.lang.fuel_injector = fc.getString("fuel_injector");
        MainClass.lang.fuel_injector_desc = fc.getString("fuel_injector_desc");
        MainClass.lang.itemlist = fc.getString("itemlist");
        MainClass.lang.itemnoexist = fc.getString("itemnoexist");
        MainClass.lang.liquid_miner = fc.getString("liquid_miner");
        MainClass.lang.liquid_miner_desc = fc.getString("liquid_miner_desc");
        MainClass.lang.liquid_miner_limit = fc.getString("liquid_miner_limit");
        MainClass.lang.mines_a = fc.getString("mines_a");
        MainClass.lang.nobreakquarries = fc.getString("nobreakquarries");
        MainClass.lang.noconsole = fc.getString("noconsole");
        MainClass.lang.noeditquarries = fc.getString("noeditquarries");
        MainClass.lang.nogiveperm = fc.getString("nogiveperm");
        MainClass.lang.nopermbreakquarry = fc.getString("nopermbreakquarry");
        MainClass.lang.nopermeditquarry = fc.getString("nopermeditquarry");
        MainClass.lang.noquarryworld = fc.getString("noquarryworld");
        MainClass.lang.notyourquarry = fc.getString("notyourquarry");
        MainClass.lang.perms = fc.getString("perms");
        MainClass.lang.plugininfo = fc.getString("plugininfo");
        MainClass.lang.quarry_wrench = fc.getString("quarry_wrench");
        MainClass.lang.quarry_wrench_desc = fc.getString("quarry_wrench_desc");
        MainClass.lang.saved = fc.getString("saved");
        MainClass.lang.saving = fc.getString("saving");
        MainClass.lang.smelter_upgrade = fc.getString("smelter_upgrade");
        MainClass.lang.smelter_upgrade_desc = fc.getString("smelter_upgrade_desc");
        MainClass.lang.smelter_upgrade_limit = fc.getString("smelter_upgrade_limit");
        MainClass.lang.speed_upgrade = fc.getString("speed_upgrade");
        MainClass.lang.speed_upgrade_desc = fc.getString("speed_upgrade_desc");
        MainClass.lang.speed_upgrade_limit = fc.getString("speed_upgrade_limit");
        MainClass.lang.tier1_quarry = fc.getString("tier1_quarry");
        MainClass.lang.tier1allow = fc.getString("tier1allow");
        MainClass.lang.tier1deny = fc.getString("tier1deny");
        MainClass.lang.tier2_quarry = fc.getString("tier2_quarry");
        MainClass.lang.tier2allow = fc.getString("tier2allow");
        MainClass.lang.tier2deny = fc.getString("tier2deny");
        MainClass.lang.tier3_quarry = fc.getString("tier3_quarry");
        MainClass.lang.tier3allow = fc.getString("tier3allow");
        MainClass.lang.tier3deny = fc.getString("tier3deny");
        MainClass.lang.upgr_bay = fc.getString("upgr_bay");
        MainClass.lang.website = fc.getString("website");
    }
}
