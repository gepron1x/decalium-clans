/**
 * Automatically generated file, changes will be lost.
 */
package org.bukkit.craftbukkit.v1_18_R1.block.impl;

public final class CraftConduit extends org.bukkit.craftbukkit.v1_18_R1.block.data.CraftBlockData implements org.bukkit.block.data.Waterlogged {

    public CraftConduit() {
        super();
    }

    public CraftConduit(net.minecraft.world.level.block.state.BlockState state) {
        super(state);
    }

    // org.bukkit.craftbukkit.v1_18_R1.block.data.CraftWaterlogged

    private static final net.minecraft.world.level.block.state.properties.BooleanProperty WATERLOGGED = getBoolean(net.minecraft.world.level.block.ConduitBlock.class, "waterlogged");

    @Override
    public boolean isWaterlogged() {
        return get(CraftConduit.WATERLOGGED);
    }

    @Override
    public void setWaterlogged(boolean waterlogged) {
        set(CraftConduit.WATERLOGGED, waterlogged);
    }
}
