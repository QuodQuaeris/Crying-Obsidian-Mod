package de.errorcraftlp.cryingobsidian;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import de.errorcraftlp.cryingobsidian.block.*;

/**
 * 
 * This is the main class of the Crying Obsidian-Mod.
 * 
 * @author ErrorCraftLP
 * 
 * @since 1.0.0
 * 
 * @version 1.0.0
 *
 */
@Mod(modid = CryingObsidian.MOD_ID, name = CryingObsidian.MOD_NAME, version = CryingObsidian.MOD_VERSION)
public class CryingObsidian {
	
	/**The id of the Crying Obsidian-Mod*/
    public static final String MOD_ID = "cryingobsidian";
    
    /**The official name of the Crying Obsidian-Mod which is showed in the mcmod.info file*/
    public static final String MOD_NAME = "Crying Obsidian-Mod";
    
    /**The version of the Crying Obsidian-Mod*/
    public static final String MOD_VERSION = "1.0.0";
    
    /**The creative tab of the Sugar+ Mod*/
    public static CreativeTabs tabCryingObsidian = new CreativeTabs(CreativeTabs.getNextID(), "tabCryingObsidian") {
    	
		public Item getTabIconItem() {
			
			return Item.getItemFromBlock(null);
			
		}
    	
    };
    
    /**If this boolean is enabled, the mod will print debug info in the console*/
    public static boolean enableDebugMessages = true;
    
    /**The Crying Obsdian Block*/
    public static Block CryingObsidianBlock;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	
    	//Show a message when the Crying Obsidian-Mod is going to load
    	if(enableDebugMessages) {
    		
    		CryingObsidianUtils.info(String.format("Getting ready to load the Crying Obsidian-Mod!"));
    		
    	}
    	
    	CryingObsidianBlock = new CryingObsidianBlock(Material.rock).setUnlocalizedName("CryingObsidianBlock");
    	
    	GameRegistry.registerBlock(CryingObsidianBlock, "CryingObsidianBlock");
    	
		//Load the config file
		Configuration configuration = new Configuration(event.getSuggestedConfigurationFile());
		
		//Show a message when the Crying Obsidian-Mod is loading the config
		if(enableDebugMessages) {
			
			CryingObsidianUtils.info("Loading config file: " + event.getSuggestedConfigurationFile());
			
		}
		configuration.load();
		
		enableDebugMessages = configuration.get("MISC", "enableDebugMessages", true).getBoolean(enableDebugMessages);
		
		configuration.save();
    	
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
  
    	//Show a message when the Crying Obsidian-Mod is loading
    	if(enableDebugMessages) {
    		
    		CryingObsidianUtils.info(String.format("Loading the Crying Obsidian-Mod!"));
    		
    	}
    	
    	//Load the crafting recipes
    	CraftingRecipes();
    	
    	//Render the crying obsidian block
    	//TODO
    	
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	
    	//Show a message when the Crying Obsidian-Mod was initialized sucessfully
    	if(enableDebugMessages) {
    		
    		CryingObsidianUtils.info(String.format("Intialized the Crying Obsidian-Mod sucessfully!"));
    		
    	}
    	
    }
    
    /**
     * 
     * This method contains all recipses of the Crying Obsidian-Mod.
     * 
     * @author ErrorCraftLP
     * 
     * @since 1.0.0
     * 
     */
    public void CraftingRecipes() {
    	
    	//The recipe of the crying obsidian block
    	GameRegistry.addRecipe(new ItemStack(CryingObsidian.CryingObsidianBlock, 1), new Object[]{
    		"xlx",
    		"lol",
    		"xlx",
    		Character.valueOf('l'), Blocks.lapis_block,
    		Character.valueOf('o'), Blocks.obsidian
    	});
    	
    }
}
