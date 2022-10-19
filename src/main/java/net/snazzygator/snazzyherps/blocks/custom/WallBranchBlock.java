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

public class WallBranchBlock extends Block {

    public WallBranchBlock(Properties properties) {super(properties);}

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
            Block.box(0D, 6.5D, 6.5D, 7D, 9.5D, 9.5D),
            Block.box(7D, 8.5D, 7D, 14D, 10.5D, 9D),
            Block.box(2D, 7D, 4.5D, 5D, 9D, 6.5D),
            Block.box(5D, 7D, 2.5D, 8D, 9D, 4.5D));
    protected static final VoxelShape WEST_AABB = Shapes.or(
            Block.box(9D, 6.5D, 6.5D, 16D, 9.5D, 9.5D),
            Block.box(2D, 8.5D, 7D, 9D, 10.5D, 9D),
            Block.box(11D, 7D, 9.5D, 14D, 9D, 11.5D),
            Block.box(8D, 7D, 11.5D, 11D, 9D, 13.5D));
    protected static final VoxelShape SOUTH_AABB = Shapes.or(
            Block.box(6.5D, 6.5D, 0D, 9.5D, 9.5D, 7D),
            Block.box(7D, 8.5D, 7D, 9D, 10.5D, 14D),
            Block.box(9.5D, 7D, 2D, 11.5D, 9D, 5D),
            Block.box(11.5D, 7D, 5D, 13.5D, 9D, 8D));
    protected static final VoxelShape NORTH_AABB = Shapes.or(
            Block.box(6.5D, 6.5D, 9D, 9.5D, 9.5D, 16D),
            Block.box(7D, 8.5D, 2D, 9D, 10.5D, 9D),
            Block.box(4.5D, 7D, 11D, 6.5D, 9D, 14D),
            Block.box(2.5D, 7D, 8D, 4.5D, 9D, 11D));

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