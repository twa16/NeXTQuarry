package net.autumndusk.nextquarry.support;

import de.diddiz.LogBlock.Consumer;
import de.diddiz.LogBlock.LogBlock;
import org.bukkit.Bukkit;
import org.bukkit.Location;

public class PS_LogBlock {
    private Consumer lbconsumer;
    
    public PS_LogBlock() {
        lbconsumer = ((LogBlock)Bukkit.getServer().getPluginManager().getPlugin("LogBlock")).getConsumer();
    }
    
    public void logRemoval(String username, Location loc, int type, byte data) {
        lbconsumer.queueBlockBreak(username, loc, type, data);
    }
    
    public void logPlacement(String username, Location loc, int type, byte data) {
        lbconsumer.queueBlockPlace(username, loc, type, data);
    }
    
}
