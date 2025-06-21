package com.iridium.iridiummobcoins.listeners;

import com.iridium.iridiumcore.utils.StringUtils;
import com.iridium.iridiummobcoins.IridiumMobCoins;
import com.iridium.iridiummobcoins.database.User;
import org.apache.commons.lang.WordUtils;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.Map;

public class EntityDeathListener implements Listener {

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        if (IridiumMobCoins.getInstance().getConfiguration().disabledWorlds.contains(event.getEntity().getWorld().getName())) return;
        Player killer = event.getEntity().getKiller();
        Map<EntityType, Double> mobCoinDropChances = IridiumMobCoins.getInstance().getConfiguration().mobCoinDropChances;
        if (killer != null && mobCoinDropChances.containsKey(event.getEntityType())) {
            double random = Math.floor(Math.random() * 100) + 1;
            if (random <= mobCoinDropChances.get(event.getEntityType())) {
                int amount = IridiumMobCoins.getInstance().getConfiguration().mobCoinDropAmounts.getOrDefault(event.getEntityType(), 1);
                User user = IridiumMobCoins.getInstance().getDatabaseManager().getUser(killer.getUniqueId());
                user.setMobcoins(user.getMobcoins() + amount);

                String message = StringUtils.color(IridiumMobCoins.getInstance().getMessages().receivedMobCoinFromKillingMob
                        .replace("%prefix%", IridiumMobCoins.getInstance().getConfiguration().prefix)
                        .replace("%entity%", WordUtils.capitalizeFully(event.getEntityType().name().toLowerCase().replace("_", " ")))
                        .replace("%amount%", String.valueOf(amount))
                );
                if (!message.isEmpty()) {
                    killer.sendMessage(message);
                }
            }
        }
    }

}
