package mostima.mod;

import gregtech.GTInternalTags;
import mostima.mod.blocks.ModMetaBlocks;
import mostima.mod.mte.MaxMetaTileEntities;
import mostima.mod.mte.RegularMetaTileEntities;
import mostima.mod.mte.SpaceMetaTileEntities;
import mostima.mod.recipe.AutoGenerateSpaceRecipes;
import mostima.mod.recipe.MinorRecipes;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Tags.MODID, version = Tags.VERSION, name = Tags.MODNAME, acceptedMinecraftVersions = "[1.12.2]", dependencies = GTInternalTags.DEP_VERSION_STRING)
public class MostimaCraft {

    public static final Logger LOGGER = LogManager.getLogger(Tags.MODID);


    @EventHandler
    // preInit "Run before anything else. Read your config, create blocks, items, etc. (Remove if not needed)
    public void preInit(FMLPreInitializationEvent event)
    {
        ModMetaBlocks.init();
        MaxMetaTileEntities.init();
        SpaceMetaTileEntities.init();
        RegularMetaTileEntities.init();
    }

    @SubscribeEvent
    // Register recipes here (Remove if not needed)
    public void registerRecipes(RegistryEvent.Register<IRecipe> event) {

    }

    @SubscribeEvent
    // Register items here (Remove if not needed)
    public void registerItems(RegistryEvent.Register<Item> event) {

    }

    @EventHandler
    // load "Do your mod setup. Build whatever data structures you care about." (Remove if not needed)
    public void init(FMLInitializationEvent event) {
        AutoGenerateSpaceRecipes.init();
        MinorRecipes.init();
    }

    @EventHandler
    // postInit "Handle interaction with other mods, complete your setup based on this." (Remove if not needed)
    public void postInit(FMLPostInitializationEvent event) {
    }

    @EventHandler
    // register server commands in this event handler (Remove if not needed)
    public void serverStarting(FMLServerStartingEvent event) {
    }
}
