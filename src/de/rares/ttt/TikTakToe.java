package de.rares.ttt;

import de.rares.ttt.exec.TikTakToeManager;
import de.rares.ttt.exec.commands.TikTakToe_EXEC;
import de.rares.ttt.exec.listener.InvClick;
import de.rares.ttt.exec.listener.InvClose;
import de.rares.ttt.logs.Log;
import de.rares.ttt.utils.Current;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class TikTakToe extends JavaPlugin {

    public Log log;
    public Current curruent;
    public TikTakToeManager tikTakToeManager;
    public static TikTakToe inst;

    @Override
    public void onEnable() {
        initCommands();
        inst = this;
        curruent = new Current();
        log = new Log();
        tikTakToeManager = new TikTakToeManager();


        log.sendLog("Plugin gestartet!");
    }


    @Override
    public void onDisable() {

    }


    public void initCommands() {
        getCommand("tiktaktoe").setExecutor(new TikTakToe_EXEC());
        Bukkit.getPluginManager().registerEvents(new InvClick(), this);
        Bukkit.getPluginManager().registerEvents(new InvClose(), this);


    }

}
