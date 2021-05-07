package minhperry.fabric.mod;

import net.fabricmc.api.ModInitializer;
import minhperry.fabric.mod.util.Utils;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class SomeMod implements ModInitializer {

	public static final SweetAxe SWEET_AXE = new SweetAxe(new FabricItemSettings().group(ItemGroup.TOOLS).maxDamage(180).rarity(Rarity.COMMON));

	public static final Teleporter TELEPORTER = new Teleporter(new FabricItemSettings().group(ItemGroup.TRANSPORTATION).rarity(Rarity.RARE).maxCount(1));

	public static final ItemGroup SOMEMODPLUS = FabricItemGroupBuilder.create(
			new Identifier(Utils.itemnamespace, "somemoditems"))
			.icon(() -> new ItemStack(SWEET_AXE))
			.appendItems(stack -> {
				stack.add(new ItemStack(SWEET_AXE));
				stack.add(new ItemStack(Items.AIR));
				stack.add(new ItemStack(Blocks.BARRIER));
				stack.add(new ItemStack(Blocks.SPAWNER));
				stack.add(new ItemStack(TELEPORTER));
			})
			.build();

	@Override
	public void onInitialize() {
		Registry.register(Registry.ITEM, new Identifier(Utils.itemnamespace, "sweet_axe"), SWEET_AXE);
		Registry.register(Registry.ITEM, new Identifier(Utils.itemnamespace, "teleporter"), TELEPORTER);
	}
}
