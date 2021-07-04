package com.iridium.iridiummobcoins.managers;

import com.iridium.iridiummobcoins.IridiumMobCoins;
import com.iridium.iridiummobcoins.configs.SQL;
import com.iridium.iridiummobcoins.database.User;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.jdbc.db.DatabaseTypeUtils;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.logger.NullLogBackend;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.sql.SQLException;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class DatabaseManager {

    private static final SQL SQL_CONFIG = IridiumMobCoins.getInstance().getSql();

    private final Dao<User, UUID> userDao;

    public DatabaseManager() throws SQLException {
        LoggerFactory.setLogBackendFactory(new NullLogBackend.NullLogBackendFactory());
        String databaseURL = getDatabaseURL();

        ConnectionSource connectionSource = new JdbcConnectionSource(
                databaseURL,
                SQL_CONFIG.username,
                SQL_CONFIG.password,
                DatabaseTypeUtils.createDatabaseType(databaseURL)
        );

        TableUtils.createTableIfNotExists(connectionSource, User.class);

        this.userDao = DaoManager.createDao(connectionSource, User.class);

    }

    private @NotNull String getDatabaseURL() {
        switch (SQL_CONFIG.driver) {
            case MYSQL:
            case MARIADB:
            case POSTGRESQL:
                return "jdbc:" + SQL_CONFIG.driver + "://" + SQL_CONFIG.host + ":" + SQL_CONFIG.port + "/" + SQL_CONFIG.database;
            case SQLSERVER:
                return "jdbc:sqlserver://" + SQL_CONFIG.host + ":" + SQL_CONFIG.port + ";databaseName=" + SQL_CONFIG.database;
            case H2:
                return "jdbc:h2:file:" + SQL_CONFIG.database;
            case SQLITE:
                return "jdbc:sqlite:" + new File(IridiumMobCoins.getInstance().getDataFolder(), SQL_CONFIG.database + ".db");
        }

        throw new RuntimeException("How did we get here?");
    }

    public CompletableFuture<User> getUser(UUID uuid) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                User user = userDao.queryBuilder().where().eq("uuid", uuid).queryForFirst();
                if (user != null) return user;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            User user = new User(uuid, "");
            saveUser(user);
            return user;
        });
    }

    public void saveUser(@NotNull User user) {
        Bukkit.getScheduler().runTaskAsynchronously(IridiumMobCoins.getInstance(), () -> {
            try {
                userDao.createOrUpdate(user);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }

}