package Scythe.Events.Living;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.bouncycastle.crypto.prng.RandomGenerator;

import Scythe.Generic.Generic;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
public class ScytheHeadDrop {
	 Random random = new Random();
	private static HashMap<Class<? extends EntityLiving>, ArrayList<EntityItem>> drops;
	 @ForgeSubscribe
	    public void entityDrop(LivingDropsEvent event) {
	        EntityLivingBase mob = event.entityLiving;
	        
	        //ArrayList<EntityItem> data = drops.get(mob.getClass());
	          int Chance =  random.nextInt(100);
	          System.out.println("Chance Is :" + Chance);
	          if(Generic.HasAScythe)
	          {
	        	if (25 > Chance) {
                    mob.dropItem(Generic.MobSoul.itemID, 1);
                }
	          }
	        
	 }
	
	
}
