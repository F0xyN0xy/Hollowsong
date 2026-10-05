package com.hollowsong.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class RingstoneOreBlock extends ExperienceDroppingBlock {

    // The hidden resonance level: 0 (silent) to 4 (singing)
    public static final IntProperty RESONANCE = IntProperty.of("resonance", 0, 4);

    public RingstoneOreBlock(UniformIntProvider experience, Settings settings) {
        super(experience, settings);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(RESONANCE);
    }
}