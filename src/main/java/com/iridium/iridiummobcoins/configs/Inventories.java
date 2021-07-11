package com.iridium.iridiummobcoins.configs;

import com.google.common.collect.ImmutableMap;
import com.iridium.iridiumcore.Background;
import com.iridium.iridiumcore.Item;
import com.iridium.iridiumcore.dependencies.xseries.XMaterial;
import com.iridium.iridiummobcoins.NoItemGUI;

import java.util.Arrays;
import java.util.Collections;

public class Inventories {
    public NoItemGUI mobCoinsGUI = new NoItemGUI(54, "&7MobCoins", new Background(ImmutableMap.<Integer, Item>builder()
            .put(0, new Item(XMaterial.BLACK_STAINED_GLASS_PANE, 1, " ", Collections.emptyList()))
            .put(1, new Item(XMaterial.BLACK_STAINED_GLASS_PANE, 1, " ", Collections.emptyList()))
            .put(2, new Item(XMaterial.BLACK_STAINED_GLASS_PANE, 1, " ", Collections.emptyList()))
            .put(3, new Item(XMaterial.BLACK_STAINED_GLASS_PANE, 1, " ", Collections.emptyList()))
            .put(4, new Item(XMaterial.SUNFLOWER, 1, "&7You have &6&l%mobcoins%&7 MobCoins", Collections.emptyList()))
            .put(5, new Item(XMaterial.BLACK_STAINED_GLASS_PANE, 1, " ", Collections.emptyList()))
            .put(6, new Item(XMaterial.BLACK_STAINED_GLASS_PANE, 1, " ", Collections.emptyList()))
            .put(7, new Item(XMaterial.BLACK_STAINED_GLASS_PANE, 1, " ", Collections.emptyList()))
            .put(8, new Item(XMaterial.BLACK_STAINED_GLASS_PANE, 1, " ", Collections.emptyList()))
            .put(9, new Item(XMaterial.BLACK_STAINED_GLASS_PANE, 1, " ", Collections.emptyList()))
            .put(17, new Item(XMaterial.BLACK_STAINED_GLASS_PANE, 1, " ", Collections.emptyList()))
            .put(18, new Item(XMaterial.BLACK_STAINED_GLASS_PANE, 1, " ", Collections.emptyList()))
            .put(26, new Item(XMaterial.BLACK_STAINED_GLASS_PANE, 1, " ", Collections.emptyList()))
            .put(27, new Item(XMaterial.BLACK_STAINED_GLASS_PANE, 1, " ", Collections.emptyList()))
            .put(35, new Item(XMaterial.BLACK_STAINED_GLASS_PANE, 1, " ", Collections.emptyList()))
            .put(36, new Item(XMaterial.BLACK_STAINED_GLASS_PANE, 1, " ", Collections.emptyList()))
            .put(44, new Item(XMaterial.BLACK_STAINED_GLASS_PANE, 1, " ", Collections.emptyList()))
            .put(45, new Item(XMaterial.BLACK_STAINED_GLASS_PANE, 1, " ", Collections.emptyList()))
            .put(46, new Item(XMaterial.BLACK_STAINED_GLASS_PANE, 1, " ", Collections.emptyList()))
            .put(47, new Item(XMaterial.BLACK_STAINED_GLASS_PANE, 1, " ", Collections.emptyList()))
            .put(48, new Item(XMaterial.BLACK_STAINED_GLASS_PANE, 1, " ", Collections.emptyList()))
            .put(49, new Item(XMaterial.BOOK, 1, "&6&lMobCoins Info", Arrays.asList(
                    "&7MobCoins can be earned by killing &c&lHOSTILE&7 mobs.",
                    "&7You can spend your mobcoins in this shop to buy cool items",
                    "",
                    "&6&lDrop Rates",
                    "&6&l * &6Zombie &71%",
                    "&6&l * &6Skeleton &71%",
                    "&6&l * &6Creeper &75%",
                    "&6&l * &6Enderman &75%"
            )))
            .put(50, new Item(XMaterial.BLACK_STAINED_GLASS_PANE, 1, " ", Collections.emptyList()))
            .put(51, new Item(XMaterial.BLACK_STAINED_GLASS_PANE, 1, " ", Collections.emptyList()))
            .put(52, new Item(XMaterial.BLACK_STAINED_GLASS_PANE, 1, " ", Collections.emptyList()))
            .put(53, new Item(XMaterial.BLACK_STAINED_GLASS_PANE, 1, " ", Collections.emptyList()))
            .put(54, new Item(XMaterial.BLACK_STAINED_GLASS_PANE, 1, " ", Collections.emptyList()))
            .build(), new Item(XMaterial.WHITE_STAINED_GLASS_PANE, 1, " ", Collections.emptyList())));

}
