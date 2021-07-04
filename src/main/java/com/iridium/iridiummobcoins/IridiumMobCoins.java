package com.iridium.iridiummobcoins;

import com.iridium.iridiumcore.IridiumCore;
import com.iridium.iridiummobcoins.commands.CommandManager;
import com.iridium.iridiummobcoins.configs.Configuration;
import com.iridium.iridiummobcoins.configs.Messages;
import com.iridium.iridiummobcoins.configs.SQL;
import com.iridium.iridiummobcoins.listeners.EntityDeathListener;
import com.iridium.iridiummobcoins.listeners.PlayerJoinListener;
import com.iridium.iridiummobcoins.managers.DatabaseManager;
import com.iridium.iridiummobcoins.placeholders.ClipPlaceholderAPI;
import com.iridium.iridiummobcoins.placeholders.MVDWPlaceholderAPI;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import java.sql.SQLException;

@Getter
public class IridiumMobCoins extends IridiumCore {

    private static IridiumMobCoins instance;

    private DatabaseManager databaseManager;
    private CommandManager commandManager;

    private Configuration configuration;
    private Messages messages;
    private SQL sql;

    @Override
    public void onEnable() {
        super.onEnable();
        instance = this;

        try {
            this.databaseManager = new DatabaseManager();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        this.commandManager = new CommandManager("IridiumMobCoins");

        // Register Placeholders Support
        Plugin MVDWPlaceholderAPI = getServer().getPluginManager().getPlugin("MVdWPlaceholderAPI");
        if (MVDWPlaceholderAPI != null && MVDWPlaceholderAPI.isEnabled()) {
            new MVDWPlaceholderAPI();
            getLogger().info("Successfully registered placeholders with MVDWPlaceholderAPI.");
        }

        Plugin PlaceholderAPI = getServer().getPluginManager().getPlugin("PlaceholderAPI");
        if (PlaceholderAPI != null && PlaceholderAPI.isEnabled()) {
            if (new ClipPlaceholderAPI().register()) {
                getLogger().info("Successfully registered placeholders with PlaceholderAPI.");
            }
        }

        this.getLogger().info("-------------------------------");
        this.getLogger().info("");
        this.getLogger().info(this.getDescription().getName() + " Enabled!");
        this.getLogger().info("");
        this.getLogger().info("-------------------------------");
    }

    @Override
    public void loadConfigs() {
        this.configuration = getPersist().load(Configuration.class);
        this.messages = getPersist().load(Messages.class);
        this.sql = getPersist().load(SQL.class);
    }

    @Override
    public void saveConfigs() {
        getPersist().save(configuration);
        getPersist().save(messages);
        getPersist().save(sql);
    }

    @Override
    public void registerListeners() {
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new EntityDeathListener(), this);
    }

    public static IridiumMobCoins getInstance() {
        return instance;
    }
}
