package dansplugins.currencies;

import dansplugins.currencies.managers.StorageManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;

import static org.bukkit.Bukkit.getServer;

public class Scheduler {

    private static Scheduler instance;

    private Scheduler() {

    }

    public static Scheduler getInstance() {
        if (instance == null) {
            instance = new Scheduler();
        }
        return instance;
    }

    public void scheduleAutosave() {
        if (Currencies.getInstance().isDebugEnabled()) { System.out.println("[Currencies] Scheduling hourly autosave."); }
        int delay = 60 * 60; // 1 hour
        int secondsUntilRepeat = 60 * 60; // 1 hour
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Currencies.getInstance(), new Runnable() {
            @Override
            public void run() {
                if (Currencies.getInstance().isDebugEnabled()) { System.out.println("[Currencies] Saving. This will happen hourly."); }
                StorageManager.getInstance().save();
            }
        }, delay * 20, secondsUntilRepeat * 20);
    }

}