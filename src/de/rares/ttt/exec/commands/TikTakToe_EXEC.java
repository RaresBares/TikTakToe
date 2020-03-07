package de.rares.ttt.exec.commands;

import de.rares.ttt.TikTakToe;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TikTakToe_EXEC implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if (p.hasPermission("tiktak.toe")) {
                if (strings.length == 1) {
                    Player t = Bukkit.getPlayer(strings[0]);
                    if (t != null) {
                        if (TikTakToe.inst.curruent.requests.containsKey(t)) {
                            TikTakToe.inst.curruent.requests.remove(t);
                            TikTakToe.inst.tikTakToeManager.openPlay(p, t);
                        } else {
                            p.sendMessage("§aDu hast §6" + t.getName() + " §aeine §2TikTakToe-Anfrage§a gesendet!");
                            t.sendMessage("§6 " + p.getName() + "§a hat dir eine §2TikTakToe-Anfrage§a gestellt! nehme mit §6/tiktaktoe " + p.getName() + "§a diese Anfrage an!");
                            TikTakToe.inst.curruent.requests.put(p, t);
                        }
                    }
                }
            } else {
                p.sendMessage("§cTikTakToe | Du hast dazu keine Rechte");
            }
        } else {
            commandSender.sendMessage("Du musst ein Spieler sein!");
        }

        return true;
    }
}
