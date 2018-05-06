package de.rexlmanu.bewerbung.builder;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import de.rexlmanu.bewerbung.api.Builder;
import org.apache.commons.codec.binary.Base64;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Created by rexlManu on 03.08.2017.
 * Plugin by rexlManu
 * https://rexlGames.de
 * Coded with IntelliJ
 */
public class ItemBuilder implements Builder<ItemStack> {

    private final ItemStack is;
    private final ItemMeta im;

    public ItemBuilder(final Material material) {
        this.is = new ItemStack(material, 1);
        this.im = this.is.getItemMeta();
    }

    public ItemBuilder(final Material material, final int amount) {
        this.is = new ItemStack(material, amount);
        this.im = this.is.getItemMeta();
    }

    public ItemBuilder(final Material material, final int amount, final int subid) {
        this.is = new ItemStack(material, amount, (short) subid);
        this.im = this.is.getItemMeta();
    }

    public ItemBuilder setName(final String name) {
        this.im.setDisplayName(name);
        return this;
    }

    public ItemBuilder addEnchant(final Enchantment enchantment, final int level) {
        this.im.addEnchant(enchantment, level, false);
        return this;
    }

    public ItemBuilder addItemflag(final ItemFlag... itemFlag) {
        this.im.addItemFlags(itemFlag);
        return this;
    }

    public ItemBuilder setLore(final String... lore) {
        this.im.setLore(Arrays.asList(lore));
        return this;
    }

    public ItemBuilder setLore(final List<String> lore) {
        this.im.setLore(lore);
        return this;
    }

    public ItemBuilder setAmount(final int amount) {
        this.is.setAmount(amount);
        return this;
    }

    public ItemBuilder setSkullOwner(final String owner) {
        final SkullMeta meta = (SkullMeta) this.im;
        meta.setOwner(owner);
        return this;
    }

    public ItemBuilder setLeatherColor(final Color color) {
        final LeatherArmorMeta meta = (LeatherArmorMeta) this.im;
        meta.setColor(color);
        return this;
    }

    public ItemBuilder setDurability(final int durability) {
        this.is.setDurability((short) durability);
        return this;
    }

    @Override
    public ItemStack build() {
        this.is.setItemMeta(this.im);
        return this.is;
    }

    public ItemBuilder setTexture(final String link) {
        final SkullMeta meta = (SkullMeta) this.im;
        final GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        final byte[] encodedData = Base64.encodeBase64(String.format("{textures:{SKIN:{url:\"%s\"}}}", link).getBytes());
        profile.getProperties().put("textures", new Property("textures", new String(encodedData)));
        Field profileField = null;
        try {
            profileField = meta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(meta, profile);
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e1) {
            e1.printStackTrace();
        }
        return this;
    }

    public ItemBuilder setUnbreakable() {
        this.im.spigot().setUnbreakable(true);
        return this;
    }
}
