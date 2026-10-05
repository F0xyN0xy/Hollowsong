package com.hollowsong;

import com.hollowsong.block.ModBlocks;
import com.hollowsong.block.RingstoneOreBlock;
import com.hollowsong.item.ModItems;
import com.hollowsong.sound.ModSounds;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.block.BlockState;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hollowsong implements ModInitializer {
    public static final String MOD_ID = "hollowsong";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    private static int tickCounter = 0;

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing Hollowsong - Resonance Awakens");

        ModBlocks.registerModBlocks();
        ModItems.registerModItems();
        ModSounds.registerModSounds();

        // Resonance charging: walking near Ringstone Ore builds resonance
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            if (++tickCounter % 20 != 0) return; // once per second

            for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
                if (player.isSneaking()) continue; // sneaking = silent

                World world = player.getEntityWorld();
                for (BlockPos pos : BlockPos.iterateOutwards(player.getBlockPos(), 2, 1, 2)) {
                    BlockState state = world.getBlockState(pos);
                    if (state.getBlock() instanceof RingstoneOreBlock) {
                        int r = state.get(RingstoneOreBlock.RESONANCE);
                        if (r < 4 && world.getRandom().nextInt(10) == 0) {
                            world.setBlockState(pos, state.with(RingstoneOreBlock.RESONANCE, r + 1));
                        }
                    }
                }
            }
        });
    }
}