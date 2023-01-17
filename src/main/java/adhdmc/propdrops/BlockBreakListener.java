package adhdmc.propdrops;

import com.destroystokyo.paper.event.block.BlockDestroyEvent;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.data.type.MangrovePropagule;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class BlockBreakListener implements Listener {
    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void onPropPlayerBreak(BlockBreakEvent breakEvent){
        if (!(breakEvent.getBlock().getBlockData() instanceof MangrovePropagule propagule)) return;
        if (breakEvent.getPlayer().getGameMode().equals(GameMode.CREATIVE)) return;
        if (propagule.getAge() == propagule.getMaximumAge()) return;
        ItemStack propToDrop = new ItemStack(Material.MANGROVE_PROPAGULE, 1);
        Location blockLocation = breakEvent.getBlock().getLocation();
        blockLocation.getWorld().dropItem(blockLocation, propToDrop);
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void onPropBreakNoPlayer(BlockDestroyEvent destroyEvent) {
        if (!(destroyEvent.getBlock().getBlockData() instanceof MangrovePropagule propagule)) return;
        if (propagule.getAge() == propagule.getMaximumAge()) return;
        ItemStack propToDrop = new ItemStack(Material.MANGROVE_PROPAGULE, 1);
        Location blockLocation = destroyEvent.getBlock().getLocation();
        blockLocation.getWorld().dropItem(blockLocation, propToDrop);
    }
}
