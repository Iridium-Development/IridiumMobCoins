package com.iridium.iridiummobcoins.configs;

import com.iridium.iridiumcore.dependencies.fasterxml.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Messages {

    public String reloaded = "%prefix% &7Configuration has been reloaded.";
    public String noPermission = "%prefix% &7You don't have permission for that.";
    public String mustBeAPlayer = "%prefix% &7You must be a player to execute this command.";
    public String unknownPlayer = "%prefix% &7That player does not exist.";
    public String mustBeANumber = "%prefix% &7That is not a number.";
    public String unknownCommand = "%prefix% &7Unknown Command, Try /is help.";
    public String helpCommandHeader = "&8===== &6&lIridumMobCoins Help &r&8=====";
    public String helpCommandMessage = "<GRADIENT:FBD72B>/mc %command%</GRADIENT:F9484A>&r: &7%description%";
    public String helpCommandFooter = " &7Page %page% of %max_page% ";
    public String helpCommandPreviousPage = "&b<<";
    public String helpCommandNextPage = "&b>>";
    public String helpCommandNextPageHover = "&7Click to go to the next page.";
    public String helpCommandPreviousPageHover = "&7Click to go to the previous page.";
    public String mobcoinsBalance = "%prefix% &7You have %balance% MobCoins";
    public String gavePlayerMobCoins = "%prefix% &7You gave %player% %amount% MobCoins.";
    public String receivedMobCoins = "%prefix% &7You received %amount% MobCoins from %player%.";
    public String removePlayerMobCoins = "%prefix% &7You gave %player% %amount% MobCoins.";
    public String removedMobCoins = "%prefix% &7You received %amount% MobCoins from %player%.";
    public String setPlayerMobCoins = "%prefix% &7You set %player%' MobCoins to %amount%.";
    public String setMobCoins = "%prefix% &7You MobCoins has been set to %amount% by %player%.";
    public String receivedMobCoinFromKillingMob = "%prefix% &7You killed a %entity% and Gained %amount% MobCoin(s)";
}
