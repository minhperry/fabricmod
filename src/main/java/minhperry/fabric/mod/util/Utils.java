package minhperry.fabric.mod.util;

import net.minecraft.client.util.math.Vector3d;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class Utils {

    public static String itemnamespace = "somemod";

    public static Vec3d getEyePos(PlayerEntity player) {
        return new Vec3d(player.getX(), player.getEyeY(), player.getZ());
    }

    public static Vec3d getClientLookVec(PlayerEntity player)
    {
        float f = 0.017453292F;
        float pi = (float)Math.PI;

        float f1 = MathHelper.cos(-player.yaw * f - pi);
        float f2 = MathHelper.sin(-player.yaw * f - pi);
        float f3 = -MathHelper.cos(-player.pitch * f);
        float f4 = MathHelper.sin(-player.pitch * f);

        return new Vec3d(f2 * f3, f4, f1 * f3);
    }

}
