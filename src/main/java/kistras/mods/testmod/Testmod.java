package kistras.mods.testmod;
import kistras.mods.testmod.theblockofcocks;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Testmod implements ModInitializer {

    public static final Item TESTITEM_1 = new Item(new Item.Settings().group(ItemGroup.MISC).maxCount(42));
    public static final Block BLOCKOFCOCKS = new theblockofcocks(FabricBlockSettings
            .of(Material.STONE)
            .strength(5.0F, 5.0F)
            .sounds(BlockSoundGroup.HONEY)
            .breakByTool(FabricToolTags.HOES)
    );

    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("testmod", "testitem_1"), TESTITEM_1);

        Registry.register(Registry.BLOCK, new Identifier("testmod", "theblockofcocks"), BLOCKOFCOCKS);
        Registry.register(Registry.ITEM, new Identifier("testmod", "theblockofcocks"), new BlockItem(BLOCKOFCOCKS, new Item.Settings().group(ItemGroup.FOOD)));
        System.out.println("Beep beep, Imma sheep.");
    }
}
