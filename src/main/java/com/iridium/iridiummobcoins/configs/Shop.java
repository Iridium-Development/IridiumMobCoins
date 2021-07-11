package com.iridium.iridiummobcoins.configs;

import com.google.common.collect.ImmutableMap;
import com.iridium.iridiumcore.Item;
import com.iridium.iridiumcore.dependencies.fasterxml.annotation.JsonIgnoreProperties;
import com.iridium.iridiumcore.dependencies.xseries.XMaterial;
import com.iridium.iridiummobcoins.ShopItem;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Shop {
    public Map<String, ShopItem> shopItems = ImmutableMap.<String, ShopItem>builder()
            .put("1", new ShopItem(50, new Item(XMaterial.GOLD_INGOT, 30, 1, "&6&l$10,000", Arrays.asList("&7$10,000", "&7Cost: &650 MobCoins", "", "&6&l[!] &6Left click to Purchase")), Collections.singletonList("eco give %player% 10000")))
            .put("2", new ShopItem(100, new Item(XMaterial.GOLD_INGOT, 31, 1, "&6&l$50,000", Arrays.asList("&7$50,000", "&7Cost: &6100 MobCoins", "", "&6&l[!] &6Left click to Purchase")), Collections.singletonList("eco give %player% 50000")))
            .put("3", new ShopItem(150, new Item(XMaterial.GOLD_INGOT, 32, 1, "&6&l$100,000", Arrays.asList("&7$100,000", "&7Cost: &6150 MobCoins", "", "&6&l[!] &6Left click to Purchase")), Collections.singletonList("eco give %player% 150000")))
            .put("4", new ShopItem(100, new Item(XMaterial.NETHER_STAR, 29, 1, "&9&lVote Crate Key", Arrays.asList("", "&7Cost: &6100 MobCoins", "", "&6&l[!] &6Left click to Purchase")), Collections.singletonList("crate give %player% vote 1")))
            .put("5", new ShopItem(250, new Item(XMaterial.NETHER_STAR, 33, 1, "&5&lMythical Crate Key", Arrays.asList("", "&7Cost: &6250 MobCoins", "", "&6&l[!] &6Left click to Purchase")), Collections.singletonList("crate give %player% mythical 1")))
            .put("6", new ShopItem(1000, new Item(XMaterial.PAPER, 22, 1, "&6&lMobCoins Rank", Arrays.asList("", "&7Cost: &61000 MobCoins", "", "&6&l[!] &6Left click to Purchase")), Collections.singletonList("lp user %player% group add mobcoins")))
            .put("7", new ShopItem(250, new Item(XMaterial.NAME_TAG, 21, 1, "&6&lMobCoins Prefix", Arrays.asList("", "&7Cost: &7250 MobCoins", "", "&6&l[!] &6Left click to Purchase")), Collections.singletonList("tags give %player% mobcoins")))
            .put("8", new ShopItem(250, new Item(XMaterial.NAME_TAG, 23, 1, "&6&lMVP Prefix", Arrays.asList("", "&7Cost: &6250 MobCoins", "", "&6&l[!] &6Left click to Purchase")), Collections.singletonList("tags give %player% mvp")))
            .build();
}
