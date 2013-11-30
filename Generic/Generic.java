package Scythe.Generic;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import Scythe.Events.Living.ScytheHeadDrop;
import Scythe.Items.Scythe;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler; // used in 1.6.2
//import cpw.mods.fml.common.Mod.PreInit;    // used in 1.5.2
//import cpw.mods.fml.common.Mod.Init;       // used in 1.5.2
//import cpw.mods.fml.common.Mod.PostInit;   // used in 1.5.2
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="GenericModID", name="scythe", version="0.0.0")
@NetworkMod(clientSideRequired=true)
public class Generic {
		public static boolean HasAScythe;
        // The instance of your mod that Forge uses.
        @Instance(value = "scythe")
        public static Generic instance;
        
        public static Scythe DummyScythe;
        public static Item WhiteRune;
        public static Item MobSoul;
        
        // Says where the client and server 'proxy' code is loaded.
        @SidedProxy(clientSide="Scythe.Generic.ClientProxy", serverSide="Scythe.Generic.CommonProxy")
        public static CommonProxy proxy;
        
        @EventHandler // used in 1.6.2
        //@PreInit    // used in 1.5.2
        public void preInit(FMLPreInitializationEvent event) {
                // Stub Method
        	Configuration config = 
        			new Configuration(event.getSuggestedConfigurationFile());
        	config.load();
        		//Config---
        	
        	//Get IDs from Config FILE
        	DummyScytheID = config.getItem("DummyScytheID", 20000).getInt();
        	WhiteRuneID   = config.getItem("WhiteRuneID", 20001).getInt();
        	MobSoulID     = config.getItem("MobSoulID", 20002).getInt();
        	//Settings
        	DummyScythe =  (Scythe) new Scythe(DummyScytheID,EnumToolMaterial.EMERALD).setUnlocalizedName("Scythe.Dummy")
        			      .setTextureName("scythe:scythe").setCreativeTab(tabScythe);
        	WhiteRune = new Item(WhiteRuneID)
        				.setUnlocalizedName("Runes.White")
        				.setCreativeTab(tabScythe)
        				.setTextureName("scythe:WhiteRune");
        	MobSoul = new Item(MobSoulID)
        			.setUnlocalizedName("Scythe.Soul")
    				.setCreativeTab(tabScythe)
    				.setTextureName("scythe:Soul");
        	
        	config.save();
        }
        
        @EventHandler // used in 1.6.2
        //@Init       // used in 1.5.2
        public void load(FMLInitializationEvent event) {
                proxy.registerRenderers();
                LanguageRegistry.addName(DummyScythe, "Powered Scythe");
                LanguageRegistry.addName(WhiteRune, "White Rune");
                LanguageRegistry.addName(MobSoul, "Animal Soul");
                //Register Creative Tab
                
                LanguageRegistry.instance()
                .addStringLocalization("itemGroup.tabScythe", "en_US", "Scythe Mod");
                
                //ItemStacks
                
                ItemStack Quartz = new ItemStack(Block.blockNetherQuartz);
                ItemStack Glass = new ItemStack(Block.glass);
                //Crafts
                
                GameRegistry.addRecipe(new ItemStack(WhiteRune), "xxx", "xyx", "xxx",'x' , Quartz,'y',Glass );
                GameRegistry.addRecipe(new ItemStack(DummyScythe), "xxx","  y"," y ",'x',new ItemStack(Item.ingotIron),'y', new ItemStack(Item.stick));
                //------
                //FillerManager.
                
                MinecraftForge.EVENT_BUS.register(new ScytheHeadDrop());
        }
        
        @EventHandler // used in 1.6.2
        //@PostInit   // used in 1.5.2
        public void postInit(FMLPostInitializationEvent event) {
                // Stub Method
        }
        
        //IDs
        int DummyScytheID;
        int WhiteRuneID;
        int MobSoulID; 
        
        //Creative Tab
        public static CreativeTabs tabScythe = new CreativeTabs("tabScythe") {
            public ItemStack getIconItemStack() {
                    return new ItemStack(Item.eyeOfEnder, 1, 0);
            }
    };
    
}
