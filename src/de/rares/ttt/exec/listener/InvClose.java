package de.rares.ttt.exec.listener;

import de.rares.ttt.TikTakToe;
import de.rares.ttt.utils.TikTakTokGame;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class InvClose implements Listener {
    @EventHandler
    public void onClose(InventoryCloseEvent e) {

        Player p = (Player) e.getPlayer();
        TikTakTokGame tikTakTokGame;
        if ((tikTakTokGame = TikTakToe.inst.tikTakToeManager.getGameByPlayer(p)) != null) {
            tikTakTokGame.cancel();
        }

    }
}
