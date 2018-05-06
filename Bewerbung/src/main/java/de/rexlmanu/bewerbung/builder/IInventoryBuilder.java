/*
 * © Copyright - Emmanuel Lampe aka. rexlManu 2018.
 */
package de.rexlmanu.bewerbung.builder;

import de.rexlmanu.bewerbung.api.Builder;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/******************************************************************************************
 *    Urheberrechtshinweis                                                       
 *    Copyright © Emmanuel Lampe 2018                                       
 *    Erstellt: 05.05.2018 / 05:57                           
 *
 *    Alle Inhalte dieses Quelltextes sind urheberrechtlich geschützt.                    
 *    Das Urheberrecht liegt, soweit nicht ausdrücklich anders gekennzeichnet,       
 *    bei Emmanuel Lampe. Alle Rechte vorbehalten.                      
 *
 *    Jede Art der Vervielfältigung, Verbreitung, Vermietung, Verleihung,        
 *    öffentlichen Zugänglichmachung oder andere Nutzung           
 *    bedarf der ausdrücklichen, schriftlichen Zustimmung von Emmanuel Lampe.  
 ******************************************************************************************/


public interface IInventoryBuilder extends Builder<Inventory> {

    void setItem(int slot, ItemStack itemStack);

    void addItem(ItemStack itemStack);

    void addItem(ItemStack... itemStack);

    void setItem(int x, int y, ItemStack itemStack);

    void fillWith(ItemStack itemStack);

    void replaceWith(ItemStack itemStack);

    void fillWith(ItemStack itemStack, boolean replace);

    void showInventory(Player player);

}
