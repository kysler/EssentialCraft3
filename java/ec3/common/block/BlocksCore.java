package ec3.common.block;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import ec3.common.item.ItemBlockElementalCrystal;
import ec3.common.item.ItemBlockFancy;
import ec3.common.item.ItemBlockGeneric;
import ec3.common.item.ItemsCore;
import ec3.common.mod.EssentialCraftCore;
import DummyCore.Blocks.BlocksRegistry;
import DummyCore.Items.ItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import static ec3.utils.cfg.Config.getIdForBlock;
import static ec3.utils.cfg.Config.getIdForItem;

public class BlocksCore {

	public static BlocksCore instance;

	public void loadBlocks() {
		drops = new BlockDrops(Material.cloth).setBlockName("essentialcraft.drops").setBlockTextureName("minecraft:bedrock");
		BlocksRegistry.registerBlock(drops, "Drops", EssentialCraftCore.class, ItemBlockGeneric.class);
		magicPlating = new BlockConnectedTextures(Material.rock).setTexturePath("magicPlating").setHardness(3.0F).setResistance(15.0F).setBlockName("essentialcraft.magicPlatingBlock").setBlockTextureName("essentialcraft:magicPlatingBlock");
		BlocksRegistry.registerBlock(magicPlating, "magicPlating", EssentialCraftCore.class, ItemBlockGeneric.class);
		fortifiedGlass = new BlockConnectedTextures(Material.glass).setTexturePath("fortifiedGlass").setHardness(3.0F).setResistance(15.0F).setLightOpacity(0).setBlockName("essentialcraft.fortifiedGlass").setBlockTextureName("essentialcraft:transparentGlass");
		BlocksRegistry.registerBlock(fortifiedGlass, "fortifiedGlass", EssentialCraftCore.class, ItemBlockGeneric.class);
		ecController = new BlockecController(Material.rock).setHardness(3.0F).setResistance(15.0F).setLightOpacity(0).setBlockName("essentialcraft.ecController").setBlockTextureName("essentialcraft:mrucuecController");
		BlocksRegistry.registerBlock(ecController, "ecController", EssentialCraftCore.class, ItemBlockGeneric.class);
		ecAcceptor = new BlockecAcceptor(Material.rock).setHardness(3.0F).setResistance(15.0F).setLightOpacity(0).setBlockName("essentialcraft.ecAcceptor").setBlockTextureName("essentialcraft:mrucuecMRUAcceptor");
		BlocksRegistry.registerBlock(ecAcceptor, "ecAcceptor", EssentialCraftCore.class, ItemBlockGeneric.class);
		ecBalancer = new BlockecBalancer(Material.rock).setHardness(3.0F).setResistance(15.0F).setLightOpacity(0).setBlockName("essentialcraft.ecBalancer").setBlockTextureName("essentialcraft:mrucuecMRUBalancer");
		BlocksRegistry.registerBlock(ecBalancer, "ecBalancer", EssentialCraftCore.class, ItemBlockGeneric.class);
		ecEjector = new BlockecEjector(Material.rock).setHardness(3.0F).setResistance(15.0F).setLightOpacity(0).setBlockName("essentialcraft.ecEjector").setBlockTextureName("essentialcraft:mrucuecMRUEjector");
		BlocksRegistry.registerBlock(ecEjector, "ecEjector", EssentialCraftCore.class, ItemBlockGeneric.class);
		ecHoldingChamber = new BlockecHoldingChamber(Material.rock).setHardness(3.0F).setResistance(15.0F).setLightOpacity(0).setBlockName("essentialcraft.ecHoldingChamber").setBlockTextureName("essentialcraft:mrucuecMRUHoldingChamber");
		BlocksRegistry.registerBlock(ecHoldingChamber, "ecHoldingChamber", EssentialCraftCore.class, ItemBlockGeneric.class);
		ecStateChecker = new BlockecStateChecker(Material.rock).setHardness(3.0F).setResistance(15.0F).setLightOpacity(0).setBlockName("essentialcraft.ecStateChecker").setBlockTextureName("essentialcraft:mrucuecMRUStateChecker");
		BlocksRegistry.registerBlock(ecStateChecker, "ecStateChecker", EssentialCraftCore.class, ItemBlockGeneric.class);
		ecRedstoneController = new BlockecRedstoneController(Material.rock).setHardness(3.0F).setResistance(15.0F).setLightOpacity(0).setBlockName("essentialcraft.ecRedstoneController").setBlockTextureName("essentialcraft:mrucuecRedstoneController");
		BlocksRegistry.registerBlock(ecRedstoneController, "ecRedstoneController", EssentialCraftCore.class, ItemBlockGeneric.class);
		rayTower = new BlockRayTower().setHardness(1.0F).setResistance(1.0F).setLightOpacity(0).setBlockName("essentialcraft.rayTower").setBlockTextureName("essentialcraft:magicPlatingBlock");
		BlocksRegistry.registerBlock(rayTower, "rayTower", EssentialCraftCore.class, ItemBlockGeneric.class);
		solarPrism = new BlockSolarPrism(Material.rock).setHardness(1.0F).setResistance(1.0F).setLightOpacity(0).setBlockName("essentialcraft.solarPrism").setBlockTextureName("essentialcraft:magicPlatingBlock");
		BlocksRegistry.registerBlock(solarPrism, "solarPrism", EssentialCraftCore.class, ItemBlockGeneric.class);
		sunRayAbsorber = new BlockSunRayAbsorber(Material.rock).setHardness(1.0F).setResistance(1.0F).setLightOpacity(0).setBlockName("essentialcraft.sunRayAbsorber").setBlockTextureName("essentialcraft:magicPlatingBlock");
		BlocksRegistry.registerBlock(sunRayAbsorber, "sunRayAbsorber", EssentialCraftCore.class, ItemBlockGeneric.class);
		coldStone = new BlockColdStone().setHardness(1.0F).setResistance(1.0F).setLightOpacity(0).setBlockName("essentialcraft.coldStone").setBlockTextureName("essentialcraft:coldStone");
		BlocksRegistry.registerBlock(coldStone, "coldStone", EssentialCraftCore.class, ItemBlockGeneric.class);
		String[] corruptionNames = new String[]{"chaos","frozen","shade","magic"};
		coldDistillator = new BlockColdDistillator(Material.rock).setHardness(1.0F).setResistance(1.0F).setLightOpacity(0).setBlockName("essentialcraft.coldDistillator").setBlockTextureName("essentialcraft:magicPlatingBlock");
		BlocksRegistry.registerBlock(coldDistillator, "coldDistillator", EssentialCraftCore.class, ItemBlockGeneric.class);
		naturalFurnace = new BlockFlowerBurner(Material.rock).setHardness(1.0F).setResistance(1.0F).setLightOpacity(0).setBlockName("essentialcraft.naturalFurnace").setBlockTextureName("essentialcraft:magicPlatingBlock");
		BlocksRegistry.registerBlock(naturalFurnace, "naturalFurnace", EssentialCraftCore.class, ItemBlockGeneric.class);
		heatGenerator = new BlockHeatGenerator(Material.rock).setHardness(1.0F).setResistance(1.0F).setLightOpacity(0).setBlockName("essentialcraft.heatGenerator").setBlockTextureName("essentialcraft:magicPlatingBlock");
		BlocksRegistry.registerBlock(heatGenerator, "heatGenerator", EssentialCraftCore.class, ItemBlockGeneric.class);
		enderGenerator = new BlockEnderGenerator(Material.rock).setHardness(1.0F).setResistance(1.0F).setLightOpacity(0).setBlockName("essentialcraft.enderGenerator").setBlockTextureName("essentialcraft:magicPlatingBlock");
		BlocksRegistry.registerBlock(enderGenerator, "enderGenerator", EssentialCraftCore.class, ItemBlockGeneric.class);
		for(int i = 0; i < 4; ++i)
		{
			lightCorruption[i] = new BlockCorruption_Light(Material.circuits).setHardness(1.0F).setResistance(1.0F).setLightOpacity(0).setBlockName("essentialcraft.corruption."+corruptionNames[i]).setBlockTextureName("essentialcraft:"+corruptionNames[i]);
			BlocksRegistry.registerBlock(lightCorruption[i], corruptionNames[i], EssentialCraftCore.class, ItemBlockGeneric.class);
		}
		moonWell = new BlockMoonWell(Material.rock).setHardness(1.0F).setResistance(1.0F).setLightOpacity(0).setBlockName("essentialcraft.moonWell").setBlockTextureName("essentialcraft:magicPlatingBlock");
		BlocksRegistry.registerBlock(moonWell, "moonWell", EssentialCraftCore.class, ItemBlockGeneric.class);
		magicianTable = registerBlockSimple(BlockMagicianTable.class,Material.rock,magicianTable,"magicianTable","magicPlatingBlock",1,1,0);
		fortifiedStone = new BlockConnectedTextures(Material.rock).setTexturePath("fortifiedStone").setHardness(3.0F).setResistance(15.0F).setBlockName("essentialcraft.fortifiedStone").setBlockTextureName("essentialcraft:fortifiedStone");
		BlocksRegistry.registerBlock(fortifiedStone, "fortifiedStone", EssentialCraftCore.class, ItemBlockGeneric.class);
		magicalQuarry = registerBlockSimple(BlockMagicalQuarry.class,Material.rock,magicalQuarry,"magicalQuarry","magicPlatingBlock",1,1,0);
		monsterClinger = registerBlockSimple(BlockMonsterHolder.class,Material.rock,monsterClinger,"monsterClinger","magicPlatingBlock",1,1,0);
		potionSpreader = registerBlockSimple(BlockPotionSpreader.class,Material.rock,potionSpreader,"potionSpreader","magicPlatingBlock",1,1,0);
		magicalEnchanter = registerBlockSimple(BlockMagicalEnchanter.class,Material.rock,magicalEnchanter,"magicalEnchanter","magicPlatingBlock",1,1,0);
		monsterHarvester = registerBlockSimple(BlockMonsterHarvester.class,Material.rock,monsterHarvester,"monsterHarvester","magicPlatingBlock",1,1,0);
		magicalRepairer = registerBlockSimple(BlockMagicalRepairer.class,Material.rock,magicalRepairer,"magicalRepairer","magicPlatingBlock",1,1,0);
		matrixAbsorber = registerBlockSimple(BlockMatrixAbsorber.class,Material.rock,matrixAbsorber,"matrixAbsorber","magicPlatingBlock",1,1,0);
		radiatingChamber = registerBlockSimple(BlockRadiatingChamber.class,Material.rock,radiatingChamber,"radiatingChamber","magicPlatingBlock",1,1,0);
		magmaticSmeltery = registerBlockSimple(BlockMagmaticSmeltery.class,Material.rock,magmaticSmeltery,"magmaticSmeltery","magicPlatingBlock",1,1,0);
		magicalJukebox = registerBlockSimple(BlockMagicalJukebox.class,Material.rock,magicalJukebox,"magicalJukebox","magicPlatingBlock",1,1,0);
		elementalCrystal = new BlockElementalCrystal(Material.rock).setHardness(3.0F).setResistance(15.0F).setBlockName("essentialcraft.elementalCrystal").setBlockTextureName("essentialcraft:fortifiedStone");
		BlocksRegistry.registerBlock(elementalCrystal, "elementalCrystal", EssentialCraftCore.class, ItemBlockElementalCrystal.class);
		crystalFormer = registerBlockSimple(BlockCrystalFormer.class,Material.rock,crystalFormer,"crystalFormer","magicPlatingBlock",1,1,0);
		crystalController = registerBlockSimple(BlockCrystalController.class,Material.rock,crystalController,"crystalController","magicPlatingBlock",1,1,0);
		crystalExtractor = registerBlockSimple(BlockCrystalExtractor.class,Material.rock,crystalExtractor,"crystalExtractor","magicPlatingBlock",1,1,0);
		chargingChamber = registerBlockSimple(BlockChargingChamber.class,Material.rock,chargingChamber,"chargingChamber","magicPlatingBlock",1,1,0);
		voidStone = new BlockConnectedTextures(Material.rock).setTexturePath("voidStone").setHardness(8.0F).setResistance(150.0F).setBlockName("essentialcraft.voidStone").setBlockTextureName("essentialcraft:voidStone");
		BlocksRegistry.registerBlock(voidStone, "voidStone", EssentialCraftCore.class, ItemBlockGeneric.class);
		voidGlass = new BlockConnectedTextures(Material.glass).setTexturePath("voidGlass").setHardness(8.0F).setResistance(150.0F).setBlockName("essentialcraft.voidGlass").setBlockTextureName("essentialcraft:voidGlass");
		BlocksRegistry.registerBlock(voidGlass, "voidGlass", EssentialCraftCore.class, ItemBlockGeneric.class);
		
		concrete = registerBlockSimple(Block.class,Material.rock,concrete,"concrete","firstWorld/burnedConcrete",1,1,0);
		cacti = registerBlockSimple(BlockDreadCacti.class,Material.cactus,cacti,"cacti","firstWorld/cactus",1,1,0);
		dreadDirt = registerBlockSimple(Block.class,Material.ground,dreadDirt,"dreadDirt","firstWorld/dreadDirt",1,1,0);
		dreadDirt.setStepSound(Block.soundTypeGravel);
		flowerGreen = registerBlockSimple(BlockModFlower.class,Material.grass,flowerGreen,"flowerGreen","firstWorld/flower_green",1,1,0);
		fruit = registerBlockSimple(BlockMagicalFruit.class,Material.grass,fruit,"fruit","firstWorld/magicalFruit",1,1,0);
		root = registerBlockSimple(Block.class,Material.wood,root,"root","firstWorld/root",1,1,0);
		tallGrass = registerBlockSimple(BlockModTallGrass.class,Material.grass,tallGrass,"tallGrass","firstWorld/tallGrass",1,1,0);
		
		magicalTeleporter = registerBlockSimple(BlockMagicalTeleporter.class,Material.rock,magicalTeleporter,"magicalTeleporter","magicPlatingBlock",1,1,0);
		magicalFurnace = registerBlockSimple(BlockMagicalFurnace.class,Material.rock,magicalFurnace,"magicalFurnace","magicPlatingBlock",1,1,0);
		emberForge = registerBlockSimple(BlockEmberForge.class,Material.rock,emberForge,"emberForge","magicPlatingBlock",1,1,0);
		levitator = registerBlockSimple(BlockMRULevitator.class,Material.rock,levitator,"levitator","fortifiedStone",1,100,0);
		spreader = registerBlockSimple(BlockMRUSpreader.class,Material.rock,spreader,"spreader","fortifiedStone",1,100,0);
		
		fence[0] = new BlockModFence(Material.rock,"essentialcraft:voidStone").setHardness(1.0F).setResistance(150.0F).setBlockName("essentialcraft.voidFence").setBlockTextureName("essentialcraft:voidStone");
		BlocksRegistry.registerBlock(fence[0], "voidFence", EssentialCraftCore.class, ItemBlockGeneric.class);
		fence[1] = new BlockModFence(Material.rock,"essentialcraft:magicPlatingBlock").setHardness(1.0F).setResistance(150.0F).setBlockName("essentialcraft.magicFence").setBlockTextureName("essentialcraft:magicPlatingBlock");
		BlocksRegistry.registerBlock(fence[1], "magicFence", EssentialCraftCore.class, ItemBlockGeneric.class);
		fence[2] = new BlockModFence(Material.rock,"essentialcraft:fortifiedStone").setHardness(1.0F).setResistance(150.0F).setBlockName("essentialcraft.fFence").setBlockTextureName("essentialcraft:fortifiedStone");
		BlocksRegistry.registerBlock(fence[2], "fFence", EssentialCraftCore.class, ItemBlockGeneric.class);
		
		torch = registerBlockSimple(BlockMagicLight.class,Material.circuits,torch,"torch","firstWorld/root",0,0,1);
		torch.setLightLevel(1.0F);
		
		blockPale = registerBlockSimple(Block.class,Material.rock,blockPale,"blockPale","paleBlock",2,100,0);
		blockPale.setStepSound(Block.soundTypeMetal);
		platingPale = new BlockConnectedTextures(Material.rock).setTexturePath("palePlating").setHardness(3.0F).setResistance(100.0F).setBlockName("essentialcraft.platingPale").setBlockTextureName("essentialcraft:palePlatingBlock");
		BlocksRegistry.registerBlock(platingPale, "platingPale", EssentialCraftCore.class, ItemBlockGeneric.class);
		mruCoilHardener = registerBlockSimple(BlockMRUCoil_Hardener.class,Material.rock,mruCoilHardener,"mruCoilHardener","fortifiedStone",1,100,0);
		mruCoil = registerBlockSimple(BlockMRUCoil_Coil.class,Material.rock,mruCoil,"mruCoil","fortifiedStone",1,100,0);
		corruptionCleaner = registerBlockSimple(BlockCorruptionCleaner.class,Material.rock,corruptionCleaner,"corruptionCleaner","fortifiedStone",1,100,0);
		reactorSupport = registerBlockSimple(BlockReactorSupport.class,Material.rock,reactorSupport,"reactorSupport","fortifiedStone",1,10,0);
		reactor = registerBlockSimple(BlockMRUReactor.class,Material.rock,reactor,"reactor","fortifiedStone",1,10,0);
		air = registerBlockSimple(Block.class,Material.rock,air,"air","glass",-1,-1,0);
		air.setBlockName("air");
		air.setBlockTextureName("cauldron_top");
		minEjector = registerBlockSimple(BlockMINEjector.class,Material.rock,minEjector,"minEjector","fortifiedStone",1,1,0);
		minInjector = registerBlockSimple(BlockMINInjector.class,Material.rock,minInjector,"minInjector","fortifiedStone",1,1,0);
		mim = registerBlockSimple(BlockMIM.class,Material.rock,mim,"mim","voidStone",1,1,0);
		//Its 8ack!
		darknessObelisk = registerBlockSimple(BlockDarknessObelisk.class,Material.rock,darknessObelisk,"darknessObelisk","voidStone",1,1,0);
		
		ultraHeatGen = registerBlockSimple(BlockUltraHeatGenerator.class,Material.rock,ultraHeatGen,"ultraHeatGen","voidStone",1,1,0);
		ultraFlowerBurner = registerBlockSimple(BlockUltraFlowerBurner.class,Material.rock,ultraFlowerBurner,"ultraFlowerBurner","voidStone",1,1,0);
		
		assembler = registerBlockSimple(BlockMagicalAssemblerCore.class,Material.rock,assembler,"assembler","fortifiedStone",1,1,0);
		magicalMirror = registerBlockSimple(BlockMagicalMirror.class,Material.rock,magicalMirror,"magicalMirror","magicPlatingBlock",1,1,0);
		magicalDisplay = registerBlockSimple(BlockMagicalDisplay.class,Material.rock,magicalDisplay,"magicalDisplay","magicalDisplay",1,1,0);
		portal = registerBlockSimple(BlockPortal.class,Material.rock,portal,"portal","portal",-1,-1,1);
	}
	
	public static void postInitLoad()
	{
		
		
		createFancyBlock(Material.rock,"mru","mru",1,100,new ItemStack(ItemsCore.magicalSlag));
		createFancyBlock(Material.rock,"concrete","concrete",1,5,new ItemStack(concrete));
		createFancyBlock(Material.rock,"fortifiedStone","fortifiedStone",1.5F,8,new ItemStack(fortifiedStone));
		createFancyBlock(Material.glass,"coldStone","coldStone",0.7F,1,new ItemStack(coldStone));
		createFancyBlock(Material.rock,"magicPlating","magicPlating",2F,8,new ItemStack(magicPlating));
		createFancyBlock(Material.rock,"palePlating","palePlating",2F,8,new ItemStack(platingPale));
		createFancyBlock(Material.rock,"voidStone","voidStone",3F,28,new ItemStack(voidStone));
	}
	
	public static Block registerBlockSimple(Class<? extends Block> c,Material m,Block b, String name, String texture, float hardness, float resistance, int opacity)
	{
		try
		{
			b = c.newInstance().setBlockName("essentialcraft."+name).setBlockTextureName("essentialcraft:"+texture).setResistance(resistance).setHardness(hardness).setLightOpacity(opacity);
			BlocksRegistry.registerBlock(b, name, EssentialCraftCore.class, ItemBlockGeneric.class);
			return b;
		}
		catch (Exception e) {
			try
			{
				if(c == Block.class)
				{
					b = new ModBlock(m).setBlockName("essentialcraft:"+name).setBlockTextureName("essentialcraft:"+texture).setResistance(resistance).setHardness(hardness).setLightOpacity(opacity);
					BlocksRegistry.registerBlock(b, name, EssentialCraftCore.class, ItemBlockGeneric.class);
					return b;
				}else
				{
					c.getConstructor(Material.class).setAccessible(true);
					b = c.getConstructor(Material.class).newInstance(m).setBlockName("essentialcraft:"+name).setBlockTextureName("essentialcraft:"+texture).setResistance(resistance).setHardness(hardness).setLightOpacity(opacity);
					BlocksRegistry.registerBlock(b, name, EssentialCraftCore.class, ItemBlockGeneric.class);
					return b;
				}
			}
			catch (Exception e1) {
				e1.printStackTrace();
				return null;
			}
		}
	}
	
	public static void createFancyBlock(Material m, String name, String texture, float hardness, float resistance, ItemStack createdFrom)
	{
		Block fancy = new BlockFancy(m).setBlockName("essentialcraft.fancyBlock."+name).setBlockTextureName("essentialcraft:fancyBlocks/"+texture).setResistance(resistance).setHardness(hardness);
		BlocksRegistry.registerBlock(fancy, "fancyBlock."+name, EssentialCraftCore.class, ItemBlockFancy.class);
		fancyBlocks.add(fancy);
		
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(fancy,4,1), new Object[]{
			createdFrom,new ItemStack(ItemsCore.magicalChisel,1,OreDictionary.WILDCARD_VALUE)
		}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(fancy,4,2), new Object[]{
			"## ",
			"## ",
			"   ",
			'#',new ItemStack(fancy,1,1)
		}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(fancy,4,7), new Object[]{
			" # ",
			"# #",
			" # ",
			'#',new ItemStack(fancy,1,2)
		}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(fancy,4,0), new Object[]{
			"# #",
			"   ",
			"# #",
			'#',new ItemStack(fancy,1,1)
		}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(fancy,9,3), new Object[]{
			"###",
			"###",
			"###",
			'#',new ItemStack(fancy,1,1)
		}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(fancy,8,4), new Object[]{
			"###",
			"# #",
			"###",
			'#',new ItemStack(fancy,1,2)
		}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(fancy,4,5), new Object[]{
			"## ",
			"## ",
			"   ",
			'#',new ItemStack(fancy,1,7)
		}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(fancy,9,6), new Object[]{
			"###",
			"@$@",
			"###",
			'#',new ItemStack(fancy,1,1),
			'@',new ItemStack(fancy,1,3),
			'$',new ItemStack(fancy,1,0)
		}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(fancy,4,8), new Object[]{
			" # ",
			"#@#",
			" # ",
			'#',new ItemStack(fancy,1,0),
			'@',new ItemStack(fancy,1,3)
		}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(fancy,8,9), new Object[]{
			"###",
			"#@#",
			"###",
			'#',new ItemStack(fancy,1,8),
			'@',new ItemStack(Items.redstone,1,0)
		}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(fancy,8,10), new Object[]{
			"###",
			"#@#",
			"###",
			'#',new ItemStack(fancy,1,1),
			'@',new ItemStack(ItemsCore.genericItem,1,3)
		}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(fancy,8,11), new Object[]{
			"###",
			"#@#",
			"###",
			'#',new ItemStack(fancy,1,1),
			'@',new ItemStack(ItemsCore.genericItem,1,12)
		}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(fancy,8,12), new Object[]{
			"###",
			"#@#",
			"###",
			'#',new ItemStack(fancy,1,1),
			'@',new ItemStack(Items.iron_ingot)
		}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(fancy,8,13), new Object[]{
			"###",
			"#@#",
			"###",
			'#',new ItemStack(fancy,1,1),
			'@',new ItemStack(Items.leather)
		}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(fancy,4,14), new Object[]{
			"## ",
			"## ",
			"   ",
			'#',new ItemStack(fancy,1,13)
		}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(fancy,4,15), new Object[]{
			"## ",
			"## ",
			"   ",
			'#',new ItemStack(fancy,1,12)
		}));
	}
	
	
	public static void createFancyBlock(Block b, String name, int meta)
	{
		Block fancy = new BlockFancy(b,meta).setBlockName("essentialcraft.fancyBlock."+name).setResistance(1).setHardness(1);
		BlocksRegistry.registerBlock(fancy, "fancyBlock."+name, EssentialCraftCore.class, ItemBlockFancy.class);
		fancyBlocks.add(fancy);
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(fancy,4,1), new Object[]{
			new ItemStack(b,1,meta),new ItemStack(ItemsCore.magicalChisel,1,OreDictionary.WILDCARD_VALUE)
		}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(fancy,4,2), new Object[]{
			"## ",
			"## ",
			"   ",
			'#',new ItemStack(fancy,1,1)
		}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(fancy,4,7), new Object[]{
			" # ",
			"# #",
			" # ",
			'#',new ItemStack(fancy,1,2)
		}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(fancy,4,8), new Object[]{
			" # ",
			"#@#",
			" # ",
			'#',new ItemStack(fancy,1,0),
			'@',new ItemStack(fancy,1,3)
		}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(fancy,4,0), new Object[]{
			"# #",
			"   ",
			"# #",
			'#',new ItemStack(fancy,1,1)
		}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(fancy,9,3), new Object[]{
			"###",
			"###",
			"###",
			'#',new ItemStack(fancy,1,1)
		}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(fancy,8,4), new Object[]{
			"###",
			"# #",
			"###",
			'#',new ItemStack(fancy,1,2)
		}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(fancy,4,5), new Object[]{
			"## ",
			"## ",
			"   ",
			'#',new ItemStack(fancy,1,7)
		}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(fancy,9,6), new Object[]{
			"###",
			"@$@",
			"###",
			'#',new ItemStack(fancy,1,1),
			'@',new ItemStack(fancy,1,3),
			'$',new ItemStack(fancy,1,0)
		}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(fancy,8,9), new Object[]{
			"###",
			"#@#",
			"###",
			'#',new ItemStack(fancy,1,8),
			'@',new ItemStack(Items.redstone,1,0)
		}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(fancy,8,10), new Object[]{
			"###",
			"#@#",
			"###",
			'#',new ItemStack(fancy,1,1),
			'@',new ItemStack(ItemsCore.genericItem,1,3)
		}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(fancy,8,11), new Object[]{
			"###",
			"#@#",
			"###",
			'#',new ItemStack(fancy,1,1),
			'@',new ItemStack(ItemsCore.genericItem,1,12)
		}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(fancy,8,12), new Object[]{
			"###",
			"#@#",
			"###",
			'#',new ItemStack(fancy,1,1),
			'@',new ItemStack(Items.iron_ingot)
		}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(fancy,8,13), new Object[]{
			"###",
			"#@#",
			"###",
			'#',new ItemStack(fancy,1,1),
			'@',new ItemStack(Items.leather)
		}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(fancy,4,14), new Object[]{
			"## ",
			"## ",
			"   ",
			'#',new ItemStack(fancy,1,13)
		}));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(fancy,4,15), new Object[]{
			"## ",
			"## ",
			"   ",
			'#',new ItemStack(fancy,1,12)
		}));
	}
	
	
	public static Block drops;
	public static Block magicPlating;
	public static Block fortifiedGlass;
	public static Block ecController;
	public static Block ecAcceptor;
	public static Block ecBalancer;
	public static Block ecEjector;
	public static Block ecHoldingChamber;
	public static Block ecStateChecker;
	public static Block ecRedstoneController;
	public static Block rayTower;
	public static Block moonWell;
	public static Block solarPrism;
	public static Block sunRayAbsorber;
	public static Block coldStone;
	public static Block coldDistillator;
	public static Block naturalFurnace;
	public static Block heatGenerator;
	public static Block enderGenerator;
	public static Block magicianTable;
	public static Block fortifiedStone;
	public static Block magicalQuarry;
	public static Block monsterClinger;
	public static Block potionSpreader;
	public static Block magicalEnchanter;
	public static Block monsterHarvester;
	public static Block magicalRepairer;
	public static Block matrixAbsorber;
	public static Block radiatingChamber;
	public static Block magmaticSmeltery;
	public static Block magicalJukebox;
	public static Block elementalCrystal;
	public static Block crystalFormer;
	public static Block crystalController;
	public static Block crystalExtractor;
	public static Block chargingChamber;
	public static Block voidStone;
	public static Block voidGlass;
	
	public static Block concrete;
	public static Block cacti;
	public static Block dreadDirt;
	public static Block flowerGreen;
	public static Block fruit;
	public static Block root;
	public static Block tallGrass;
	public static Block thorns;
	
	public static Block magicalTeleporter;
	public static Block magicalFurnace;
	public static Block emberForge;
	
	public static Block levitator;
	public static Block spreader;
	public static Block[] fence = new Block[3];
	public static Block torch;
	
	public static Block blockPale;
	
	public static Block platingPale;
	public static Block mruCoilHardener;
	public static Block mruCoil;
	public static Block corruptionCleaner;
	public static Block reactorSupport;
	public static Block reactor;
	
	public static Block air;
	
	public static Block minEjector;
	public static Block minInjector;
	public static Block mim;
	public static Block darknessObelisk;
	public static Block ultraHeatGen;
	public static Block ultraFlowerBurner;
	public static Block assembler;
	public static Block magicalMirror;
	public static Block magicalDisplay;
	public static Block portal;
	
	public static List<Block> fancyBlocks = new ArrayList<Block>();
	
	public static Block[] lightCorruption = new Block[4];
}
