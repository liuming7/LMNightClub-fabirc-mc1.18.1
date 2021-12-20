package com.lmtech.lmNightClub;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LMNightClub implements ModInitializer {

	public static final String MODID = "lmnightclub";

	public static final double TEXTURES_PIXEL_BIT = 16D;
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LogManager.getLogger(MODID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("LMNightClub is loading now!");

		LOGGER.info("LMNightClub has loaded!");

	}

	public static double calculateV(int position,double pixel){
		return position/pixel;
	}
}
