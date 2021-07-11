package com.iridium.iridiummobcoins;

import com.iridium.iridiumcore.Item;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class ShopItem {
    public int cost;
    public Item item;
    public List<String> commands;
}
