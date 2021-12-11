package org.bukkit.craftbukkit.v1_18_R1.entity;

import com.google.common.collect.ImmutableList;
import java.util.Collection;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.PotionUtils;
import org.apache.commons.lang.Validate;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_18_R1.CraftServer;
import org.bukkit.craftbukkit.v1_18_R1.inventory.CraftItemStack;
import org.bukkit.craftbukkit.v1_18_R1.potion.CraftPotionUtil;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ThrownPotion;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

public class CraftThrownPotion extends CraftProjectile implements ThrownPotion {
    public CraftThrownPotion(CraftServer server, net.minecraft.world.entity.projectile.ThrownPotion entity) {
        super(server, entity);
    }

    @Override
    public Collection<PotionEffect> getEffects() {
        ImmutableList.Builder<PotionEffect> builder = ImmutableList.builder();
        for (MobEffectInstance effect : PotionUtils.getMobEffects(this.getHandle().getItemRaw())) {
            builder.add(CraftPotionUtil.toBukkit(effect));
        }
        return builder.build();
    }

    @Override
    public ItemStack getItem() {
        return CraftItemStack.asBukkitCopy(this.getHandle().getItemRaw());
    }

    @Override
    public void setItem(ItemStack item) {
        // The ItemStack must not be null.
        Validate.notNull(item, "ItemStack cannot be null.");

        // The ItemStack must be a potion.
        Validate.isTrue(item.getType() == Material.LINGERING_POTION || item.getType() == Material.SPLASH_POTION, "ItemStack must be a lingering or splash potion. This item stack was " + item.getType() + ".");

        this.getHandle().setItem(CraftItemStack.asNMSCopy(item));
    }

    @Override
    public net.minecraft.world.entity.projectile.ThrownPotion getHandle() {
        return (net.minecraft.world.entity.projectile.ThrownPotion) entity;
    }

    @Override
    public EntityType getType() {
        return EntityType.SPLASH_POTION;
    }
}
