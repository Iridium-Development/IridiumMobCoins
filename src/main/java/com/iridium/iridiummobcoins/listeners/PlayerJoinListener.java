package com.iridium.iridiummobcoins.listeners;

import com.iridium.iridiummobcoins.IridiumMobCoins;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        IridiumMobCoins.getInstance().getDatabaseManager().getUser(event.getPlayer().getUniqueId()).thenAccept(user ->
                user.setName(event.getPlayer().getName())
        );
    }

}
