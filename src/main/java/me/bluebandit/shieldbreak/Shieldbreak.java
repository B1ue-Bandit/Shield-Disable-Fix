package me.bluebandit.shieldbreak;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Shieldbreak extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        System.out.println("Bandit's ShielDisable fix has been enabled!");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onEntityDamageByEntity(final EntityDamageByEntityEvent event) {
        if (!(event.getEntity() instanceof Player player) || !(event.getDamager() instanceof Player damager))
            return;
        if (damager.getEquipment().getItemInMainHand().getType().toString().toLowerCase().contains("axe") && player.isBlocking()) {
            for (Player online : getServer().getOnlinePlayers()) {
                online.playSound(player.getLocation(), Sound.ITEM_SHIELD_BREAK, 1, 1);
            }
        }
    }
}
