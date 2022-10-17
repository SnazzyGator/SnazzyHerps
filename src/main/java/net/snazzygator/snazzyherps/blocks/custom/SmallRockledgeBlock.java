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

public class SmallRockledgeBlock extends Block {

    public SmallRockledgeBlock(Properties properties) {super(properties);}

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    protected static final VoxelShape EAST_AABB = Shapes.or(
            Block.box(0D, 7D, 4D, 5D, 9D, 12D));
    protected static final VoxelShape WEST_AABB = Shapes.or(
            Block.box(11D, 7D, 4D, 16D, 9D, 12D));
    protected static final VoxelShape SOUTH_AABB = Shapes.or(
            Block.box(4D, 7D, 0D, 12D, 9D, 5D));
    protected static final VoxelShape NORTH_AABB = Shapes.or(
            Block.box(4D, 7D, 11D, 12D, 9D, 16D));

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