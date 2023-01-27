package com.arkasha.TotemSwapper;

import net.minecraft.client.MinecraftClient;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.SlotActionType;

public class InventoryUtils {
    public static void swapTotem(MinecraftClient client){
        int totemSlot = -1;
        for(int i = 0;i<36;++i) {
            ItemStack stack = client.player.getInventory().getStack(i);

            if (stack.getItem() == Items.TOTEM_OF_UNDYING) {
                if(i<9){
                    i+=36;
                }
                totemSlot = i;
            }
        }
        if (totemSlot >= 0) {
            swap(totemSlot, client);
        }
    }
    private static void swap(int slot, MinecraftClient client) {
        client.interactionManager.clickSlot(0, slot, 0, SlotActionType.PICKUP, client.player);
        client.interactionManager.clickSlot(0, 45, 0, SlotActionType.PICKUP, client.player);
        client.interactionManager.clickSlot(0, slot, 0, SlotActionType.PICKUP, client.player);
    }
}
