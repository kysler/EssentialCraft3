package ec3.network.proxy;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.util.List;

import org.lwjgl.input.Keyboard;

import DummyCore.Client.MainMenuRegistry;
import DummyCore.Utils.DataStorage;
import DummyCore.Utils.DummyData;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.model.ModelSlime;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.TempCategory;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ec3.client.gui.GuiChargingChamber;
import ec3.client.gui.GuiColdDistillator;
import ec3.client.gui.GuiCrystalController;
import ec3.client.gui.GuiCrystalExtractor;
import ec3.client.gui.GuiCrystalFormer;
import ec3.client.gui.GuiEnderGenerator;
import ec3.client.gui.GuiFlowerBurner;
import ec3.client.gui.GuiHeatGenerator;
import ec3.client.gui.GuiMRUAcceptor;
import ec3.client.gui.GuiMRUInfo;
import ec3.client.gui.GuiMagicalEnchanter;
import ec3.client.gui.GuiMagicalFurnace;
import ec3.client.gui.GuiMagicalJukebox;
import ec3.client.gui.GuiMagicalQuarry;
import ec3.client.gui.GuiMagicalRepairer;
import ec3.client.gui.GuiMagicalTeleporter;
import ec3.client.gui.GuiMagicianTable;
import ec3.client.gui.GuiMagmaticSmeltery;
import ec3.client.gui.GuiMainMenuEC3;
import ec3.client.gui.GuiMatrixAbsorber;
import ec3.client.gui.GuiMonsterHarvester;
import ec3.client.gui.GuiMonsterHolder;
import ec3.client.gui.GuiMoonWell;
import ec3.client.gui.GuiPotionSpreader;
import ec3.client.gui.GuiRadiatingChamber;
import ec3.client.gui.GuiRayTower;
import ec3.client.gui.GuiSunRayAbsorber;
import ec3.client.model.ModelArmorEC3;
import ec3.client.regular.EntityCSpellFX;
import ec3.client.regular.EntityMRUFX;
import ec3.client.regular.RenderMRUArrow;
import ec3.client.render.ArmorRenderer;
import ec3.client.render.ClientRenderHandler;
import ec3.client.render.RenderBlocksECIII;
import ec3.client.render.RenderChargingChamber;
import ec3.client.render.RenderCloudsFirstWorld;
import ec3.client.render.RenderColdDistillator;
import ec3.client.render.RenderCrystalController;
import ec3.client.render.RenderCrystalExtractor;
import ec3.client.render.RenderCrystalFormer;
import ec3.client.render.RenderElementalCrystal;
import ec3.client.render.RenderElementalCrystalAsItem;
import ec3.client.render.RenderEnderGenerator;
import ec3.client.render.RenderFlowerBurner;
import ec3.client.render.RenderHandlerEC3;
import ec3.client.render.RenderHeatGenerator;
import ec3.client.render.RenderMRULink;
import ec3.client.render.RenderMRUPresence;
import ec3.client.render.RenderMagicalEnchanter;
import ec3.client.render.RenderMagicalJukebox;
import ec3.client.render.RenderMagicalQuarry;
import ec3.client.render.RenderMagicalRepairer;
import ec3.client.render.RenderMagicianTable;
import ec3.client.render.RenderMagmaticSmelter;
import ec3.client.render.RenderMatrixAbsorber;
import ec3.client.render.RenderMonsterHarvester;
import ec3.client.render.RenderMonsterHolder;
import ec3.client.render.RenderPotionSpreader;
import ec3.client.render.RenderRadiatingChamber;
import ec3.client.render.RenderRayTower;
import ec3.client.render.RenderSkyFirstWorld;
import ec3.client.render.RenderSolarBeam;
import ec3.client.render.RenderSolarPrism;
import ec3.client.render.RenderSunRayAbsorber;
import ec3.client.render.RenderWindMage;
import ec3.common.block.BlocksCore;
import ec3.common.entity.EntityMRUArrow;
import ec3.common.entity.EntityMRUPresence;
import ec3.common.entity.EntitySolarBeam;
import ec3.common.entity.EntityWindMage;
import ec3.common.inventory.ContainerChargingChamber;
import ec3.common.inventory.ContainerColdDistillator;
import ec3.common.inventory.ContainerCrystalController;
import ec3.common.inventory.ContainerCrystalExtractor;
import ec3.common.inventory.ContainerCrystalFormer;
import ec3.common.inventory.ContainerEnderGenerator;
import ec3.common.inventory.ContainerFlowerBurner;
import ec3.common.inventory.ContainerHeatGenerator;
import ec3.common.inventory.ContainerMRUAcceptor;
import ec3.common.inventory.ContainerMRUInfo;
import ec3.common.inventory.ContainerMagicalEnchanter;
import ec3.common.inventory.ContainerMagicalFurnace;
import ec3.common.inventory.ContainerMagicalJukebox;
import ec3.common.inventory.ContainerMagicalQuarry;
import ec3.common.inventory.ContainerMagicalRepairer;
import ec3.common.inventory.ContainerMagicalTeleporter;
import ec3.common.inventory.ContainerMagicianTable;
import ec3.common.inventory.ContainerMagmaticSmeltery;
import ec3.common.inventory.ContainerMatrixAbsorber;
import ec3.common.inventory.ContainerMonsterHarvester;
import ec3.common.inventory.ContainerMonsterHolder;
import ec3.common.inventory.ContainerMoonWell;
import ec3.common.inventory.ContainerPotionSpreader;
import ec3.common.inventory.ContainerRadiatingChamber;
import ec3.common.inventory.ContainerRayTower;
import ec3.common.inventory.ContainerSunRayAbsorber;
import ec3.common.item.ItemSecret;
import ec3.common.item.ItemsCore;
import ec3.common.tile.TileChargingChamber;
import ec3.common.tile.TileColdDistillator;
import ec3.common.tile.TileCrystalController;
import ec3.common.tile.TileCrystalExtractor;
import ec3.common.tile.TileCrystalFormer;
import ec3.common.tile.TileElementalCrystal;
import ec3.common.tile.TileEnderGenerator;
import ec3.common.tile.TileFlowerBurner;
import ec3.common.tile.TileHeatGenerator;
import ec3.common.tile.TileMagicalEnchanter;
import ec3.common.tile.TileMagicalFurnace;
import ec3.common.tile.TileMagicalJukebox;
import ec3.common.tile.TileMagicalQuarry;
import ec3.common.tile.TileMagicalRepairer;
import ec3.common.tile.TileMagicalTeleporter;
import ec3.common.tile.TileMagicianTable;
import ec3.common.tile.TileMagmaticSmelter;
import ec3.common.tile.TileMatrixAbsorber;
import ec3.common.tile.TileMonsterHarvester;
import ec3.common.tile.TileMonsterHolder;
import ec3.common.tile.TileMoonWell;
import ec3.common.tile.TilePotionSpreader;
import ec3.common.tile.TileRadiatingChamber;
import ec3.common.tile.TileRayTower;
import ec3.common.tile.TileSolarPrism;
import ec3.common.tile.TileSunRayAbsorber;
import ec3.common.tile.TileecAcceptor;
import ec3.common.tile.TileecStateChecker;
import ec3.utils.cfg.Config;

public class ClientProxy extends CommonProxy{
ResourceLocation villagerSkin = new ResourceLocation("essentialcraft","textures/entities/magician.png");
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,int x, int y, int z) 
	{
		if(ID == Config.guiID[0])
		{
			TileEntity tile = world.getTileEntity(x, y, z);
			if(tile instanceof TileRayTower)
			{
				return new GuiRayTower(new ContainerRayTower(player.inventory, tile), tile);
			}
			if(tile instanceof TileecAcceptor)
			{
				return new GuiMRUAcceptor(new ContainerMRUAcceptor(player.inventory,tile), tile);
			}
			if(tile instanceof TileecStateChecker)
			{
				return new GuiMRUInfo(new ContainerMRUInfo(player.inventory,tile), tile);
			}
			if(tile instanceof TileMoonWell)
			{
				return new GuiMoonWell(new ContainerMoonWell(player.inventory, tile),tile);
			}
			if(tile instanceof TileSunRayAbsorber)
			{
				return new GuiSunRayAbsorber(new ContainerSunRayAbsorber(player.inventory, tile),tile);
			}
			if(tile instanceof TileColdDistillator)
			{
				return new GuiColdDistillator(new ContainerColdDistillator(player.inventory, tile),tile);
			}
			if(tile instanceof TileFlowerBurner)
			{
				return new GuiFlowerBurner(new ContainerFlowerBurner(player.inventory, tile),tile);
			}
			if(tile instanceof TileHeatGenerator)
			{
				return new GuiHeatGenerator(new ContainerHeatGenerator(player.inventory, tile),tile);
			}
			if(tile instanceof TileEnderGenerator)
			{
				return new GuiEnderGenerator(new ContainerEnderGenerator(player.inventory, tile),tile);
			}
			if(tile instanceof TileMagicianTable)
			{
				return new GuiMagicianTable(new ContainerMagicianTable(player.inventory, tile),tile);
			}
			if(tile instanceof TileMagicalQuarry)
			{
				return new GuiMagicalQuarry(new ContainerMagicalQuarry(player.inventory, tile),tile);
			}
			if(tile instanceof TileMonsterHolder)
			{
				return new GuiMonsterHolder(new ContainerMonsterHolder(player.inventory, tile),tile);
			}
			if(tile instanceof TilePotionSpreader)
			{
				return new GuiPotionSpreader(new ContainerPotionSpreader(player.inventory, tile),tile);
			}
			if(tile instanceof TileMagicalEnchanter)
			{
				return new GuiMagicalEnchanter(new ContainerMagicalEnchanter(player.inventory, tile),tile);
			}
			if(tile instanceof TileMonsterHarvester)
			{
				return new GuiMonsterHarvester(new ContainerMonsterHarvester(player.inventory, tile),tile);
			}
			if(tile instanceof TileMagicalRepairer)
			{
				return new GuiMagicalRepairer(new ContainerMagicalRepairer(player.inventory, tile),tile);
			}
			if(tile instanceof TileMatrixAbsorber)
			{
				return new GuiMatrixAbsorber(new ContainerMatrixAbsorber(player.inventory, tile),tile);
			}
			if(tile instanceof TileRadiatingChamber)
			{
				return new GuiRadiatingChamber(new ContainerRadiatingChamber(player.inventory, tile),tile);
			}
			if(tile instanceof TileMagmaticSmelter)
			{
				return new GuiMagmaticSmeltery(new ContainerMagmaticSmeltery(player.inventory, tile),tile);
			}
			if(tile instanceof TileMagicalJukebox)
			{
				return new GuiMagicalJukebox(new ContainerMagicalJukebox(player.inventory, tile),tile);
			}
			if(tile instanceof TileCrystalFormer)
			{
				return new GuiCrystalFormer(new ContainerCrystalFormer(player.inventory, tile),tile);
			}
			if(tile instanceof TileCrystalController)
			{
				return new GuiCrystalController(new ContainerCrystalController(player.inventory, tile),tile);
			}
			if(tile instanceof TileCrystalExtractor)
			{
				return new GuiCrystalExtractor(new ContainerCrystalExtractor(player.inventory, tile),tile);
			}
			if(tile instanceof TileChargingChamber)
			{
				return new GuiChargingChamber(new ContainerChargingChamber(player.inventory, tile),tile);
			}
			if(tile instanceof TileMagicalTeleporter)
			{
				return new GuiMagicalTeleporter(new ContainerMagicalTeleporter(player.inventory, tile),tile);
			}
			if(tile instanceof TileMagicalFurnace)
			{
				return new GuiMagicalFurnace(new ContainerMagicalFurnace(player.inventory, tile),tile);
			}
		}
		return null;
	}

	@Override
	public void registerRenderInformation()
	{
		MainMenuRegistry.registerNewGui(GuiMainMenuEC3.class, "[EC3] Magical Menu", "For EC3 fans ;)");
		RenderingRegistry.registerEntityRenderingHandler(EntityMRUPresence.class, new RenderMRUPresence());
		RenderingRegistry.registerEntityRenderingHandler(EntityMRUArrow.class, new RenderMRUArrow());
		RenderingRegistry.registerEntityRenderingHandler(EntitySolarBeam.class, new RenderSolarBeam());
		RenderingRegistry.registerEntityRenderingHandler(EntityWindMage.class, new RenderWindMage());
		RenderingRegistry.registerBlockHandler(new RenderBlocksECIII());
		FMLCommonHandler.instance().bus().register(new ClientRenderHandler());
		MinecraftForge.EVENT_BUS.register(new RenderHandlerEC3());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlocksCore.elementalCrystal), new RenderElementalCrystalAsItem());
		for(int i = 0; i < ItemsCore.magicArmorItems.length; ++i)
		{
			if(ItemsCore.magicArmorItems[i] != null)
				MinecraftForgeClient.registerItemRenderer(ItemsCore.magicArmorItems[i], new ArmorRenderer());
		}
		
	}
	
	@Override
	public void registerTileEntitySpecialRenderer()
	{
		ClientRegistry.bindTileEntitySpecialRenderer(TileRayTower.class, new RenderRayTower());
		ClientRegistry.bindTileEntitySpecialRenderer(TileecAcceptor.class, new RenderMRULink());
		ClientRegistry.bindTileEntitySpecialRenderer(TileSolarPrism.class, new RenderSolarPrism());
		ClientRegistry.bindTileEntitySpecialRenderer(TileSunRayAbsorber.class, new RenderSunRayAbsorber());
		ClientRegistry.bindTileEntitySpecialRenderer(TileColdDistillator.class, new RenderColdDistillator());
		ClientRegistry.bindTileEntitySpecialRenderer(TileFlowerBurner.class, new RenderFlowerBurner());
		ClientRegistry.bindTileEntitySpecialRenderer(TileHeatGenerator.class, new RenderHeatGenerator());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEnderGenerator.class, new RenderEnderGenerator());
		ClientRegistry.bindTileEntitySpecialRenderer(TileMagicianTable.class, new RenderMagicianTable());
		ClientRegistry.bindTileEntitySpecialRenderer(TileMagicalQuarry.class, new RenderMagicalQuarry());
		ClientRegistry.bindTileEntitySpecialRenderer(TileMonsterHolder.class, new RenderMonsterHolder());
		ClientRegistry.bindTileEntitySpecialRenderer(TilePotionSpreader.class, new RenderPotionSpreader());
		ClientRegistry.bindTileEntitySpecialRenderer(TileMagicalEnchanter.class, new RenderMagicalEnchanter());
		ClientRegistry.bindTileEntitySpecialRenderer(TileMonsterHarvester.class, new RenderMonsterHarvester());
		ClientRegistry.bindTileEntitySpecialRenderer(TileMagicalRepairer.class, new RenderMagicalRepairer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileMatrixAbsorber.class, new RenderMatrixAbsorber());
		ClientRegistry.bindTileEntitySpecialRenderer(TileRadiatingChamber.class, new RenderRadiatingChamber());
		ClientRegistry.bindTileEntitySpecialRenderer(TileMagmaticSmelter.class, new RenderMagmaticSmelter());
		ClientRegistry.bindTileEntitySpecialRenderer(TileMagicalJukebox.class, new RenderMagicalJukebox());
		ClientRegistry.bindTileEntitySpecialRenderer(TileElementalCrystal.class, new RenderElementalCrystal());
		ClientRegistry.bindTileEntitySpecialRenderer(TileCrystalFormer.class, new RenderCrystalFormer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileCrystalController.class, new RenderCrystalController());
		ClientRegistry.bindTileEntitySpecialRenderer(TileCrystalExtractor.class, new RenderCrystalExtractor());
		ClientRegistry.bindTileEntitySpecialRenderer(TileChargingChamber.class, new RenderChargingChamber());
	}
	
	@Override
	public World getClientWorld()
	{
		return FMLClientHandler.instance().getClient().theWorld;
	}
	
	@Override
	public Object getClientIcon(String str)
	{
		if(str.equals("mru"))
			return mruIcon;
		if(str.equals("chaosIcon"))
			return chaosIcon;
		if(str.equals("frozenIcon"))
			return frozenIcon;
		if(str.equals("mruParticleIcon"))
			return mruParticleIcon;
		if(str.contains("consSpellParticle"))
		{
			int index = str.indexOf('_');
			if(index != -1)
			{
				int arrayNum = Integer.parseInt(str.substring(index+1));
				return c_spell_particle_array[arrayNum];
			}
		}
		return null;
	}
	
	@Override
	public void spawnParticle(String name, float x, float y, float z, double i, double j, double k)
	{
		if(name.equals("mruFX"))
			Minecraft.getMinecraft().effectRenderer.addEffect(new EntityMRUFX(getClientWorld(), x, y, z, i, j, k));
		if(name.equals("cSpellFX"))
			Minecraft.getMinecraft().effectRenderer.addEffect(new EntityCSpellFX(getClientWorld(), x, y, z, i, j, k));
	}
	
	@Override
	public boolean itemHasEffect(ItemStack stk)
	{
		if(stk.getItem() instanceof ItemSecret)
		{
			int metadata = stk.getItemDamage();
			switch(metadata)
			{
				case 0:
				{
					EntityPlayer player = Minecraft.getMinecraft().thePlayer;
					World wrld = Minecraft.getMinecraft().theWorld;
					List playerLst = wrld.getEntitiesWithinAABB(EntityPlayer.class, AxisAlignedBB.getBoundingBox(player.posX-10, player.posY-10, player.posZ-10, player.posX+10, player.posY+10, player.posZ+10));
					BiomeGenBase biome = wrld.getBiomeGenForCoords((int)player.posX, (int)player.posY);
					return (wrld.getWorldTime() % 24000 >= 14000 && wrld.getWorldTime() % 24000 <= 16000) && (player.rotationPitch <= -42 && player.rotationPitch >= -65) && (playerLst.size() == 1) && (!wrld.isRaining() && (biome.getTempCategory() == TempCategory.WARM || biome.getTempCategory() == TempCategory.MEDIUM));
				}
			}
		}
		return false;
	}
	
	@Override
	public Object getClientModel(int id)
	{
		switch (id) 
		{
			case 0:
				return chest;
			case 1: 
				return legs;
			case 2:
				return chest1;
			default: break; 
		} 
		return chest; 
	}
	
	@Override
	public Object getRenderer(int index)
	{
		if(index == 0)
			return skyedRenderer;
		else
			return cloudedRenderer;
	}
	
	public static IIcon mruIcon;
	public static IIcon mruParticleIcon;
	public static IIcon[] c_spell_particle_array = new IIcon[4];
	public static IIcon chaosIcon;
	public static IIcon frozenIcon;
	

	@SideOnly(Side.CLIENT)
	private static IRenderHandler skyedRenderer = new RenderSkyFirstWorld();
	
	@SideOnly(Side.CLIENT)
	private static IRenderHandler cloudedRenderer = new RenderCloudsFirstWorld();
	
	private static final ModelArmorEC3 chest = new ModelArmorEC3(1.0f);
	private static final ModelArmorEC3 chest1 = new ModelArmorEC3(0.75f);
	private static final ModelArmorEC3 legs = new ModelArmorEC3(0.5f);
}
