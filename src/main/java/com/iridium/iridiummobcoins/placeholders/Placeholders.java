package com.iridium.iridiummobcoins.placeholders;

import com.google.common.collect.ImmutableMap;
import com.iridium.iridiummobcoins.IridiumMobCoins;
import com.iridium.iridiummobcoins.database.User;
import org.bukkit.entity.Player;

import java.util.Map;

public class Placeholders {

    public static Map<String, Placeholder> placeholders = ImmutableMap.<String, Placeholder>builder()
            .put("player_mobcoins", player -> {
                User user = IridiumMobCoins.getInstance().getDatabaseManager().getUser(player.getUniqueId());
                return String.valueOf(user.getMobcoins());
            })
            .put("player_mobcoins_formatted", player -> {
                User user = IridiumMobCoins.getInstance().getDatabaseManager().getUser(player.getUniqueId());
                return IridiumMobCoins.getInstance().getNumberFormatter().format(user.getMobcoins());
            })
            .build();

    public interface Placeholder {

        String placeholderProcess(Player player);

    }

}
