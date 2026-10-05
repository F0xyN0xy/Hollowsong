package com.hollowsong.item.custom;

import com.hollowsong.block.RingstoneOreBlock;
import com.hollowsong.sound.ModSounds;
import net.minecraft.block.BlockState;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class TuningForkItem extends Item {

    public TuningForkItem(Settings settings) {
        super(settings);
    }

    // Right-click AIR: standard ping
    @Override
    public ActionResult use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);

        if (!world.isClient()) {
            float pitch = 0.9f + world.getRandom().nextFloat() * 0.2f;
            world.playSound(null, player.getBlockPos(),
                    ModSounds.TUNING_FORK_PING,
                    SoundCategory.PLAYERS, 1.0f, pitch);
            player.getItemCooldownManager().set(stack, 20);
        } else {
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

    // Right-click RINGSTONE ORE: read its resonance
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockState state = world.getBlockState(context.getBlockPos());

        if (state.getBlock() instanceof RingstoneOreBlock) {
            int resonance = state.get(RingstoneOreBlock.RESONANCE);

            if (!world.isClient()) {
                float pitch = 0.8f + resonance * 0.15f;
                world.playSound(null, context.getBlockPos(),
                        ModSounds.TUNING_FORK_PING,
                        SoundCategory.BLOCKS, 1.0f, pitch);
            } else {
                ClientWorld clientWorld = (ClientWorld) world;
                int count = 8 + resonance * 8;
                for (int i = 0; i < count; i++) {
                    double angle = Math.PI * 2.0 * i / count;
                    double x = context.getBlockPos().getX() + 0.5 + Math.cos(angle) * 0.7;
                    double z = context.getBlockPos().getZ() + 0.5 + Math.sin(angle) * 0.7;
                    clientWorld.addParticleClient(ParticleTypes.NOTE,
                            x, context.getBlockPos().getY() + 1.0, z, 1.0, 0.0, 0.0);
                }
            }
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }
}