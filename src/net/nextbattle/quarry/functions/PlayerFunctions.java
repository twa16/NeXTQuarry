package net.nextbattle.quarry.functions;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PlayerFunctions {

    public static boolean addItems(Inventory inv, ItemStack is) {
        ItemStack itemToAdd = is;
        int freeSpace = 0;
        for (ItemStack i : inv) {
            if (i == null) {
                freeSpace += itemToAdd.getType().getMaxStackSize();
            } else if (i.getType() == itemToAdd.getType()) {
                freeSpace += i.getType().getMaxStackSize() - i.getAmount();
            }
        }
        if (itemToAdd.getAmount() >= freeSpace) {
            inv.addItem(is);
            return true;
        } else {
            return false;
        }

    }
}
