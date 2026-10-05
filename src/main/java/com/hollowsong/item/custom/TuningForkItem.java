package com.hollowsong.item.custom;

import com.hollowsong.sound.ModSounds;

import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class TuningForkItem extends Item {

    public TuningForkItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);

        if (!world.isClient()) {
            // Server: play the chime ping
            float pitch = 0.9f + world.getRandom().nextFloat() * 0.2f; // 0.9 to 1.1
            world.playSound(null, player.getBlockPos(),
                ModSounds.TUNING_FORK_PING, SoundCategory.PLAYERS, 1.0f, pitch);
            // 1.21.11: cooldowns take the ItemStack, not the Item
            player.getItemCooldownManager().set(stack, 20);
        } else {
            // Client: particle ring around the player
            ClientWorld clientWorld = (ClientWorld) world;
            for (int i = 0; i < 24; i++) {
                double angle = (Math.PI * 2.0 * i) / 24.0;
                double x = player.getX() + Math.cos(angle) * 1.5;
                double z = player.getZ() + Math.sin(angle) * 1.5;
                clientWorld.addParticleClient(ParticleTypes.NOTE, x, player.getY() + 1.0, z, 1.0, 0.0, 0.0);
            }
        }

        return ActionResult.SUCCESS;
    }
}