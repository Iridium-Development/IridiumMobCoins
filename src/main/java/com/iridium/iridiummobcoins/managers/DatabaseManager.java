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
import java.util.HashMap;
import java.util.UUID;

public class DatabaseManager {

    private static final SQL SQL_CONFIG = IridiumMobCoins.getInstance().getSql();

    private final Dao<User, UUID> userDao;

    private final HashMap<UUID, User> users = new HashMap<>();

    private final ConnectionSource connectionSource;

    public DatabaseManager() throws SQLException {
        LoggerFactory.setLogBackendFactory(new NullLogBackend.NullLogBackendFactory());
        String databaseURL = getDatabaseURL();

        connectionSource = new JdbcConnectionSource(
                databaseURL,
                SQL_CONFIG.username,
                SQL_CONFIG.password,
                DatabaseTypeUtils.createDatabaseType(databaseURL)
        );

        TableUtils.createTableIfNotExists(connectionSource, User.class);

        this.userDao = DaoManager.createDao(connectionSource, User.class);

        userDao.setAutoCommit(connectionSource.getReadWriteConnection(null), false);

        try {
            userDao.queryForAll().forEach(user -> {
                users.put(user.getUuid(), user);
            });
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
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

    public User getUser(UUID uuid) {
        if (!users.containsKey(uuid)) {
            users.put(uuid, new User(uuid, ""));
        }
        return users.get(uuid);
    }

    public void saveUsers() {
        for (User user : users.values()) {
            try {
                userDao.createOrUpdate(user);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        try {
            userDao.commit(connectionSource.getReadWriteConnection(null));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}