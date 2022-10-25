package net.snazzygator.snazzyherps.blocks.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class HeatRockBlock extends Block {

    public HeatRockBlock(Properties properties) {super(properties);}

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    protected static final VoxelShape EAST_AABB = Shapes.or(
            Block.box(4D, 1D, 4D, 12D, 3D, 12D),
            Block.box(2D, 0D, 2D, 14D, 1D, 14D),
            Block.box(7D, 1D, 2D, 11D, 2D, 4D),
            Block.box(5D, 1D, 12D, 9D, 2D, 14D));
    protected static final VoxelShape WEST_AABB = Shapes.or(
            Block.box(4D, 1D, 4D, 12D, 3D, 12D),
            Block.box(2D, 0D, 2D, 14D, 1D, 14D),
            Block.box(5D, 1D, 12D, 9D, 2D, 14D),
            Block.box(7D, 1D, 2D, 11D, 2D, 4D));
    protected static final VoxelShape SOUTH_AABB = Shapes.or(
            Block.box(4D, 1D, 4D, 12D, 3D, 12D),
            Block.box(2D, 0D, 2D, 14D, 1D, 14D),
            Block.box(12D, 1D, 7D, 14D, 2D, 11D),
            Block.box(2D, 1D, 5D, 4D, 2D, 9D));
    protected static final VoxelShape NORTH_AABB = Shapes.or(
            Block.box(4D, 1D, 4D, 12D, 3D, 12D),
            Block.box(2D, 0D, 2D, 14D, 1D, 14D),
            Block.box(2D, 1D, 5D, 4D, 2D, 9D),
            Block.box(12D, 1D, 7D, 14D, 2D, 11D));

    @Override
    public VoxelShape getShape(BlockState value, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        switch((Direction)value.getValue(FACING)) {
            case NORTH:
            default:
                return NORTH_AABB;
            case SOUTH:
                return SOUTH_AABB;
            case WEST:
                return WEST_AABB;
            case EAST:
                return EAST_AABB;
        }
    }

    /**FACING**/
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }
}