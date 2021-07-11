package com.iridium.iridiummobcoins.configs;

import com.iridium.iridiumcore.dependencies.fasterxml.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SQL {

    public Driver driver = Driver.SQLITE;
    public String host = "localhost";
    public String database = "IridiumMobCoins";
    public String username = "";
    public String password = "";
    public int port = 3306;

    public enum Driver {

        MYSQL,
        MARIADB,
        SQLSERVER,
        POSTGRESQL,
        H2,
        SQLITE
    }
}