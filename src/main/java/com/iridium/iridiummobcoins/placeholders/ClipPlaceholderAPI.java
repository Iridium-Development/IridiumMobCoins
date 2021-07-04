package com.iridium.iridiummobcoins.placeholders;

import com.iridium.iridiummobcoins.IridiumMobCoins;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;

public class ClipPlaceholderAPI extends PlaceholderExpansion {

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public String getIdentifier() {
        return "iridiummobcoins";
    }

    @Override
    public String getAuthor() {
        return "Peaches_MLG";
    }

    @Override
    public String getVersion() {
        return IridiumMobCoins.getInstance().getDescription().getVersion();
    }

    @Override
    public String onPlaceholderRequest(Player player, String placeholder) {
        if (player == null) {
            return IridiumMobCoins.getInstance().getConfiguration().placeholderDefaultValue;
        }
        if (Placeholders.placeholders.containsKey(placeholder)) {
            return Placeholders.placeholders.get(placeholder).placeholderProcess(player);
        }
        return null;
    }
}
