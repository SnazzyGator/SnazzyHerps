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

public class OakBranchBlock extends Block {

    public OakBranchBlock(Properties properties) {super(properties);}

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    protected static final VoxelShape EAST_AABB = Shapes.or(
            Block.box(6.5D, 3D, 4D, 9.5D, 7D, 7D),
            Block.box(6.5D, 0D, 6D, 9.5D, 4D, 9D),
            Block.box(5D, 5D, 7D, 7D, 7D, 14D),
            Block.box(8D, 7D, 4D, 10D, 11D, 6D),
            Block.box(9.75D, 11D, 4.5D, 10.75D, 15D, 5.5D));
    protected static final VoxelShape WEST_AABB = Shapes.or(
            Block.box(6.5D, 3D, 9D, 9.5D, 7D, 12D),
            Block.box(6.5D, 0D, 7D, 9.5D, 4D, 10D),
            Block.box(9D, 5D, 2D, 11D, 7D, 9D),
            Block.box(6D, 7D, 10D, 8D, 11D, 12D),
            Block.box(5.25D, 11D, 10.5D, 6.25D, 15D, 11.5D));
    protected static final VoxelShape SOUTH_AABB = Shapes.or(
            Block.box(9D, 3D, 6.5D, 12D, 7D, 9.5D),
            Block.box(7D, 0D, 6.5D, 10D, 4D, 9.5D),
            Block.box(2D, 5D, 5D, 9D, 7D, 7D),
            Block.box(10D, 7D, 8D, 12D, 11D, 10D),
            Block.box(10.5D, 11D, 9.75D, 11.5D, 15D, 10.75D));
    protected static final VoxelShape NORTH_AABB = Shapes.or(
            Block.box(4D, 3D, 6.5D, 7D, 7D, 9.5D),
            Block.box(6D, 0D, 6.5D, 9D, 4D, 9.5D),
            Block.box(7D, 5D, 9D, 14D, 7D, 11D),
            Block.box(4D, 7D, 6D, 6D, 11D, 8D),
            Block.box(4.5D, 11D, 5.25D, 5.5D, 15D, 6.25D));

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