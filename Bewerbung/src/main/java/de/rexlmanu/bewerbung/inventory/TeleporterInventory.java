/*
 * © Copyright - Emmanuel Lampe aka. rexlManu 2018.
 */
package de.rexlmanu.bewerbung.inventory;

import de.rexlmanu.bewerbung.builder.InventoryBuilder;
import de.rexlmanu.bewerbung.builder.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

/******************************************************************************************
 *    Urheberrechtshinweis                                                       
 *    Copyright © Emmanuel Lampe 2018                                       
 *    Erstellt: 06.05.2018 / 17:18                           
 *
 *    Alle Inhalte dieses Quelltextes sind urheberrechtlich geschützt.                    
 *    Das Urheberrecht liegt, soweit nicht ausdrücklich anders gekennzeichnet,       
 *    bei Emmanuel Lampe. Alle Rechte vorbehalten.                      
 *
 *    Jede Art der Vervielfältigung, Verbreitung, Vermietung, Verleihung,        
 *    öffentlichen Zugänglichmachung oder andere Nutzung           
 *    bedarf der ausdrücklichen, schriftlichen Zustimmung von Emmanuel Lampe.  
 ******************************************************************************************/

public final class TeleporterInventory implements IInventory {

    private JavaPlugin javaPlugin;

    public TeleporterInventory(JavaPlugin javaPlugin) {
        this.javaPlugin = javaPlugin;
    }

    private Inventory inventory;

    @Override
    public void createInventory() {
        InventoryBuilder inventoryBuilder = new InventoryBuilder(5, "§bTeleporter");
        inventoryBuilder.fillWith(new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 15).setName("§r").build());
        inventoryBuilder.setItem(10, new ItemBuilder(Material.STONE, 1).setName("§aWarp").build());
        inventoryBuilder.setItem(11, new ItemBuilder(Material.STONE, 1).setName("§aWarp").build());
        inventoryBuilder.setItem(12, new ItemBuilder(Material.STONE, 1).setName("§aWarp").build());
        inventoryBuilder.setItem(13, new ItemBuilder(Material.STONE, 1).setName("§aWarp").build());
        inventoryBuilder.setItem(14, new ItemBuilder(Material.STONE, 1).setName("§aWarp").build());
        inventoryBuilder.setItem(15, new ItemBuilder(Material.STONE, 1).setName("§aWarp").build());
        this.inventory = inventoryBuilder.build();
    }

    @Override
    public void showInventory(Player player) {
        ItemStack[] contents = this.inventory.getContents();
        inventory.clear();
        player.openInventory(inventory);
        new BukkitRunnable() {
            int i = 0;

            @Override
            public void run() {
                inventory.setItem(i, contents[i]);
                i++;
                if (contents.length <= i) cancel();
            }
        }.runTaskTimer(javaPlugin, 0, 1);
    }
}
