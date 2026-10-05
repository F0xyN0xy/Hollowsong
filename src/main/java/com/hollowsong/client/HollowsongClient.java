package com.hollowsong.client;

import net.fabricmc.api.ClientModInitializer;

public class HollowsongClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        System.out.println("Hollowsong client initialized!");
    }
}
