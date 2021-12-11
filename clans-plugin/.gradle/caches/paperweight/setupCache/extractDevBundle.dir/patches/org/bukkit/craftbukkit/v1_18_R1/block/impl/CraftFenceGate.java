/**
 * Automatically generated file, changes will be lost.
 */
package org.bukkit.craftbukkit.v1_18_R1.block.impl;

public final class CraftFenceGate extends org.bukkit.craftbukkit.v1_18_R1.block.data.CraftBlockData implements org.bukkit.block.data.type.Gate, org.bukkit.block.data.Directional, org.bukkit.block.data.Openable, org.bukkit.block.data.Powerable {

    public CraftFenceGate() {
        super();
    }

    public CraftFenceGate(net.minecraft.world.level.block.state.BlockState state) {
        super(state);
    }

    // org.bukkit.craftbukkit.v1_18_R1.block.data.type.CraftGate

    private static final net.minecraft.world.level.block.state.properties.BooleanProperty IN_WALL = getBoolean(net.minecraft.world.level.block.FenceGateBlock.class, "in_wall");

    @Override
    public boolean isInWall() {
        return get(CraftFenceGate.IN_WALL);
    }

    @Override
    public void setInWall(boolean inWall) {
        set(CraftFenceGate.IN_WALL, inWall);
    }

    // org.bukkit.craftbukkit.v1_18_R1.block.data.CraftDirectional

    private static final net.minecraft.world.level.block.state.properties.EnumProperty<?> FACING = getEnum(net.minecraft.world.level.block.FenceGateBlock.class, "facing");

    @Override
    public org.bukkit.block.BlockFace getFacing() {
        return get(CraftFenceGate.FACING, org.bukkit.block.BlockFace.class);
    }

    @Override
    public void setFacing(org.bukkit.block.BlockFace facing) {
        set(CraftFenceGate.FACING, facing);
    }

    @Override
    public java.util.Set<org.bukkit.block.BlockFace> getFaces() {
        return getValues(CraftFenceGate.FACING, org.bukkit.block.BlockFace.class);
    }

    // org.bukkit.craftbukkit.v1_18_R1.block.data.CraftOpenable

    private static final net.minecraft.world.level.block.state.properties.BooleanProperty OPEN = getBoolean(net.minecraft.world.level.block.FenceGateBlock.class, "open");

    @Override
    public boolean isOpen() {
        return get(CraftFenceGate.OPEN);
    }

    @Override
    public void setOpen(boolean open) {
        set(CraftFenceGate.OPEN, open);
    }

    // org.bukkit.craftbukkit.v1_18_R1.block.data.CraftPowerable

    private static final net.minecraft.world.level.block.state.properties.BooleanProperty POWERED = getBoolean(net.minecraft.world.level.block.FenceGateBlock.class, "powered");

    @Override
    public boolean isPowered() {
        return get(CraftFenceGate.POWERED);
    }

    @Override
    public void setPowered(boolean powered) {
        set(CraftFenceGate.POWERED, powered);
    }
}
