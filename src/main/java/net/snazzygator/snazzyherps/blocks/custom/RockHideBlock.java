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

public class RockHideBlock extends Block {

    public RockHideBlock(Properties properties) {super(properties);}

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    /*protected static final VoxelShape SHAPE = Shapes.or(
            Block.box(1.0D, 7.0D, 1.0D, 15.0D, 9.0D, 15.0D),
            Block.box(1.0D, 0.0D, 15.0D, 2.0D, 7.0D, 15.0D),
            Block.box(13.0D, 0.0D, 15.0D, 14.0D, 7.0D, 15.0D));

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }*/
    protected static final VoxelShape EAST_AABB = Shapes.or(
            Block.box(1D, 0D, 1D, 15D, 7D, 2D),
            Block.box(1D, 0D, 14D, 15D, 7D, 15D),
            Block.box(1D, 0D, 2D, 2D, 7D, 14D),
            Block.box(1D, 7D, 1D, 15D, 8D, 15D));
    protected static final VoxelShape WEST_AABB = Shapes.or(
            Block.box(1D, 0D, 14D, 15D, 7D, 15D),
            Block.box(1D, 0D, 1D, 15D, 7D, 2D),
            Block.box(14D, 0D, 2D, 15D, 7D, 14D),
            Block.box(1D, 7D, 1D, 15D, 8D, 15D));
    protected static final VoxelShape SOUTH_AABB = Shapes.or(
            Block.box(14D, 0D, 1D, 15D, 7D, 15D),
            Block.box(1D, 0D, 1D, 2D, 7D, 15D),
            Block.box(2D, 0D, 1D, 14D, 7D, 2D),
            Block.box(1D, 7D, 1D, 15D, 8D, 15D));
    protected static final VoxelShape NORTH_AABB = Shapes.or(
            Block.box(1D, 0D, 1D, 2D, 7D, 15D),
            Block.box(14D, 0D, 1D, 15D, 7D, 15D),
            Block.box(2D, 0D, 14D, 14D, 7D, 15D),
            Block.box(1D, 7D, 1D, 15D, 8D, 15D));

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