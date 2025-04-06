package net.starflight.block;

import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.stardance.core.LocalGrid;

import javax.vecmath.Quat4f;
import javax.vecmath.Vector3d;

public class MagPadBlock extends FacingBlock {
    public MagPadBlock(Settings settings) {
        super(settings);
        // Set default facing direction
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.UP));
    }

    // Override to add the FACING property to the block states
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    // Override to set the facing direction based on player placement
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        // For a more piston-like placement, use this implementation
        Direction direction = ctx.getPlayerLookDirection();

        // If the player is looking almost straight up or down (within 30 degrees of vertical)
        // then place it facing up or down
        if (ctx.getPlayer() != null) {
            float pitch = ctx.getPlayer().getPitch();
            if (pitch > 50) {
                direction = Direction.DOWN; // Looking down
            } else if (pitch < -50) {
                direction = Direction.UP; // Looking up
            }
        }

        return this.getDefaultState().with(FACING, direction);
    }

    // This method is called when a player right-clicks on the block
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        // Prevent execution on client side to avoid duplicate processing
        if (world.isClient) {
            return ActionResult.SUCCESS; // Indicate we've handled this on client side
        }

        // Call your custom method
        activateMagPad(state, world, pos, player);

        // Return SUCCESS to indicate we handled the interaction
        return ActionResult.SUCCESS;
    }

    // Your custom method that gets called when the block is right-clicked
    private void activateMagPad(BlockState state, World world, BlockPos pos, PlayerEntity player) {
        world.setBlockState(pos, Blocks.AIR.getDefaultState());
        LocalGrid grid = new LocalGrid(new Vector3d(pos.getX(),pos.getY(),pos.getZ()), new Quat4f(), (ServerWorld) world, state);
    }
}
