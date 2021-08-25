package kistras.mods.testmod;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.swing.text.html.parser.Entity;

public class theblockofcocks extends Block {

    public theblockofcocks(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            player.sendMessage(new LiteralText("Cocks everywhere!"), false);
        }
        ChickenEntity chick = new ChickenEntity(EntityType.CHICKEN, world);
        chick.setPos(pos.getX(), pos.getY() + 1.0F, pos.getZ());
        world.spawnEntity(chick);
        world.breakBlock(pos, false);

        return ActionResult.SUCCESS;
    }
}
