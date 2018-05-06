/*
 * © Copyright - Emmanuel Lampe aka. rexlManu 2018.
 */
package de.rexlmanu.bewerbung.builder;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/******************************************************************************************
 *    Urheberrechtshinweis                                                       
 *    Copyright © Emmanuel Lampe 2018                                       
 *    Erstellt: 06.05.2018 / 07:54                           
 *
 *    Alle Inhalte dieses Quelltextes sind urheberrechtlich geschützt.                    
 *    Das Urheberrecht liegt, soweit nicht ausdrücklich anders gekennzeichnet,       
 *    bei Emmanuel Lampe. Alle Rechte vorbehalten.                      
 *
 *    Jede Art der Vervielfältigung, Verbreitung, Vermietung, Verleihung,        
 *    öffentlichen Zugänglichmachung oder andere Nutzung           
 *    bedarf der ausdrücklichen, schriftlichen Zustimmung von Emmanuel Lampe.  
 ******************************************************************************************/

public final class InventoryBuilder implements IInventoryBuilder {

    private final Inventory inventory;

    private final String title;

    public InventoryBuilder(final int rows, final String title) {
        this.title = title;
        this.inventory = Bukkit.createInventory(null, rows * 9, title);
    }

    public InventoryBuilder(final String title, final InventoryType type) {
        this.title = title;
        this.inventory = Bukkit.createInventory(null, type, title);
    }

    @Override
    public void setItem(final int slot, final ItemStack itemStack) {
        this.inventory.setItem(slot, itemStack);
    }

    @Override
    public void addItem(final ItemStack itemStack) {
        this.inventory.addItem(itemStack);
    }

    @Override
    public void addItem(final ItemStack... itemStack) {
        this.inventory.addItem(itemStack);
    }

    @Override
    public void setItem(final int x, final int y, final ItemStack itemStack) {
        this.setItem(x + (y * 9), itemStack);
    }

    @Override
    public void fillWith(final ItemStack itemStack) {
        this.fillWith(itemStack, false);
    }

    @Override
    public void replaceWith(final ItemStack itemStack) {
        this.fillWith(itemStack, true);
    }

    @Override
    public void fillWith(final ItemStack itemStack, final boolean replace) {
        for (int i = 0; i < this.inventory.getSize(); i++) {
            if (this.inventory.getItem(i) != null && !replace) {
                break;
            }
            this.setItem(i, itemStack);
        }
    }

    @Override
    public void showInventory(final Player player) {
        player.openInventory(this.build());
    }

    @Override
    public Inventory build() {
        return this.inventory;
    }
}
