package com.hollowsong.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.math.random.Random;

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

    // Decay: the fading echo. Minecraft calls randomTick() about once
    // per ~68 seconds per block, so resonance bleeds away slowly on its own.
    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        int r = state.get(RESONANCE);
        if (r > 0) {
            world.setBlockState(pos, state.with(RESONANCE, r - 1));
        }
    }
}