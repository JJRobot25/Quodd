package net.jjrobot25;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.jjrobot25.datagen.QuoddModelGen;
import net.jjrobot25.datagen.QuoddRecipeGen;

public class QuoddDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(QuoddModelGen::new);
		pack.addProvider(QuoddRecipeGen::new);
	}
}
