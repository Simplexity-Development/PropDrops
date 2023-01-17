package adhdmc.propdrops;

import org.bukkit.plugin.java.JavaPlugin;

public final class PropDrops extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
    }
}
