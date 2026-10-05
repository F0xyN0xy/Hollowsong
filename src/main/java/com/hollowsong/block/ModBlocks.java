package com.hollowsong.block;

import java.util.Optional;

import com.hollowsong.Hollowsong;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.loot.LootTable;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
	
	// Create loot table registry key first
	private static final RegistryKey<Registry<LootTable>> LOOT_TABLE_REGISTRY = 
		RegistryKey.ofRegistry(Identifier.of("minecraft", "loot_table"));
	
	private static RegistryKey<LootTable> lootTableKey(String name) {
		return RegistryKey.of(LOOT_TABLE_REGISTRY, Identifier.of(Hollowsong.MOD_ID, "blocks/" + name));
	}
	
	public static final Block RINGSTONE_ORE = registerBlock("ringstone_ore",
		new ExperienceDroppingBlock(
			UniformIntProvider.create(2, 5),
			AbstractBlock.Settings.create()
					.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Hollowsong.MOD_ID, "ringstone_ore")))
					.mapColor(MapColor.DEEPSLATE_GRAY)
				.instrument(NoteBlockInstrument.BASEDRUM)
				.requiresTool()
				.strength(3.0f, 3.0f)
				.sounds(BlockSoundGroup.DEEPSLATE)
				.lootTable(Optional.of(lootTableKey("ringstone_ore")))
		));
	
	public static final Block RINGSTONE_BLOCK = registerBlock("ringstone_block",
		new Block(AbstractBlock.Settings.create()
				.registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Hollowsong.MOD_ID, "ringstone_block")))
				.mapColor(MapColor.LIGHT_BLUE)
			.instrument(NoteBlockInstrument.CHIME)
			.requiresTool()
			.strength(3.0f, 6.0f)
			.sounds(BlockSoundGroup.AMETHYST_BLOCK)
			.lootTable(Optional.of(lootTableKey("ringstone_block")))
		));
	private static Block registerBlock(String name, Block block) {
		registerBlockItem(name, block);
		return Registry.register(Registries.BLOCK, Identifier.of(Hollowsong.MOD_ID, name), block);
	}
	
	private static void registerBlockItem(String name, Block block) {
		Registry.register(Registries.ITEM, Identifier.of(Hollowsong.MOD_ID, name),
			new BlockItem(block, new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Hollowsong.MOD_ID, name)))));
	}
	
	public static void registerModBlocks() {
		Hollowsong.LOGGER.info("Registering Mod Blocks for " + Hollowsong.MOD_ID);
		
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
			entries.add(RINGSTONE_BLOCK);
		});
		
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
			entries.add(RINGSTONE_ORE);
		});
	}
}