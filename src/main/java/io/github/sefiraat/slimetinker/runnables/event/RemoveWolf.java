package io.github.sefiraat.slimetinker.runnables.event;

import io.github.sefiraat.slimetinker.events.PlayerDamagedEvents;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class RemoveWolf extends BukkitRunnable {

    private final Wolf wolf;
    private final Player player;

    public RemoveWolf(Wolf wolf, Player player) {
        this.wolf = wolf;
        this.player = player;
    }

    @Override
    public void run() {
        wolf.remove();
        if (PlayerDamagedEvents.wolfCount.containsKey(player)){
            if (((PlayerDamagedEvents.wolfCount.get(player)-1) <= 1)) return;
            PlayerDamagedEvents.wolfCount.replace(player, PlayerDamagedEvents.wolfCount.get(player)-1);
        }
        this.cancel();
    }
}
