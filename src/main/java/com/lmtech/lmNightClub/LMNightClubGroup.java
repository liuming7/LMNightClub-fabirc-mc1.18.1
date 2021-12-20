package com.lmtech.lmNightClub;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class LMNightClubGroup {

    private static final ItemGroup NIGHT_CLUB = FabricItemGroupBuilder.build(new Identifier("lmnightclub", "night_club"), () -> new ItemStack(LMNightClubGroup.ITEM_VINYL_TURNTABLE));

    private static final VinylTurntable BLOCK_VINYL_TURNTABLE = new VinylTurntable(1,15,1,15,0,6,LMNightClub.TEXTURES_PIXEL_BIT,NIGHT_CLUB);
    private static final Item ITEM_VINYL_TURNTABLE = BLOCK_VINYL_TURNTABLE.itemVinylTurntable;

    private static final Mixer BLOCK_MIXER = new Mixer(1,15,1,15,0,4,LMNightClub.TEXTURES_PIXEL_BIT,NIGHT_CLUB);
    private static final Item ITEM_MIXER = BLOCK_MIXER.itemMixer;

    public static void onInitialize(String MODID){
        Registry.register(Registry.BLOCK, new Identifier(MODID, "vinyl_turntable"), BLOCK_VINYL_TURNTABLE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "vinyl_turntable"), ITEM_VINYL_TURNTABLE);
        //vinylTurntableEntity = Registry.register(Registry.BLOCK_ENTITY_TYPE,"lmindustry:vinyl_turntable",BlockEntityType.Builder.create(VinylTurntableEntity::new,BLOCK_VINYL_TURNTABLE).build(null));

        Registry.register(Registry.BLOCK, new Identifier(MODID, "mixer"), BLOCK_MIXER);
        Registry.register(Registry.ITEM, new Identifier(MODID, "mixer"), ITEM_MIXER);
    }
}
