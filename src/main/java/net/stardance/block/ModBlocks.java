package net.stardance.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.stardance.Starflight;

public class ModBlocks {
    public static final Block ARMOR_PANEL = new Block(AbstractBlock.Settings.copy(Registries.BLOCK.get(Identifier.of("minecraft","iron_block"))));

    public static void init() {
        Registry.register(Registries.BLOCK, new Identifier(Starflight.MOD_ID, "armor_panel"), ARMOR_PANEL);
    }
}
