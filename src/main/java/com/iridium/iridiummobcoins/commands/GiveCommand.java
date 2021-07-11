package com.iridium.iridiummobcoins.commands;

import com.iridium.iridiumcore.utils.StringUtils;
import com.iridium.iridiummobcoins.IridiumMobCoins;
import com.iridium.iridiummobcoins.database.User;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;

public class GiveCommand extends Command {

    /**
     * The default constructor.
     */
    public GiveCommand() {
        super(Collections.singletonList("give"), "Give a player MobCoins", "iridiummobcoins.give", false);
    }

    /**
     * Executes the command for the specified {@link CommandSender} with the provided arguments.
     * Not called when the command execution was invalid (no permission, no player or command disabled).
     * Reloads all configuration files.
     *
     * @param sender The CommandSender which executes this command
     * @param args   The arguments used with this command. They contain the sub-command
     */
    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length != 3) {
            sender.sendMessage(StringUtils.color(IridiumMobCoins.getInstance().getConfiguration().prefix + " &7/mc give <player> <amount>"));
            return;
        }
        int amount;
        try {
            amount = Integer.parseInt(args[2]);
        } catch (NumberFormatException exception) {
            sender.sendMessage(StringUtils.color(IridiumMobCoins.getInstance().getMessages().mustBeANumber
                    .replace("%prefix%", IridiumMobCoins.getInstance().getConfiguration().prefix)
            ));
            return;
        }
        OfflinePlayer offlinePlayer = Bukkit.getServer().getOfflinePlayer(args[1]);
        if (offlinePlayer.hasPlayedBefore()) {
            User user = IridiumMobCoins.getInstance().getDatabaseManager().getUser(offlinePlayer.getUniqueId());
            user.setMobcoins(Math.max(user.getMobcoins() + amount, 0));
            sender.sendMessage(StringUtils.color(IridiumMobCoins.getInstance().getMessages().gavePlayerMobCoins
                    .replace("%prefix%", IridiumMobCoins.getInstance().getConfiguration().prefix)
                    .replace("%player%", user.getName())
                    .replace("%amount%", String.valueOf(amount))
            ));
            Player player = Bukkit.getPlayer(user.getUuid());
            if (player != null) {
                player.sendMessage(StringUtils.color(IridiumMobCoins.getInstance().getMessages().receivedMobCoins
                        .replace("%prefix%", IridiumMobCoins.getInstance().getConfiguration().prefix)
                        .replace("%player%", user.getName())
                        .replace("%amount%", String.valueOf(amount))
                ));
            }
        } else {
            sender.sendMessage(StringUtils.color(IridiumMobCoins.getInstance().getMessages().unknownPlayer
                    .replace("%prefix%", IridiumMobCoins.getInstance().getConfiguration().prefix)
            ));
        }
    }

    /**
     * Handles tab-completion for this command.
     *
     * @param commandSender The CommandSender which tries to tab-complete
     * @param command       The command
     * @param label         The label of the command
     * @param args          The arguments already provided by the sender
     * @return The list of tab completions for this command
     */
    @Override
    public List<String> onTabComplete(CommandSender commandSender, org.bukkit.command.Command command, String label, String[] args) {
        if (args.length == 2) {
            return null;
        }
        // We currently don't want to tab-completion here
        // Return a new List so it isn't a list of online players
        return Collections.emptyList();
    }

}
