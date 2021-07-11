package com.iridium.iridiummobcoins.database;

import com.iridium.iridiummobcoins.IridiumMobCoins;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

@Getter
@NoArgsConstructor
@DatabaseTable(tableName = "users")
public final class User {

    @DatabaseField(columnName = "uuid", canBeNull = false, id = true)
    private @NotNull UUID uuid;

    @DatabaseField(columnName = "name", canBeNull = false)
    private @NotNull String name;

    @DatabaseField(columnName = "mobcoins", canBeNull = false)
    private int mobcoins;

    /**
     * The default constructor.
     *
     * @param uuid The UUID of the {@link org.bukkit.entity.Player}
     * @param name The name of the Player
     */
    public User(final @NotNull UUID uuid, final @NotNull String name) {
        this.uuid = uuid;
        this.name = name;
        this.mobcoins = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMobcoins(int mobcoins) {
        this.mobcoins = mobcoins;
    }
}