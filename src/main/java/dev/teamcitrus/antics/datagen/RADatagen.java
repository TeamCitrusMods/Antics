package dev.teamcitrus.antics.datagen;

import dev.teamcitrus.antics.Antics;
import dev.teamcitrus.antics.datagen.provider.RABlockStates;
import dev.teamcitrus.antics.datagen.provider.lang.EnUsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Antics.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RADatagen {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        ExistingFileHelper file = event.getExistingFileHelper();
        PackOutput packOutput = gen.getPackOutput();

        gen.addProvider(event.includeClient(), new EnUsProvider(packOutput));
        gen.addProvider(event.includeServer(), new RABlockStates(packOutput, file));
    }
}
