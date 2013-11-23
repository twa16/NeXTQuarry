package net.autumndusk.nextquarry.entities;

import java.util.ArrayList;
import java.util.HashMap;
import net.autumndusk.nextquarry.main.MainClass;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class CustomItems {

    public ArrayList<ItemStack> items = new ArrayList<>();
    public HashMap<ItemStack, ShapedRecipe> recipes = new HashMap<ItemStack, ShapedRecipe>();
    public ItemStack quarry_tier1;
    public ItemStack quarry_tier2;
    public ItemStack quarry_tier3;
    public ItemStack speed_upgrade;
    public ItemStack wrench_tool;
    public ItemStack fuel_tool;
    public ItemStack fuel_finder_upgrade;
    public ItemStack chest_miner;
    public ItemStack fuel_efficiency_upgrade;
    public ItemStack smelter_upgrade;
    public ItemStack liquid_miner;

    public CustomItems() {
        //Work Vars
        ItemStack is;
        ItemMeta meta;
        ArrayList<String> lorelist;

        //Fuel Efficiency Upgrade
        is = new ItemStack(MainClass.config.fuel_efficiency_upgrade, 1);
        meta = is.getItemMeta();
        meta.setDisplayName(ChatColor.RESET + "" + ChatColor.GREEN + MainClass.lang.fuel_efficiency_upgrade);
        lorelist = new ArrayList<String>();
        lorelist.add(ChatColor.RESET + "" + ChatColor.GOLD + MainClass.lang.fuel_efficiency_upgrade_desc);
        lorelist.add(ChatColor.RESET + "" + ChatColor.RED + MainClass.lang.fuel_efficiency_upgrade_limit);
        meta.setLore(lorelist);
        is.setItemMeta(meta);
        fuel_efficiency_upgrade = is;
        items.add(is);

        //Smelter Upgrade
        is = new ItemStack(MainClass.config.smelter_upgrade, 1);
        meta = is.getItemMeta();
        meta.setDisplayName(ChatColor.RESET + "" + ChatColor.GREEN + MainClass.lang.smelter_upgrade);
        lorelist = new ArrayList<String>();
        lorelist.add(ChatColor.RESET + "" + ChatColor.GOLD + MainClass.lang.smelter_upgrade_desc);
        lorelist.add(ChatColor.RESET + "" + ChatColor.RED + MainClass.lang.smelter_upgrade_limit);
        meta.setLore(lorelist);
        is.setItemMeta(meta);
        smelter_upgrade = is;
        items.add(is);

        //Liquid Miner
        is = new ItemStack(MainClass.config.liquid_miner, 1);
        meta = is.getItemMeta();
        meta.setDisplayName(ChatColor.RESET + "" + ChatColor.GREEN + MainClass.lang.liquid_miner);
        lorelist = new ArrayList<String>();
        lorelist.add(ChatColor.RESET + "" + ChatColor.GOLD + MainClass.lang.liquid_miner_desc);
        lorelist.add(ChatColor.RESET + "" + ChatColor.RED + MainClass.lang.liquid_miner_limit);
        meta.setLore(lorelist);
        is.setItemMeta(meta);
        liquid_miner = is;
        items.add(is);

        //Tier 1 Quarry
        is = new ItemStack(Material.IRON_BLOCK, 1);
        meta = is.getItemMeta();
        meta.setDisplayName(ChatColor.RESET + "" + ChatColor.GRAY + MainClass.lang.tier1_quarry);
        lorelist = new ArrayList<String>();
        lorelist.add(ChatColor.RESET + "" + ChatColor.GOLD + MainClass.lang.mines_a + " " + MainClass.config.tier_1_size + "x" + MainClass.config.tier_1_size + " " + MainClass.lang.area);
        meta.setLore(lorelist);
        is.setItemMeta(meta);
        quarry_tier1 = is;
        items.add(is);

        //Tier 2 Quarry
        is = new ItemStack(Material.GOLD_BLOCK, 1);
        meta = is.getItemMeta();
        meta.setDisplayName(ChatColor.RESET + "" + ChatColor.GOLD + MainClass.lang.tier2_quarry);
        lorelist = new ArrayList<String>();
        lorelist.add(ChatColor.RESET + "" + ChatColor.GOLD + MainClass.lang.mines_a + " " + MainClass.config.tier_2_size + "x" + MainClass.config.tier_2_size + " " + MainClass.lang.area);
        meta.setLore(lorelist);
        is.setItemMeta(meta);
        quarry_tier2 = is;
        items.add(is);

        //Tier 3 Quarry
        is = new ItemStack(Material.OBSIDIAN, 1);
        meta = is.getItemMeta();
        meta.setDisplayName(ChatColor.RESET + "" + ChatColor.AQUA + MainClass.lang.tier3_quarry);
        lorelist = new ArrayList<String>();
        lorelist.add(ChatColor.RESET + "" + ChatColor.GOLD + MainClass.lang.mines_a + " " + MainClass.config.tier_3_size + "x" + MainClass.config.tier_3_size + " " + MainClass.lang.area);
        meta.setLore(lorelist);
        is.setItemMeta(meta);
        quarry_tier3 = is;
        items.add(is);

        //Speed Upgrade
        is = new ItemStack(MainClass.config.speed_upgrade, 1);
        meta = is.getItemMeta();
        meta.setDisplayName(ChatColor.RESET + "" + ChatColor.GREEN + MainClass.lang.speed_upgrade);
        lorelist = new ArrayList<String>();
        lorelist.add(ChatColor.RESET + "" + ChatColor.GOLD + MainClass.lang.speed_upgrade_desc);
        lorelist.add(ChatColor.RESET + "" + ChatColor.RED + MainClass.lang.speed_upgrade_limit);
        meta.setLore(lorelist);
        is.setItemMeta(meta);
        speed_upgrade = is;
        items.add(is);

        //Fuel Finder Upgrade
        is = new ItemStack(MainClass.config.fuel_finder_upgrade, 1);
        meta = is.getItemMeta();
        meta.setDisplayName(ChatColor.RESET + "" + ChatColor.GREEN + MainClass.lang.fuel_finder);
        lorelist = new ArrayList<String>();
        lorelist.add(ChatColor.RESET + "" + ChatColor.GOLD + MainClass.lang.fuel_finder_desc);
        lorelist.add(ChatColor.RESET + "" + ChatColor.RED + MainClass.lang.fuel_finder_limit);
        meta.setLore(lorelist);
        is.setItemMeta(meta);
        fuel_finder_upgrade = is;
        items.add(is);

        //Wrench Tool
        is = new ItemStack(MainClass.config.wrench_tool, 1);
        meta = is.getItemMeta();
        meta.setDisplayName(ChatColor.RESET + "" + ChatColor.YELLOW + MainClass.lang.quarry_wrench);
        lorelist = new ArrayList<String>();
        lorelist.add(ChatColor.RESET + "" + ChatColor.GOLD + MainClass.lang.quarry_wrench_desc);
        meta.setLore(lorelist);
        is.setItemMeta(meta);
        wrench_tool = is;
        items.add(is);

        //Fuel Tool
        is = new ItemStack(MainClass.config.fuel_tool, 1);
        meta = is.getItemMeta();
        meta.setDisplayName(ChatColor.RESET + "" + ChatColor.YELLOW + MainClass.lang.fuel_injector);
        lorelist = new ArrayList<String>();
        lorelist.add(ChatColor.RESET + "" + ChatColor.GOLD + MainClass.lang.fuel_injector_desc);
        meta.setLore(lorelist);
        is.setItemMeta(meta);
        fuel_tool = is;
        items.add(is);

        //Chest Miner
        is = new ItemStack(MainClass.config.chest_miner, 1);
        meta = is.getItemMeta();
        meta.setDisplayName(ChatColor.RESET + "" + ChatColor.GREEN + MainClass.lang.chest_miner);
        lorelist = new ArrayList<String>();
        lorelist.add(ChatColor.RESET + "" + ChatColor.GOLD + MainClass.lang.chest_miner_desc);
        lorelist.add(ChatColor.RESET + "" + ChatColor.RED + MainClass.lang.chest_miner_limit);
        meta.setLore(lorelist);
        is.setItemMeta(meta);
        chest_miner = is;
        items.add(is);

    }

    public void addRecipes() {
        //Work Variable
        ShapedRecipe recipe;

        //Fuel Efficiency Upgrade
        recipe = new ShapedRecipe(fuel_efficiency_upgrade);
        recipe.shape("ABA", "BCB", "ABA");
        recipe.setIngredient('A', Material.IRON_INGOT);
        recipe.setIngredient('B', Material.REDSTONE);
        recipe.setIngredient('C', Material.DIAMOND);
        Bukkit.getServer().addRecipe(recipe);
        recipes.put(fuel_efficiency_upgrade, recipe);

        //Liquid Miner
        recipe = new ShapedRecipe(liquid_miner);
        recipe.shape("A A", "A A", " B ");
        recipe.setIngredient('A', Material.IRON_INGOT);
        recipe.setIngredient('B', Material.BUCKET);
        Bukkit.getServer().addRecipe(recipe);
        recipes.put(liquid_miner, recipe);

        //Tier 1 Quarry
        recipe = new ShapedRecipe(quarry_tier1);
        recipe.shape("ABA", "ACA", "ADA");
        recipe.setIngredient('A', Material.IRON_INGOT);
        recipe.setIngredient('B', Material.REDSTONE);
        recipe.setIngredient('C', Material.HOPPER);
        recipe.setIngredient('D', Material.IRON_PICKAXE);
        Bukkit.getServer().addRecipe(recipe);
        recipes.put(quarry_tier1, recipe);

        //Tier 2 Quarry
        recipe = new ShapedRecipe(quarry_tier2);
        recipe.shape("ABA", "ACA", "ADA");
        recipe.setIngredient('A', Material.GOLD_INGOT);
        recipe.setIngredient('B', Material.REDSTONE);
        recipe.setIngredient('C', Material.HOPPER);
        recipe.setIngredient('D', Material.GOLD_PICKAXE);
        Bukkit.getServer().addRecipe(recipe);
        recipes.put(quarry_tier2, recipe);

        //Tier 3 Quarry
        recipe = new ShapedRecipe(quarry_tier3);
        recipe.shape("ABA", "ACA", "ADA");
        recipe.setIngredient('A', Material.OBSIDIAN);
        recipe.setIngredient('B', Material.REDSTONE_BLOCK);
        recipe.setIngredient('C', Material.HOPPER);
        recipe.setIngredient('D', Material.DIAMOND_PICKAXE);
        Bukkit.getServer().addRecipe(recipe);
        recipes.put(quarry_tier3, recipe);

        //Speed Upgrade
        recipe = new ShapedRecipe(speed_upgrade);
        recipe.shape("ADA", "BCB", "ADA");
        recipe.setIngredient('A', Material.GOLD_INGOT);
        recipe.setIngredient('B', Material.GLASS);
        recipe.setIngredient('C', Material.REDSTONE);
        recipe.setIngredient('D', Material.STRING);
        Bukkit.getServer().addRecipe(recipe);
        recipes.put(speed_upgrade, recipe);

        //Fuel Finder Upgrade
        recipe = new ShapedRecipe(fuel_finder_upgrade);
        recipe.shape("ABA", "BCB", "ABA");
        recipe.setIngredient('A', Material.IRON_INGOT);
        recipe.setIngredient('B', Material.STICK);
        recipe.setIngredient('C', Material.COAL);
        Bukkit.getServer().addRecipe(recipe);
        recipes.put(fuel_finder_upgrade, recipe);

        //Wrench Tool
        recipe = new ShapedRecipe(wrench_tool);
        recipe.shape("B B", " A ", " A ");
        recipe.setIngredient('A', Material.GOLD_INGOT);
        recipe.setIngredient('B', Material.IRON_INGOT);
        Bukkit.getServer().addRecipe(recipe);
        recipes.put(wrench_tool, recipe);

        //Fuel Tool
        recipe = new ShapedRecipe(fuel_tool);
        recipe.shape("ABA", "A A", " C ");
        recipe.setIngredient('A', Material.IRON_INGOT);
        recipe.setIngredient('B', Material.BUCKET);
        recipe.setIngredient('C', Material.HOPPER);
        Bukkit.getServer().addRecipe(recipe);
        recipes.put(fuel_tool, recipe);

        //Chest Miner upgrade
        recipe = new ShapedRecipe(chest_miner);
        recipe.shape(" A ", " B ", " C ");
        recipe.setIngredient('A', Material.REDSTONE);
        recipe.setIngredient('B', Material.GOLD_HOE);
        recipe.setIngredient('C', Material.CHEST);
        Bukkit.getServer().addRecipe(recipe);
        recipes.put(chest_miner, recipe);

        //Smelter upgrade
        recipe = new ShapedRecipe(smelter_upgrade);
        recipe.shape("ABA", "CDA", "ABA");
        recipe.setIngredient('A', Material.IRON_INGOT);
        recipe.setIngredient('B', Material.HOPPER);
        recipe.setIngredient('C', Material.REDSTONE);
        recipe.setIngredient('D', Material.FURNACE);
        Bukkit.getServer().addRecipe(recipe);
        recipes.put(smelter_upgrade, recipe);

    }

    public static boolean customItemsMatch(ItemStack first, ItemStack second) {
        if (first.getItemMeta().equals(second.getItemMeta())) {
            return true;
        }
        return false;
    }
}
