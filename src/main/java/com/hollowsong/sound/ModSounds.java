package com.hollowsong.sound;

import com.hollowsong.Hollowsong;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {

    public static final SoundEvent TUNING_FORK_PING = register("tuning_fork_ping");

    private static SoundEvent register(String name) {
        Identifier id = Identifier.of(Hollowsong.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerModSounds() {
        Hollowsong.LOGGER.info("Registering Mod Sounds for " + Hollowsong.MOD_ID);
    }
}