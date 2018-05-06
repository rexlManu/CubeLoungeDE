/*
 * © Copyright - Emmanuel Lampe aka. rexlManu 2018.
 */
package de.rexlmanu.bewerbung;

import de.rexlmanu.bewerbung.inventory.InventoryDataHandler;
import de.rexlmanu.bewerbung.inventory.TeleporterInventory;
import de.rexlmanu.bewerbung.listeners.player.PlayerInteractListener;
import de.rexlmanu.bewerbung.listeners.player.PlayerJoinListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/******************************************************************************************
 *    Urheberrechtshinweis                                                       
 *    Copyright © Emmanuel Lampe 2018                                       
 *    Erstellt: 06.05.2018 / 17:05                           
 *
 *    Alle Inhalte dieses Quelltextes sind urheberrechtlich geschützt.                    
 *    Das Urheberrecht liegt, soweit nicht ausdrücklich anders gekennzeichnet,       
 *    bei Emmanuel Lampe. Alle Rechte vorbehalten.                      
 *
 *    Jede Art der Vervielfältigung, Verbreitung, Vermietung, Verleihung,        
 *    öffentlichen Zugänglichmachung oder andere Nutzung           
 *    bedarf der ausdrücklichen, schriftlichen Zustimmung von Emmanuel Lampe.  
 ******************************************************************************************/

public final class Bewerbung extends JavaPlugin {

    @Override
    public void onEnable() {
        fetchClasses();
    }

    private void fetchClasses() {
        TeleporterInventory teleporterInventory = new TeleporterInventory(this);
        teleporterInventory.createInventory();

        new PlayerInteractListener(this, new InventoryDataHandler(teleporterInventory));
        new PlayerJoinListener(this);
    }
}
