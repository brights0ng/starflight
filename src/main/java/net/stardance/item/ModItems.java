package net.stardance.item;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.stardance.Starflight;
import net.stardance.block.ModBlocks;

public class ModItems {
    public static final Item ARMOR_PANEL_ITEM = new BlockItem(ModBlocks.ARMOR_PANEL, new Item.Settings());

    public static final ItemGroup STARFLIGHT_BLOCKS = new ItemGroup.Builder(ItemGroup.Row.TOP, 1)
            .displayName(Text.literal("Stardance Utils"))
            .icon(() -> new ItemStack(ARMOR_PANEL_ITEM))
            .entries((displayContext, entries) -> {
                entries.add(ARMOR_PANEL_ITEM);
            })
            .build();

    public static void init() {
        Registry.register(Registries.ITEM, new Identifier(Starflight.MOD_ID, "armor_panel"), ARMOR_PANEL_ITEM);
        Registry.register(Registries.ITEM_GROUP, new Identifier(Starflight.MOD_ID, "starflight_blocks"), STARFLIGHT_BLOCKS);
    }
}