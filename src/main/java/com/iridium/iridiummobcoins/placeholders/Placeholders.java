package com.iridium.iridiummobcoins.placeholders;

import com.google.common.collect.ImmutableMap;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.Optional;

public class Placeholders {

    public static Map<String, Placeholder> placeholders = ImmutableMap.<String, Placeholder>builder()
            .build();
    
    public interface Placeholder {

        String placeholderProcess(Player player);

    }

}
