package com.iridium.iridiummobcoins.listeners;

import com.iridium.iridiummobcoins.IridiumMobCoins;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.Map;

public class EntityDeathListener implements Listener {

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        Player killer = event.getEntity().getKiller();
        Map<EntityType, Double> mobCoinDropChances = IridiumMobCoins.getInstance().getConfiguration().mobCoinDropChances;
        if (killer != null && mobCoinDropChances.containsKey(event.getEntityType())) {
            double random = Math.random() * 100;
            if (random <= mobCoinDropChances.get(event.getEntityType())) {
                IridiumMobCoins.getInstance().getDatabaseManager().getUser(killer.getUniqueId()).thenAccept(user ->
                        user.setMobcoins(user.getMobcoins() + 1)
                );
            }
        }
    }

}
