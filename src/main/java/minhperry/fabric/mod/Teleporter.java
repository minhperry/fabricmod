package minhperry.fabric.mod;

import minhperry.fabric.mod.util.Utils;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Teleporter extends Item {
    public Teleporter(Settings settings) {
        super(settings);
    }

    private final int teleportDistance = 5;

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {

        Vec3d playerEye = Utils.getEyePos(player);
        Vec3d facing = player.getRotationVector();
        Vec3d endPos = playerEye.add(facing.multiply(teleportDistance));
        if (world.isAir(new BlockPos(endPos)) && endPos.getY() <= 512) {
            player.teleport(endPos.getX(), endPos.getY(), endPos.getZ());
            player.playSound(SoundEvents.ENTITY_ENDERMAN_TELEPORT, 0.85f, 1.0f);
        }
        else {
            player.sendMessage(new TranslatableText("message.somemod.cannotTeleportThere").formatted(Formatting.RED), true);
        }
        return TypedActionResult.success(player.getStackInHand(hand));
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("Teleports you §a" + teleportDistance + " §7blocks ahead.").formatted(Formatting.GRAY) );
        tooltip.add(new TranslatableText(" "));
    }

}
