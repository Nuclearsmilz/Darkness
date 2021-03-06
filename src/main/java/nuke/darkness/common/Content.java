package nuke.darkness.common;

import java.util.*;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.item.Item.*;
import net.minecraft.item.ItemArmor.*;
import net.minecraft.util.*;
import net.minecraft.util.text.*;
import net.minecraftforge.common.util.*;
import net.minecraftforge.fml.common.registry.*;
import nuke.darkness.api.items.*;
import nuke.darkness.client.util.*;
import nuke.darkness.common.blocks.*;
import nuke.darkness.common.items.*;
import nuke.darkness.common.items.armor.*;
import nuke.darkness.common.items.runes.*;
import nuke.darkness.common.world.*;
import nuke.darkness.core.*;

public class Content {
	public static ArrayList<Block> blocks = new ArrayList<Block>();
	public static ArrayList<Item> items = new ArrayList<Item>();
	// public static ArrayList<ItemRune> runes = new ArrayList<ItemRune>();

	public static WorldGenOres world_gen_ores;

	public static ToolMaterial tool_mat_darkrunic, tool_mat_darkerrunic, tool_mat_darkestrunic;
	public static ArmorMaterial armor_mat_darkrunic;
	public static EnumRarity tool_rarity_darkrunic, tool_rarity_darkerrunic, tool_rarity_darkestrunic;

	public static DamageSource damage_shade;

	public static Block block_darkened_web, block_darkened_wool;

	public static Item slate_blank, rune_corrupt;

	public static Item compendium, book_binding, scroll_bag, scroll, darkened_string, black_hole;

	public static Item sword_darkrunic, pickaxe_darkrunic, axe_darkrunic, hoe_darkrunic, shovel_darkrunic, ingot_darkrunic, droplet_darkrunic;

	public static ItemArmor darkrunic_hood, darkrunic_torso, darkrunic_legs;

	public static void init() {
		// Shade (Darkness) Damage
		damage_shade = new DamageSourceShade();

		// Tool Materials
		tool_mat_darkrunic = EnumHelper.addToolMaterial(Darkness.prependModID("darkrunic"), 4, 290, 6.3f, 2.1f, 20);
		armor_mat_darkrunic = EnumHelper.addArmorMaterial(Darkness.prependModID("darkrunic_cloth"), Darkness.prependModID("darkrunic_cloth"), 20, new int[] { 2, 4, 6, 3 }, 20, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0);
		tool_rarity_darkrunic = EnumHelper.addRarity("rare", TextFormatting.DARK_PURPLE, "Rare");

		// Blocks
		blocks.add(block_darkened_web = new BlockDarkenedWeb(Material.WEB, "block_darkened_web", "sword", 1, 1.0F, 1.0F, SoundType.CLOTH, true).setIsFullCube(false).setIsOpaqueCube(false).setLightOpacity(0));
		blocks.add(block_darkened_wool = new BlockDarkenedWool(Material.CLOTH, "block_darkened_wool", "sword", 1, 1.0F, 1.0F, SoundType.CLOTH, true).setIsFullCube(true).setIsOpaqueCube(true).setLightOpacity(16));

		// Items
		items.add(compendium = new ItemCompendium());
		items.add(scroll_bag = new ItemScrollBag());
		items.add(scroll = new ItemScroll());

		items.add(black_hole = new ItemBlackHole());

		items.add(book_binding = new ItemBase("book_binding", true));
		items.add(darkened_string = new ItemBase("darkened_string", true));

		items.add(droplet_darkrunic = new ItemBase("droplet_darkrunic", true));
		items.add(ingot_darkrunic = new ItemBase("ingot_darkrunic", true));
		items.add(sword_darkrunic = new ItemSwordBase(tool_mat_darkrunic, "sword_darkrunic", true));
		items.add(pickaxe_darkrunic = new ItemPickaxeBase(tool_mat_darkrunic, "pickaxe_darkrunic", true));
		items.add(axe_darkrunic = new ItemAxeBase(tool_mat_darkrunic, "axe_darkrunic", true));
		items.add(hoe_darkrunic = new ItemHoeBase(tool_mat_darkrunic, "hoe_darkrunic", true));
		items.add(shovel_darkrunic = new ItemShovelBase(tool_mat_darkrunic, "shovel_darkrunic", true));

		items.add(slate_blank = new ItemBase("slate_blank", true));

		// Runes
		items.add(rune_corrupt = new ItemRuneCorrupt());

		// Armor
		items.add(darkrunic_hood = new ItemDarkRunicHood());
		items.add(darkrunic_torso = new ItemDarkRunicTorso());
		items.add(darkrunic_legs = new ItemDarkRunicLegs());

		// Repair Materials
		tool_mat_darkrunic.setRepairItem(new ItemStack(ingot_darkrunic));
		armor_mat_darkrunic.repairMaterial = new ItemStack(darkened_string, 1);

		world_gen_ores = new WorldGenOres();
		GameRegistry.registerWorldGenerator(world_gen_ores, 1);
	}

	public static void registerRenderer() {

		for (Item i : items) {
			if (i instanceof IModeledObject) {
				((IModeledObject) i).initModel();
			}
		}

		for (Block b : blocks) {
			if (b instanceof IModeledObject) {
				((IModeledObject) b).initModel();
			}
		}
	}
}