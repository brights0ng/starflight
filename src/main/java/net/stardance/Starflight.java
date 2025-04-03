package net.stardance;

import net.fabricmc.api.ModInitializer;

import net.stardance.block.ModBlocks;
import net.stardance.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Starflight implements ModInitializer {
	public static final String MOD_ID = "starflight";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.init();
		ModBlocks.init();
	}
}