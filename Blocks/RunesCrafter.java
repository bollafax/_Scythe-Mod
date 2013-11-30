package Scythe.Blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.world.World;
import Scythe.Generic.Generic;

public class RunesCrafter extends BlockContainer {

	public RunesCrafter(int par1, Material par2Material) {
		super(par1, par2Material);
		// TODO Auto-generated constructor stub
	}
	  @Override
      public boolean onBlockActivated(World world, int x, int y, int z,
                      EntityPlayer player, int metadata, float what, float these, float are) {
              TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
              if (tileEntity == null || player.isSneaking()) {
                      return false;
              }
      //code to open gui explained later
      player.openGui(Generic.instance, 0, world, x, y, z);
              return true;
      }
	  
	  @Override
      public TileEntity createNewTileEntity(World world) {
              return new TileEntityBeacon();
      }

}
