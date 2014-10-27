package ec3.common.block;

import java.lang.reflect.InvocationTargetException;

import ec3.common.item.ItemBlockElementalCrystal;
import ec3.common.item.ItemBlockGeneric;
import ec3.common.mod.EssentialCraftCore;
import DummyCore.Blocks.BlocksRegistry;
import DummyCore.Items.ItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
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
	
	public static Block[] lightCorruption = new Block[4];
}
