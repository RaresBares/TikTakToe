package de.rares.ttt.exec.listener;

import com.google.common.collect.Lists;
import de.rares.ttt.TikTakToe;
import de.rares.ttt.utils.TikTakTokGame;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.List;

public class InvClick implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {

        Player p = (Player) e.getWhoClicked();
        TikTakTokGame tikTakTokGame;
        if ((tikTakTokGame = TikTakToe.inst.tikTakToeManager.getGameByPlayer(p)) != null && e.getClickedInventory().getTitle() == "TikTakToe") {
            List<Integer> exc = Lists.asList(3, new Integer[]{4, 5, 3, 12, 13, 14, 21, 22, 23});

            if (exc.contains(e.getSlot())) {

                if (e.getCurrentItem().getType() == Material.AIR) {
                    if (tikTakTokGame.turn == p) {
                        if (tikTakTokGame.p1 == p) {

                            e.getClickedInventory().setItem(e.getSlot(), tikTakTokGame.p1Stack);
                            tikTakTokGame.p2Inv.setItem(e.getSlot(), tikTakTokGame.p1Stack);
                            tikTakTokGame.turn = tikTakTokGame.p2;
                        } else {

                            e.getClickedInventory().setItem(e.getSlot(), tikTakTokGame.p2Stack);
                            tikTakTokGame.p1Inv.setItem(e.getSlot(), tikTakTokGame.p2Stack);
                            tikTakTokGame.turn = tikTakTokGame.p1;
                        }

                        if (tikTakTokGame.checkWinner() == p) {
                            tikTakTokGame.win(p);
                        }

                    }
                    e.setCancelled(true);
                } else {

                    e.setCancelled(true);
                }

            } else {
                e.setCancelled(true);
            }
        }


    }


}
