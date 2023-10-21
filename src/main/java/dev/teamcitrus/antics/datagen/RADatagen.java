package dev.teamcitrus.antics.datagen;

import dev.teamcitrus.antics.Antics;
import dev.teamcitrus.antics.datagen.provider.*;
import dev.teamcitrus.antics.datagen.provider.lang.EnUsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = Antics.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RADatagen {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        ExistingFileHelper file = event.getExistingFileHelper();
        PackOutput packOutput = gen.getPackOutput();
        CompletableFuture<HolderLookup.Provider> complete = event.getLookupProvider();
        RATagProvider.Blocks blockTags = new RATagProvider.Blocks(packOutput, complete, file);

        gen.addProvider(event.includeClient(), new EnUsProvider(packOutput));
        gen.addProvider(event.includeServer(), new RABlockStatesProvider(packOutput, file));
        gen.addProvider(event.includeServer(), new RAItemModelProvider(packOutput, file));
        gen.addProvider(event.includeServer(), RALootProvider.create(packOutput));
        gen.addProvider(event.includeServer(), blockTags);
        gen.addProvider(event.includeServer(), new RATagProvider.Items(packOutput, complete, blockTags.contentsGetter(), file));
        gen.addProvider(event.includeServer(), new RAWorldgenProvider(packOutput, complete));
    }
}
