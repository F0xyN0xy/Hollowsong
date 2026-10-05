package com.hollowsong.item;

import com.hollowsong.Hollowsong;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item RINGSTONE = registerItem("ringstone",
            new Item(new Item.Settings().registryKey(itemKey("ringstone"))));

    public static final Item TUNING_FORK = registerItem("tuning_fork",
            new Item(new Item.Settings().maxCount(1).registryKey(itemKey("tuning_fork"))));

    // 1.21.2+ requirement: every item needs its registry key in Settings BEFORE construction
    private static RegistryKey<Item> itemKey(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Hollowsong.MOD_ID, name));
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, itemKey(name), item);
    }

    public static void registerModItems() {
        Hollowsong.LOGGER.info("Registering Mod Items for " + Hollowsong.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(TUNING_FORK);
        });
    }
}