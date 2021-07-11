package com.iridium.iridiummobcoins.configs;

import com.google.common.collect.ImmutableMap;
import com.iridium.iridiumcore.dependencies.fasterxml.annotation.JsonIgnoreProperties;
import com.iridium.iridiumcore.dependencies.xseries.XSound;
import com.iridium.iridiumcore.utils.NumberFormatter;
import org.bukkit.entity.EntityType;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Configuration {
    public String prefix = "<GRADIENT:FBD72B>&lIridiumMobCoins</GRADIENT:F9484A> &8»";
    public String placeholderDefaultValue = "N/A";
    public XSound inventoryOpenSound = XSound.BLOCK_NOTE_BLOCK_PLING;
    public Map<EntityType, Double> mobCoinDropChances = ImmutableMap.<EntityType, Double>builder()
            .put(EntityType.ZOMBIE, 1.00)
            .put(EntityType.SKELETON, 1.00)
            .put(EntityType.CREEPER, 5.00)
            .put(EntityType.ENDERMAN, 5.00)
            .build();
    public NumberFormatter numberFormatter = new NumberFormatter();
}
