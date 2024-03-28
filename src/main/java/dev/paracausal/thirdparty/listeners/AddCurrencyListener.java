package dev.paracausal.thirdparty.listeners;

import dev.paracausal.testplugin.api.events.AddCurrencyEvent;
import dev.paracausal.thirdparty.ThirdParty;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class AddCurrencyListener implements Listener {

    public AddCurrencyListener(ThirdParty plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onAddCurrency(AddCurrencyEvent event) {
        final Player player = event.getPlayer();

        if (player.hasPermission("thirdparty.blocked")) {
            event.setCancelled(true);
            return;
        }

        if (player.hasPermission("thirdparty.double")) event.setAmount(event.getAmount()*2);
    }

}
