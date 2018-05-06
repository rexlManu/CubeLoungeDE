/*
 * © Copyright - Emmanuel Lampe aka. rexlManu 2018.
 */
package de.rexlmanu.bewerbung.listeners.player;

import de.rexlmanu.bewerbung.builder.InventoryBuilder;
import de.rexlmanu.bewerbung.inventory.InventoryDataHandler;
import de.rexlmanu.bewerbung.listeners.Listener;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/******************************************************************************************
 *    Urheberrechtshinweis                                                       
 *    Copyright © Emmanuel Lampe 2018                                       
 *    Erstellt: 06.05.2018 / 17:14                           
 *
 *    Alle Inhalte dieses Quelltextes sind urheberrechtlich geschützt.                    
 *    Das Urheberrecht liegt, soweit nicht ausdrücklich anders gekennzeichnet,       
 *    bei Emmanuel Lampe. Alle Rechte vorbehalten.                      
 *
 *    Jede Art der Vervielfältigung, Verbreitung, Vermietung, Verleihung,        
 *    öffentlichen Zugänglichmachung oder andere Nutzung           
 *    bedarf der ausdrücklichen, schriftlichen Zustimmung von Emmanuel Lampe.  
 ******************************************************************************************/

public final class PlayerInteractListener extends Listener {

    private InventoryDataHandler inventoryDataHandler;

    public PlayerInteractListener(JavaPlugin javaPlugin, InventoryDataHandler inventoryDataHandler) {
        super(javaPlugin);
        this.inventoryDataHandler = inventoryDataHandler;
    }

    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent event) {
        if (event.getAction() != Action.RIGHT_CLICK_BLOCK && event.getAction() != Action.RIGHT_CLICK_AIR) return;

        if (event.getItem() == null) return;

        if (!event.getItem().hasItemMeta()) return;
        String displayName = event.getItem().getItemMeta().getDisplayName();
        Player player = event.getPlayer();
        if (displayName.equals("§c" + player.getName() + "´s §bTeleporter")) {
            event.setCancelled(true);
            this.inventoryDataHandler.getTeleporterInventory().showInventory(player);
        }
    }
}
