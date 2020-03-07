package de.rares.ttt.exec;

import com.google.common.collect.Lists;
import de.rares.ttt.TikTakToe;
import de.rares.ttt.utils.TikTakTokGame;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class TikTakToeManager {

    public static ArrayList<TikTakTokGame> tikTakTokGames = new ArrayList<>();

    public void openPlay(Player p1, Player p2) {
        Inventory inv1 = Bukkit.createInventory(null, 27, "TikTakToe");
        Inventory inv2 = Bukkit.createInventory(null, 27, "TikTakToe");
        p1.openInventory(inv1);
        p2.openInventory(inv2);
        setupTikInventory(inv1);
        setupTikInventory(inv2);
        TikTakTokGame tikTakTokGame = new TikTakTokGame(p1, p2, inv1, inv2);
        tikTakTokGame.turn = p1;
        tikTakTokGames.add(tikTakTokGame);

    }

    public TikTakTokGame getGameByPlayer(Player p) {
        try {


            for (TikTakTokGame tikTakTokGame : tikTakTokGames) {
                if (tikTakTokGame.p1 == p) {

                    return tikTakTokGame;
                } else {
                    if (tikTakTokGame.p2 == p) {
                        return tikTakTokGame;
                    }
                }
            }
        } catch (Exception e) {


            return null;
        }
        return null;
    }

    private void setupTikInventory(Inventory inventory) {
        List<Integer> exc = Lists.asList(3, new Integer[]{4, 5, 12, 12, 13, 14, 21, 22, 23});
        ItemStack stack = new ItemStack(Material.STAINED_CLAY, 1, DyeColor.BLACK.getData());
        for (int i = 0; i < inventory.getSize(); i++) {
            if (!exc.contains(i)) {

                inventory.setItem(i, stack);
            }
        }
    }


}
