package de.rares.ttt.utils;

import com.google.common.collect.Lists;
import de.rares.ttt.exec.TikTakToeManager;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class TikTakTokGame {
    public Player p1;
    public Player p2;
    public Player turn;
    public Inventory p1Inv;
    public Inventory p2Inv;
    Material type;
    public ItemStack p1Stack = new ItemStack(Material.STAINED_CLAY, 1, DyeColor.RED.getData());
    public ItemStack p2Stack = new ItemStack(Material.STAINED_CLAY, 1, DyeColor.GREEN.getData());

    private int[] first = new int[]{0, 0, 0};
    private int[] second = new int[]{0, 0, 0};
    private int[] third = new int[]{0, 0, 0};

    private int[][] full = new int[][]{first, second, third};

    public TikTakTokGame(Player p1, Player p2, Inventory p1Inv, Inventory p2Inv) {
        ItemMeta im = p1Stack.getItemMeta();
        im.setDisplayName("§a " + p1.getName());
        p1Stack.setItemMeta(im);

        ItemMeta im2 = p2Stack.getItemMeta();
        im2.setDisplayName("§a " + p2.getName());
        p2Stack.setItemMeta(im2);

        this.p1 = p1;
        this.p2 = p2;
        this.p1Inv = p1Inv;
        this.p2Inv = p2Inv;
    }

    public Player checkWinner() {

        if (p1Inv.getItem(3) != null && p1Inv.getItem(4) != null && p1Inv.getItem(5) != null) {
            if (p1Inv.getItem(3).isSimilar(p1Stack) && p1Inv.getItem(4).isSimilar(p1Stack) && p1Inv.getItem(5).isSimilar(p1Stack)) {

                return p1;
            }
            if (p2Inv.getItem(3).isSimilar(p2Stack) && p2Inv.getItem(4).isSimilar(p2Stack) && p2Inv.getItem(5).isSimilar(p2Stack)) {
                return p2;
            }
        }
        //---1
        if (p1Inv.getItem(3) != null && p1Inv.getItem(13) != null && p1Inv.getItem(23) != null) {
            if (p1Inv.getItem(3).isSimilar(p1Stack) && p1Inv.getItem(13).isSimilar(p1Stack) && p1Inv.getItem(23).isSimilar(p1Stack)) {
                return p1;
            }
            if (p1Inv.getItem(3).isSimilar(p2Stack) && p1Inv.getItem(13).isSimilar(p2Stack) && p1Inv.getItem(23).isSimilar(p2Stack)) {
                return p2;
            }
        }
        // \\\
        if (p1Inv.getItem(5) != null && p1Inv.getItem(13) != null && p1Inv.getItem(21) != null) {
            if (p1Inv.getItem(5).isSimilar(p1Stack) && p1Inv.getItem(13).isSimilar(p1Stack) && p1Inv.getItem(21).isSimilar(p1Stack)) {
                return p1;
            }
            if (p2Inv.getItem(5).isSimilar(p2Stack) && p2Inv.getItem(13).isSimilar(p2Stack) && p2Inv.getItem(21).isSimilar(p2Stack)) {
                return p2;
            }
        }
        // ///
        if (p1Inv.getItem(21) != null && p1Inv.getItem(22) != null && p1Inv.getItem(23) != null) {
            if (p1Inv.getItem(21).isSimilar(p1Stack) && p1Inv.getItem(22).isSimilar(p1Stack) && p1Inv.getItem(23).isSimilar(p1Stack)) {
                return p1;
            }
            if (p2Inv.getItem(21).isSimilar(p2Stack) && p2Inv.getItem(22).isSimilar(p2Stack) && p2Inv.getItem(23).isSimilar(p2Stack)) {
                return p2;
            }
        }
        // ---3
        if (p1Inv.getItem(3) != null && p1Inv.getItem(12) != null && p1Inv.getItem(21) != null) {
            if (p1Inv.getItem(3).isSimilar(p1Stack) && p1Inv.getItem(12).isSimilar(p1Stack) && p1Inv.getItem(21).isSimilar(p1Stack)) {
                return p1;
            }
            if (p2Inv.getItem(3).isSimilar(p2Stack) && p2Inv.getItem(12).isSimilar(p2Stack) && p2Inv.getItem(21).isSimilar(p2Stack)) {
                return p2;
            }
        }
        // | 1
        if (p1Inv.getItem(12) != null && p1Inv.getItem(13) != null && p1Inv.getItem(14) != null) {
            if (p1Inv.getItem(12).isSimilar(p1Stack) && p1Inv.getItem(13).isSimilar(p1Stack) && p1Inv.getItem(14).isSimilar(p1Stack)) {
                return p1;
            }
            if (p2Inv.getItem(12).isSimilar(p2Stack) && p2Inv.getItem(13).isSimilar(p2Stack) && p2Inv.getItem(14).isSimilar(p2Stack)) {
                return p2;
            }
        }
        // --- 2


        if (p1Inv.getItem(4) != null && p1Inv.getItem(13) != null && p1Inv.getItem(22) != null) {
            if (p1Inv.getItem(4).isSimilar(p1Stack) && p1Inv.getItem(13).isSimilar(p1Stack) && p1Inv.getItem(22).isSimilar(p1Stack)) {
                return p1;
            }
            if (p2Inv.getItem(4).isSimilar(p2Stack) && p2Inv.getItem(13).isSimilar(p2Stack) && p2Inv.getItem(22).isSimilar(p2Stack)) {
                return p2;
            }
        }

        if (p1Inv.getItem(5) != null && p1Inv.getItem(14) != null && p1Inv.getItem(23) != null) {
            if (p1Inv.getItem(5).isSimilar(p1Stack) && p1Inv.getItem(14).isSimilar(p1Stack) && p1Inv.getItem(23).isSimilar(p1Stack)) {
                return p1;
            }
            if (p2Inv.getItem(5).isSimilar(p2Stack) && p2Inv.getItem(14).isSimilar(p2Stack) && p2Inv.getItem(23).isSimilar(p2Stack)) {
                return p2;
            }
        }

        return null;
    }

    public void win(Player p) {
        if (p == p1) {
            p1.playSound(p.getLocation(), Sound.GHAST_FIREBALL, 1, 1);
            p.sendMessage("§a Du hast gewonnen!");
            p2.sendMessage("§c Du hast verloren!");
            setupTikInventory(p1Inv, true);
            setupTikInventory(p2Inv, false);
        } else {
            p2.sendMessage("§a Du hast gewonnen!");
            p.sendMessage("§c Du hast verloren!");
            p2.playSound(p.getLocation(), Sound.GHAST_FIREBALL, 1, 1);
            setupTikInventory(p1Inv, false);
            setupTikInventory(p2Inv, true);
        }
    }

    private void setupTikInventory(Inventory inventory, boolean win) {
        List<Integer> exc = Lists.asList(3, new Integer[]{4, 5, 12, 12, 13, 14, 21, 22, 23});
        ItemStack itemStack;

        if (win) {
            itemStack = new ItemStack(Material.EMERALD_BLOCK, 1);
            ItemMeta im = itemStack.getItemMeta();
            im.setDisplayName("§a GEWONNEN!");
            itemStack.setItemMeta(im);
        } else {
            itemStack = new ItemStack(Material.REDSTONE_BLOCK, 1);
            ItemMeta im = itemStack.getItemMeta();
            im.setDisplayName("§4 VERLOREN!");
            itemStack.setItemMeta(im);
        }

        for (int i = 0; i < inventory.getSize(); i++) {
            if (!exc.contains(i)) {
                inventory.setItem(i, itemStack);
            }
        }
    }

    public void cancel() {

        TikTakToeManager.tikTakTokGames.remove(this);
    }
}
