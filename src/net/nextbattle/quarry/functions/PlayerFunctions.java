package net.nextbattle.quarry.functions;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PlayerFunctions {

    public static boolean addItems(Inventory inv, ItemStack is) {
        
        //Initialize queue
        int queue = is.getAmount();
        if (queue == 0) {
            return true;
        }
        
        //Add to other stacks
        int i = 0;             
        for (ItemStack invis : inv.getContents()) {
            if (invis != null) {
                if (invis.getType().equals(is.getType())) {
                    if (invis.getAmount() < inv.getMaxStackSize()) {
                        int spaceavailable = inv.getMaxStackSize() - invis.getAmount();
                        if (spaceavailable >= queue) {
                            queue = 0;
                            ItemStack new_invis = invis;
                            new_invis.setAmount(new_invis.getAmount() + queue);
                            inv.setItem(i, new_invis);
                        } else {
                            queue -= spaceavailable;
                            ItemStack new_invis = invis;
                            new_invis.setAmount(inv.getMaxStackSize());
                            inv.setItem(i, new_invis);
                        }
                    }
                }
            }
            i++;
        }
        
        //Add to empty spots if necessary:
        if (queue > 0) {

            if (inv.firstEmpty() != -1) {
                is.setAmount(queue);
                inv.setItem(inv.firstEmpty(), is);
                queue = 0;
            }
        }
        
        //Check if everything could place
        if (queue == 0) {
            return true;
        } else {
            return false;
        }

    }
}
