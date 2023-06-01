package me.lava.slashdupe;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class DupeCmd implements CommandExecutor {
    private final Slashdupe slashdupe;

    public DupeCmd(Slashdupe slashdupe) {
        this.slashdupe = slashdupe;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("This command can only be run by a player.");
            return true;
        }

        ItemStack item = player.getInventory().getItemInMainHand();

        if (item == null || item.getType().isAir()) {
            sendConfigMessage(player, "no-item-in-hand");
            return true;
        }

        player.getInventory().addItem(item.clone()); // Clone the item

        sendConfigMessage(player, "duped-item-in-hand");
        return true;
    }

    private void sendConfigMessage(Player player, String path) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', slashdupe.getConfigString(path)));
    }
}