/**
 * Automatically generated file, changes will be lost.
 */
package org.bukkit.craftbukkit.v1_18_R1.block.impl;

public final class CraftHopper extends org.bukkit.craftbukkit.v1_18_R1.block.data.CraftBlockData implements org.bukkit.block.data.type.Hopper, org.bukkit.block.data.Directional {

    public CraftHopper() {
        super();
    }

    public CraftHopper(net.minecraft.world.level.block.state.BlockState state) {
        super(state);
    }

    // org.bukkit.craftbukkit.v1_18_R1.block.data.type.CraftHopper

    private static final net.minecraft.world.level.block.state.properties.BooleanProperty ENABLED = getBoolean(net.minecraft.world.level.block.HopperBlock.class, "enabled");

    @Override
    public boolean isEnabled() {
        return get(CraftHopper.ENABLED);
    }

    @Override
    public void setEnabled(boolean enabled) {
        set(CraftHopper.ENABLED, enabled);
    }

    // org.bukkit.craftbukkit.v1_18_R1.block.data.CraftDirectional

    private static final net.minecraft.world.level.block.state.properties.EnumProperty<?> FACING = getEnum(net.minecraft.world.level.block.HopperBlock.class, "facing");

    @Override
    public org.bukkit.block.BlockFace getFacing() {
        return get(CraftHopper.FACING, org.bukkit.block.BlockFace.class);
    }

    @Override
    public void setFacing(org.bukkit.block.BlockFace facing) {
        set(CraftHopper.FACING, facing);
    }

    @Override
    public java.util.Set<org.bukkit.block.BlockFace> getFaces() {
        return getValues(CraftHopper.FACING, org.bukkit.block.BlockFace.class);
    }
}
