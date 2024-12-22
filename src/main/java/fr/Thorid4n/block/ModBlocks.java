package fr.Thorid4n.block;

import fr.Thorid4n.ForVegetation;
import fr.Thorid4n.block.custom.BigLilyPad;
import fr.Thorid4n.block.custom.JungleGrass;
import fr.Thorid4n.block.custom.Junglegrasslight;
import fr.Thorid4n.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;


public class ModBlocks {
	public static final DeferredRegister<Block> BLOCKS = 
		DeferredRegister.create(ForgeRegistries.BLOCKS, ForVegetation.MOD_ID); // This is a long list of blocks

	public static final RegistryObject<Block> JUNGLE_GRASS = registerBlock("junglegrass",
			() -> new JungleGrass(BlockBehaviour.Properties.copy(Blocks.GRASS)));

	public static final RegistryObject<Block> JUNGLE_GRASS_LIGHT = registerBlock("junglegrasslight",
			() -> new Junglegrasslight(BlockBehaviour.Properties.copy(Blocks.GRASS)));

	public static final RegistryObject<Block> BIG_LILY_PAD = registerBlock("biglilypad",
			() -> new BigLilyPad(BlockBehaviour.Properties
					.copy(Blocks.LILY_PAD)    // or some minimal properties
					.strength(0.0F)           // optional
					.noCollission()
			)
	);


	private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
		RegistryObject<T> toReturn = BLOCKS.register(name, block);
		registerBlockItem(name, toReturn);
		return toReturn;
	}

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
		
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
