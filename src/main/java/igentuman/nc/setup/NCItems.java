package igentuman.nc.setup;

import com.electronwill.nightconfig.core.io.ParsingMode;
import igentuman.nc.item.ItemFuel;
import igentuman.nc.setup.fuel.FuelManager;
import igentuman.nc.setup.materials.*;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static igentuman.nc.NuclearCraft.MODID;

public class NCItems {

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static HashMap<String, RegistryObject<Item>> NC_FOOD = new HashMap<>();
    public static HashMap<List<String>, RegistryObject<Item>> NC_FUEL = new HashMap<>();
    public static HashMap<String, RegistryObject<Item>>  NC_ISOTOPES = new HashMap<>();
    public static HashMap<String, RegistryObject<Item>> NC_RECORDS = new HashMap<>();
    public static HashMap<String, RegistryObject<Item>> NC_PARTS = new HashMap<>();
    public static HashMap<String, RegistryObject<Item>> NC_ITEMS = new HashMap<>();
    public static HashMap<String, RegistryObject<Item>> NC_GEMS = new HashMap<>();
    public static HashMap<String, RegistryObject<Item>> NC_INGOTS = new HashMap<>();
    public static HashMap<String, RegistryObject<Item>> NC_CHUNKS = new HashMap<>();
    public static HashMap<String, RegistryObject<Item>> NC_NUGGETS = new HashMap<>();
    public static HashMap<String, RegistryObject<Item>> NC_PLATES = new HashMap<>();
    public static HashMap<String, RegistryObject<Item>> NC_DUSTS = new HashMap<>();
    public static TagKey<Item> PLATE_TAG = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge", "plates"));
    public static TagKey<Item> PARTS_TAG = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(MODID, "parts"));

      public static HashMap<String, TagKey<Item>> INGOTS_TAG = new HashMap<>();
      public static HashMap<String, TagKey<Item>> CHUNKS_TAG = new HashMap<>();
      public static HashMap<String, TagKey<Item>> GEMS_TAG = new HashMap<>();
      public static HashMap<String, TagKey<Item>> NUGGETS_TAG = new HashMap<>();
      public static HashMap<String, TagKey<Item>> PLATES_TAG = new HashMap<>();
      public static HashMap<String, TagKey<Item>> DUSTS_TAG = new HashMap<>();

    public static final Item.Properties ITEM_PROPERTIES = new Item.Properties().tab(ModSetup.ITEM_GROUP);
    public static void init() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(bus);
        registerChunks();
        registerNuggets();
        registerIngots();
        registerPlates();
        registerDusts();
        registerGems();
        registerParts();
        registerItems();
        registerFood();
        registerRecords();
        registerFuel();
        registerIsotopes();
    }

    private static void registerFuel() {
        for (String name: FuelManager.all().keySet()) {
            for(String subType: FuelManager.all().get(name).keySet()) {
                NC_FUEL.put(List.of("fuel", name, subType, ""),
                        ITEMS.register("fuel_"+name+"_"+subType.replace("-","_"),
                                () -> new ItemFuel(ITEM_PROPERTIES, FuelManager.all().get(name).get(subType).getDefault())));
                NC_FUEL.put(List.of("fuel", name, subType, "ox"),
                        ITEMS.register("fuel_"+name+"_"+subType.replace("-","_")+"_ox",
                                () -> new ItemFuel(ITEM_PROPERTIES, FuelManager.all().get(name).get(subType).getOxide())));
                NC_FUEL.put(List.of("fuel", name, subType, "ni"),
                        ITEMS.register("fuel_"+name+"_"+subType.replace("-","_")+"_ni",
                                () -> new ItemFuel(ITEM_PROPERTIES, FuelManager.all().get(name).get(subType).getNitride())));
                NC_FUEL.put(List.of("fuel", name, subType, "za"),
                        ITEMS.register("fuel_"+name+"_"+subType.replace("-","_")+"_za",
                                () -> new ItemFuel(ITEM_PROPERTIES, FuelManager.all().get(name).get(subType).getZirconiumAlloy())));
                NC_FUEL.put(List.of("fuel", name, subType, "tr"),
                        ITEMS.register("fuel_"+name+"_"+subType.replace("-","_")+"_tr",
                                () -> new ItemFuel(ITEM_PROPERTIES, FuelManager.all().get(name).get(subType).getTriso())));

                NC_FUEL.put(List.of("depleted", name, subType, ""),
                        ITEMS.register("depleted_fuel_"+name+"_"+subType.replace("-","_"),
                                () -> new Item(ITEM_PROPERTIES)));
                NC_FUEL.put(List.of("depleted", name, subType, "ox"),
                        ITEMS.register("depleted_fuel_"+name+"_"+subType.replace("-","_")+"_ox",
                                () -> new Item(ITEM_PROPERTIES)));
                NC_FUEL.put(List.of("depleted", name, subType, "ni"),
                        ITEMS.register("depleted_fuel_"+name+"_"+subType.replace("-","_")+"_ni",
                                () -> new Item(ITEM_PROPERTIES)));
                NC_FUEL.put(List.of("depleted", name, subType, "za"),
                        ITEMS.register("depleted_fuel_"+name+"_"+subType.replace("-","_")+"_za",
                                () -> new Item(ITEM_PROPERTIES)));
                NC_FUEL.put(List.of("depleted", name, subType, "tr"),
                        ITEMS.register("depleted_fuel_"+name+"_"+subType.replace("-","_")+"_tr",
                                () -> new Item(ITEM_PROPERTIES)));
            }
        }
    }

    private static void registerRecords() {
        List<String> items = Arrays.asList(
                "end_of_the_world",
                "hyperspace",
                "money_for_nothing",
                "wanderer"
        );
        for(String name: items) {
            NC_RECORDS.put(name, ITEMS.register(name, () -> new Item(ITEM_PROPERTIES)));
        }
    }

    private static void registerFood() {
        List<String> items = Arrays.asList(
                "dominos",
                "foursmore",
                "graham_cracker",
                "marshmallow",
                "milk_chocolate",
                "moresmore",
                "rad_x",
                "radaway",
                "radaway_slow",
                "smore"
        );
        for(String name: items) {
            NC_FOOD.put(name, ITEMS.register(name, () -> new Item(ITEM_PROPERTIES)));
        }
    }

    private static void registerItems() {
        List<String> items = Arrays.asList(
                "cocoa_butter",
                "cocoa_solids",
                "flour",
                "gelatin",
                "ground_cocoa_nibs",
                "salt",
                "sawdust",
                "dosimeter",
                "upgrade_energy",
                "upgrade_speed",
                "unsweetened_chocolate"
        );
        for(String name: items) {
            NC_ITEMS.put(name, ITEMS.register(name, () -> new Item(ITEM_PROPERTIES)));
        }
    }

    private static void registerIsotopes() {
        List<String> parts = Arrays.asList(
                "americium/241",
                "americium/242",
                "americium/243",
                "berkelium/247",
                "berkelium/248",
                "boron/10",
                "boron/11",
                "californium/249",
                "californium/250",
                "californium/251",
                "californium/252",
                "curium/243",
                "curium/245",
                "curium/246",
                "curium/247",
                "lithium/6",
                "lithium/7",
                "neptunium/236",
                "neptunium/237",
                "plutonium/238",
                "plutonium/239",
                "plutonium/241",
                "plutonium/242",
                "thorium/tbu",
                "thorium/232",
                "uranium/233",
                "uranium/235",
                "uranium/238"
        );
        for(String name: parts) {
            for(String type: new String[]{"", "_za", "_ox","_ni"}) {
                NC_ISOTOPES.put(name+type, ITEMS.register(name.replace("/", "_")+type, () -> new Item(ITEM_PROPERTIES)));
            }
        }
    }

    private static void registerParts() {
        List<String> parts = Arrays.asList(
                "actuator",
                "basic_electric_circuit",
                "bioplastic",
                "chassis",
                "chassis2",
                "empty_frame",
                "empty_sink",
                "motor",
                "plate_advanced",
                "plate_basic",
                "plate_du",
                "plate_elite",
                "plate_extreme",
                "servo",
                "sic_fiber",
                "steel_frame",
                "coil_copper",
                "coil_magnesium_diboride",
                "steel_frame2"
        );
        for(String name: parts) {
            NC_PARTS.put(name, ITEMS.register(name, () -> new Item(ITEM_PROPERTIES)));
        }
    }

    private static void registerGems() {
        for(String name: Gems.registered().keySet()) {
            GEMS_TAG.put(name, TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge", "gems/"+name)));
            NC_GEMS.put(name, ITEMS.register(name+"_gem", () -> new Item(ITEM_PROPERTIES)));
        }
    }

    private static void registerChunks() {
        for(String name: Chunks.registered().keySet()) {
            CHUNKS_TAG.put(name, TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge", "raw_materials/"+name)));
            NC_CHUNKS.put(name, ITEMS.register(name+"_chunk", () -> new Item(ITEM_PROPERTIES)));
        }
    }

    private static void registerNuggets() {
        for(String name: Nuggets.registered().keySet()) {
            NUGGETS_TAG.put(name, TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge", "nuggets/"+name)));
            NC_NUGGETS.put(name, ITEMS.register(name+"_nugget", () -> new Item(ITEM_PROPERTIES)));
        }
    }

    private static void registerIngots() {
        for(String name: Ingots.registered().keySet()) {
            INGOTS_TAG.put(name, TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge", "ingots/"+name)));
            NC_INGOTS.put(name, ITEMS.register(name+"_ingot", () -> new Item(ITEM_PROPERTIES)));
        }
    }

    private static void registerPlates() {
        for(String name: Plates.registered().keySet()) {
            PLATES_TAG.put(name, TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge", "plates/"+name)));
            NC_PLATES.put(name, ITEMS.register(name+"_plate", () -> new Item(ITEM_PROPERTIES)));
        }
    }

    private static void registerDusts() {
        for(String name: Dusts.registered().keySet()) {
            DUSTS_TAG.put(name, TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge", "dusts/"+name)));
            NC_DUSTS.put(name, ITEMS.register(name+"_dust", () -> new Item(ITEM_PROPERTIES)));
        }
    }
}