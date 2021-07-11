package com.iridium.iridiummobcoins.gui;

import com.iridium.iridiumcore.GUI;
import com.iridium.iridiumcore.utils.InventoryUtils;
import com.iridium.iridiumcore.utils.Placeholder;
import com.iridium.iridiumcore.utils.StringUtils;
import com.iridium.iridiummobcoins.IridiumMobCoins;
import com.iridium.iridiummobcoins.NoItemGUI;
import com.iridium.iridiummobcoins.database.User;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.UUID;

public class MobCoinsGUI implements GUI {
    private final UUID playerUUID;

    public MobCoinsGUI(Player player) {
        this.playerUUID = player.getUniqueId();
    }

    @NotNull
    @Override
    public Inventory getInventory() {
        NoItemGUI noItemGUI = IridiumMobCoins.getInstance().getInventories().mobCoinsGUI;
        Inventory inventory = Bukkit.createInventory(this, noItemGUI.size, StringUtils.color(noItemGUI.title));

        addContent(inventory);

        return inventory;
    }

    @Override
    public void addContent(Inventory inventory) {
        User user = IridiumMobCoins.getInstance().getDatabaseManager().getUser(playerUUID);
        NoItemGUI noItemGUI = IridiumMobCoins.getInstance().getInventories().mobCoinsGUI;
        InventoryUtils.fillInventory(inventory, noItemGUI.background, Arrays.asList(
                new Placeholder("mobcoins", String.valueOf(user.getMobcoins())),
                new Placeholder("mobcoins_formatted", IridiumMobCoins.getInstance().getNumberFormatter().format(user.getMobcoins())))
        );
    }

    @Override
    public void onInventoryClick(InventoryClickEvent inventoryClickEvent) {

    }
}
