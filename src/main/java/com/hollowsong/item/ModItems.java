package com.hollowsong.item;

import com.hollowsong.Hollowsong;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item RINGSTONE = registerItem("ringstone", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Hollowsong.MOD_ID, "ringstone")))));
    
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Hollowsong.MOD_ID, name), item);
    }
    
    public static void registerModItems() {
        Hollowsong.LOGGER.info("Registering Mod Items for " + Hollowsong.MOD_ID);
    }
}
