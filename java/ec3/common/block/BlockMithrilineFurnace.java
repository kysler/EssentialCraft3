package ec3.common.block;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import DummyCore.Utils.Coord3D;
import DummyCore.Utils.MiscUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ec3.common.item.ItemsCore;
import ec3.common.mod.EssentialCraftCore;
import ec3.common.tile.TileCorruption;
import ec3.common.tile.TileCrystalFormer;
import ec3.common.tile.TileMagicalMirror;
import ec3.common.tile.TileMagicalQuarry;
import ec3.common.tile.TileMithrilineFurnace;
import ec3.common.tile.TileMoonWell;
import ec3.utils.cfg.Config;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;

public class BlockMithrilineFurnace extends BlockContainer{

	public BlockMithrilineFurnace(Material p_i45394_1_) {
		super(p_i45394_1_);
	}

	public BlockMithrilineFurnace() {
		super(Material.rock);
	}
	
	@Override
    public void breakBlock(World par1World, int par2, int par3, int par4, Block par5, int par6)
    {
		MiscUtils.dropItemsOnBlockBreak(par1World, par2, par3, par4, par5, par6);
		super.breakBlock(par1World, par2, par3, par4, par5, par6);
    }
	
    public boolean isOpaqueCube()
    {
        return false;
    }
    
	@Override
    public int getRenderBlockPass()
    {
        return 0;
    }
    
    public boolean renderAsNormalBlock()
    {
        return false;
    }
    
    public int getRenderType()
    {
        return 2634;
    }

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		// TODO Auto-generated method stub
		return new TileMithrilineFurnace();
	}
	
	@Override
	 public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	    {
	        if (par1World.isRemote)
	        {
	            return true;
	        }else
	        {
	        	if(!par5EntityPlayer.isSneaking())
	        	{
	        		par5EntityPlayer.openGui(EssentialCraftCore.core, Config.instance.guiID[0], par1World, par2, par3, par4);
	            	return true;
	        	}
	        	else
	        	{
	        		return false;
	        	}
	        }
	    }
}
