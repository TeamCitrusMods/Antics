package dev.teamcitrus.antics.config;

import dev.teamcitrus.antics.util.TierDisplayOptions;
import net.minecraftforge.common.ForgeConfigSpec;

public class RAConfig {
    public static final ForgeConfigSpec CLIENT_SPEC;

    public static ForgeConfigSpec.EnumValue<TierDisplayOptions> tierDisplay;

    static {
        ForgeConfigSpec.Builder clientConfigBuilder = new ForgeConfigSpec.Builder();
        setupClientConfig(clientConfigBuilder);
        CLIENT_SPEC = clientConfigBuilder.build();
    }

    private static void setupClientConfig(ForgeConfigSpec.Builder builder) {
        tierDisplay = builder.comment("Changes the tooltip for the mushrooms as to how it displays the mushroom's tier")
                .defineEnum("tierDisplayChoice", TierDisplayOptions.NUMERICAL);
    }
}
