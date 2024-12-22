package fr.Thorid4n.item;

import fr.Thorid4n.ForVegetation;
import fr.Thorid4n.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ForVegetation.MOD_ID);

    public static final RegistryObject<CreativeModeTab> FORVEGETATION_TAB = CREATIVE_MODE_TABS.register("forvegetation",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.JUNGLE_GRASS.get()))
                    .title(Component.translatable("creativetab.forvegetation"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.JUNGLE_GRASS.get());
                        pOutput.accept(ModBlocks.BIG_LILY_PAD.get());
                        pOutput.accept(ModBlocks.JUNGLE_GRASS_LIGHT.get());


                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
