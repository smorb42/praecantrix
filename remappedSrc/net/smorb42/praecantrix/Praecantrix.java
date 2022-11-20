package net.smorb42.praecantrix;

import net.fabricmc.api.ModInitializer;
import net.smorb42.praecantrix.block.ModBlocks;
import net.smorb42.praecantrix.block.entity.ModBlockEntities;
import net.smorb42.praecantrix.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Praecantrix implements ModInitializer {

	public static final String MOD_ID = "praecantrix";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModBlockEntities.registerAllBlockEntities();

		LOGGER.info("Initialized: " + MOD_ID);
	}
}
