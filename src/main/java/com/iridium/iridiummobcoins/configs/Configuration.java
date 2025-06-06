package com.iridium.iridiummobcoins.configs;

import com.cryptomorin.xseries.XSound;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.collect.ImmutableMap;
import com.iridium.iridiumcore.utils.NumberFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.bukkit.entity.EntityType;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Configuration {
    public String prefix = "<GRADIENT:FFDD00>&lIridiumMobCoins</GRADIENT:FBB034> &8»";
    public String placeholderDefaultValue = "N/A";
    public XSound inventoryOpenSound = XSound.BLOCK_NOTE_BLOCK_PLING;
    public List<String> disabledWorlds = Collections.singletonList("Disabled_World");
    public Map<EntityType, Double> mobCoinDropChances = ImmutableMap.<EntityType, Double>builder()
            .put(EntityType.ZOMBIE, 1.00)
            .put(EntityType.SKELETON, 1.00)
            .put(EntityType.CREEPER, 5.00)
            .put(EntityType.ENDERMAN, 5.00)
            .build();
    public Map<EntityType, Integer> mobCoinDropAmounts = ImmutableMap.<EntityType, Integer>builder()
            .put(EntityType.CREEPER, 3)
            .put(EntityType.ENDERMAN, 5)
            .build();
    public NumberFormatter numberFormatter = new NumberFormatter();
}
