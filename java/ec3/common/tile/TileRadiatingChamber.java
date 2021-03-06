package ec3.common.tile;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.common.config.Configuration;
import DummyCore.Utils.DataStorage;
import DummyCore.Utils.DummyData;
import DummyCore.Utils.MathUtils;
import ec3.api.ApiCore;
import ec3.api.ITEHasMRU;
import ec3.api.RadiatingChamberRecipe;
import ec3.api.RadiatingChamberRecipes;
import ec3.common.block.BlocksCore;
import ec3.common.item.ItemBoundGem;
import ec3.common.item.ItemsCore;
import ec3.utils.common.ECUtils;

public class TileRadiatingChamber extends TileMRUGeneric{
	
	public int progressLevel;
	public RadiatingChamberRecipe currentRecipe;
	public static float cfgMaxMRU = ApiCore.DEVICE_MAX_MRU_GENERIC;
	public static boolean generatesCorruption = true;
	public static int genCorruption = 1;
	public static float mruUsage = 1F;
	
	public TileRadiatingChamber()
	{
		 super();
		this.maxMRU = (int) ApiCore.DEVICE_MAX_MRU_GENERIC;
		this.setSlotsNum(4);
	}
	
	@Override
	public void updateEntity()
	{
		super.updateEntity();
		ECUtils.mruIn(this, 0);
		ECUtils.spawnMRUParticles(this, 0);
		IInventory inv = this;
		int slotNum = 0;
		TileEntity tile = this;
		if(inv.getStackInSlot(slotNum) != null && inv.getStackInSlot(slotNum).getItem() instanceof ItemBoundGem && inv.getStackInSlot(slotNum).getTagCompound() != null)
		{
			ItemStack s = inv.getStackInSlot(slotNum);
			int[] o = ItemBoundGem.getCoords(s);
			if(MathUtils.getDifference(tile.xCoord, o[0]) <= 16 && MathUtils.getDifference(tile.yCoord, o[1]) <= 16 && MathUtils.getDifference(tile.zCoord, o[2]) <= 16)
			{
    			if(tile.getWorldObj().getTileEntity(o[0], o[1], o[2]) != null && tile.getWorldObj().getTileEntity(o[0], o[1], o[2]) instanceof ITEHasMRU)
    			{
    				this.setBalance(((ITEHasMRU) tile.getWorldObj().getTileEntity(o[0], o[1], o[2])).getBalance());
    			}
    		}
		}
		if(!this.worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord))
		{
			ItemStack[] craftMatrix = new ItemStack[2];
			craftMatrix[0] = this.getStackInSlot(1);
			craftMatrix[1] = this.getStackInSlot(2);
			RadiatingChamberRecipe rec = RadiatingChamberRecipes.getRecipeByCPAndBalance(craftMatrix, getBalance());
			if(currentRecipe == null && rec != null && this.progressLevel != 0)
			{
				if(canFunction(rec))
				{
					this.currentRecipe = rec;
				}
			}
			if(currentRecipe == null && rec != null && this.progressLevel == 0)
			{
				if(canFunction(rec))
				{
					this.currentRecipe = rec;
				}
			}
			if(currentRecipe != null && rec == null)
			{
				progressLevel = 0;
				currentRecipe = null;
				return;
			}
			if(currentRecipe != null && rec != null)
			{
				if(!canFunction(rec))
				{
					progressLevel = 0;
					currentRecipe = null;
					return;
				}
				int mruReq = (int) (mruUsage * this.currentRecipe.costModifier);
				if(this.getMRU() >= mruReq && this.progressLevel < this.currentRecipe.mruRequired)
				{
					this.progressLevel += 1;
					if(generatesCorruption)
						ECUtils.increaseCorruptionAt(worldObj, xCoord, yCoord, zCoord, this.worldObj.rand.nextInt(genCorruption));
					this.setMRU(this.getMRU()-mruReq);
					if(this.progressLevel >= this.currentRecipe.mruRequired)
					{
						progressLevel = 0;
						craft();
						currentRecipe = null;
					}
				}
			}
		}
	}
	
    @SideOnly(Side.CLIENT)
    @Override
    public AxisAlignedBB getRenderBoundingBox()
    {
    	AxisAlignedBB bb = INFINITE_EXTENT_AABB;
    	return bb;
    }
    
    public boolean canFunction(RadiatingChamberRecipe rec)
    {
		ItemStack result = rec.result;
		if(result != null)
		{
			if(this.getStackInSlot(3) == null)
			{
				return true;
			}else
			{
				if(this.getStackInSlot(3).isItemEqual(result))
				{
					if(this.getStackInSlot(3).stackSize+result.stackSize <= this.getInventoryStackLimit() && this.getStackInSlot(3).stackSize+result.stackSize <= this.getStackInSlot(3).getMaxStackSize())
					{
						return true;
					}
				}
			}
		}
		return false;
    }

    public void craft()
    {
    	if(this.canFunction(this.currentRecipe))
    	{
    		ItemStack stk = this.currentRecipe.result;
    		if(stk.getItem().getUnlocalizedName().equals(BlocksCore.fortifiedGlass.getUnlocalizedName()) || stk.getItem().getUnlocalizedName().equals(BlocksCore.fortifiedStone.getUnlocalizedName()) || (stk.getItem() == ItemsCore.genericItem && (stk.getItemDamage() == 39 || stk.getItemDamage() == 40)))
    			stk.stackSize = 4;
            if (this.getStackInSlot(3) == null)
            {
                this.setInventorySlotContents(3, stk.copy());
            }
            else if (getStackInSlot(3).getItem() == stk.getItem())
            {
                this.setInventorySlotContents(3, new ItemStack(stk.getItem(),stk.stackSize+this.getStackInSlot(3).stackSize,stk.getItemDamage()));
            }
            for(int i = 1; i < 3; ++i)
            {
            	this.decrStackSize(i, 1);
            }
    	}
    }
    
    public static void setupConfig(Configuration cfg)
    {
    	try
    	{
	    	cfg.load();
	    	String[] cfgArrayString = cfg.getStringList("RadiatingChamberSettings", "tileentities", new String[]{
	    			"Max MRU:"+ApiCore.DEVICE_MAX_MRU_GENERIC,
	    			"MRU Usage Modifier:1.0",
	    			"Can this device actually generate corruption:true",
	    			"The amount of corruption generated each tick(do not set to 0!):1"
	    			},"");
	    	String dataString="";
	    	
	    	for(int i = 0; i < cfgArrayString.length; ++i)
	    		dataString+="||"+cfgArrayString[i];
	    	
	    	DummyData[] data = DataStorage.parseData(dataString);
	    	
	    	mruUsage = Float.parseFloat(data[1].fieldValue);
	    	cfgMaxMRU = Float.parseFloat(data[0].fieldValue);
	    	generatesCorruption = Boolean.parseBoolean(data[2].fieldValue);
	    	genCorruption = Integer.parseInt(data[3].fieldValue);
	    	
	    	cfg.save();
    	}catch(Exception e)
    	{
    		return;
    	}
    }
}
