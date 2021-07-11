package com.iridium.iridiummobcoins.commands;

import com.iridium.iridiumcore.utils.StringUtils;
import com.iridium.iridiummobcoins.IridiumMobCoins;
import com.iridium.iridiummobcoins.database.User;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BalanceCommand extends Command {

    /**
     * The default constructor.
     */
    public BalanceCommand() {
        super(Collections.singletonList("balance"), "Show your current mobcoins balance", "", true);
    }

    /**
     * Executes the command for the specified {@link CommandSender} with the provided arguments.
     * Not called when the command execution was invalid (no permission, no player or command disabled).
     *
     * @param sender    The CommandSender which executes this command
     * @param arguments The arguments used with this command. They contain the sub-command
     */
    @Override
    public void execute(CommandSender sender, String[] arguments) {
        Player player = (Player) sender;
        User user = IridiumMobCoins.getInstance().getDatabaseManager().getUser(player.getUniqueId());
        player.sendMessage(StringUtils.color(IridiumMobCoins.getInstance().getMessages().mobcoinsBalance
                .replace("%prefix%", IridiumMobCoins.getInstance().getConfiguration().prefix)
                .replace("%balance%", String.valueOf(user.getMobcoins()))
        ));
    }

    /**
     * Handles tab-completion for this command.
     *
     * @param commandSender The CommandSender which tries to tab-complete
     * @param cmd           The command
     * @param label         The label of the command
     * @param args          The arguments already provided by the sender
     * @return The list of tab completions for this command
     */
    @Override
    public List<String> onTabComplete(CommandSender commandSender, org.bukkit.command.Command cmd, String label, String[] args) {

        // We currently don't want to tab-completion here
        // Return a new List so it isn't a list of online players
        return Collections.emptyList();
    }

}
