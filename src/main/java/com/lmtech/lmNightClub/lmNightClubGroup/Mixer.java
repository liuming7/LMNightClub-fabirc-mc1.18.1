package com.lmtech.lmNightClub.lmNightClubGroup;

import com.lmtech.lmNightClub.LMNightClub;
import com.lmtech.lmNightClub.auxiliary.HorizontalFacingBlockWithEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

public class Mixer extends HorizontalFacingBlockWithEntity {

    private double pixelBit;
    private int west;
    private int east;
    private int north;
    private int south;
    private int bottom;
    private int top;

    Item itemMixer = null;

    public static final BooleanProperty showPanel = BooleanProperty.of("show_panel");

    public Mixer(int west, int east, int north, int south, int bottom, int top, double pixelBit, ItemGroup itemGroup){
        super(FabricBlockSettings.of(Material.WOOD)
                .strength(1.0f)
                .resistance(4.0f)
                .breakByHand(true));
        itemMixer = new BlockItem(this,new Item.Settings().group(itemGroup)
                .maxCount(1));

        setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH)
                .with(showPanel,false));

        this.west = west;this.east = east;this.north = north;this.south = south;this.bottom = bottom;this.top = top;this.pixelBit = pixelBit;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.cuboid(LMNightClub.calculateV(west,pixelBit),//west
                LMNightClub.calculateV(bottom,pixelBit),//bottom
                LMNightClub.calculateV(north,pixelBit),//north
                LMNightClub.calculateV(east,pixelBit),//east
                LMNightClub.calculateV(top,pixelBit),//top
                LMNightClub.calculateV(south,pixelBit));//south
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Properties.HORIZONTAL_FACING);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState)this.getDefaultState().with(FACING, ctx.getPlayerFacing());
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom) {
        return direction == Direction.DOWN && !this.canPlaceAt(state, world, pos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, direction, newState, world, pos, posFrom);
    }

    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return sideCoversSmallSquare(world, pos.down(), Direction.UP);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return null;
    }
}
