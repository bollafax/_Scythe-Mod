package Scythe.Items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;
import Scythe.Generic.Generic;

public class Scythe extends ItemSword{

	public Scythe(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		// TODO Auto-generated constructor stub
		Generic.HasAScythe = false;
	}
	 public void onUpdate(ItemStack par1ItemStack, World par2World, Entity Player, int par4, boolean par5) {
		 EntityPlayer player = (EntityPlayer) Player;
		if(player.getCurrentEquippedItem().itemID == this.itemID)
		{
			Generic.HasAScythe = true;
			//System.out.println("Player has a scythe with id : " + this.itemID + " equiped");
		}
		 
	 }

}
