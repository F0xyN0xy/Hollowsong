package com.hollowsong;

import com.hollowsong.block.ModBlocks;
import com.hollowsong.item.ModItems;
import com.hollowsong.sound.ModSounds;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hollowsong implements ModInitializer {
    public static final String MOD_ID = "hollowsong";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing Hollowsong - Resonance Awakens");
        ModBlocks.registerModBlocks();
        ModItems.registerModItems();
        ModSounds.registerModSounds();
    }
}
