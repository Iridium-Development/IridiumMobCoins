package com.iridium.iridiummobcoins.placeholders;

import be.maximvdw.placeholderapi.PlaceholderAPI;
import com.iridium.iridiummobcoins.IridiumMobCoins;

import java.util.Map;

public class MVDWPlaceholderAPI {

    public MVDWPlaceholderAPI() {
        for (Map.Entry<String, Placeholders.Placeholder> placeholder : Placeholders.placeholders.entrySet()) {
            PlaceholderAPI.registerPlaceholder(IridiumMobCoins.getInstance(), "iridiummobcoins_" + placeholder.getKey(), event -> {
                if (event.getPlayer() == null) {
                    return IridiumMobCoins.getInstance().getConfiguration().placeholderDefaultValue;
                }
                return placeholder.getValue().placeholderProcess(event.getPlayer());
            });
        }
    }

}
