package dev.teamcitrus.resourceants.datagen;

import dev.teamcitrus.resourceants.ResourceAnts;
import dev.teamcitrus.resourceants.datagen.provider.RAItemProvider;
import dev.teamcitrus.resourceants.datagen.provider.RAStateProvider;
import dev.teamcitrus.resourceants.datagen.provider.lang.EnUsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ResourceAnts.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RADatagen {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        ExistingFileHelper file = event.getExistingFileHelper();

        LanguageProvider lang = new EnUsProvider(gen);
        RAItemProvider itemProvider = new RAItemProvider(gen, file);
        RAStateProvider stateProvider = new RAStateProvider(gen, file);

        gen.addProvider(event.includeClient(), lang);
        gen.addProvider(event.includeClient(), itemProvider);
        gen.addProvider(event.includeClient(), stateProvider);
    }
}
