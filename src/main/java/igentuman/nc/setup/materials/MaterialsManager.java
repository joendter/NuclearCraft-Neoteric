package igentuman.nc.setup.materials;

import igentuman.nc.setup.Materials;

import java.util.HashMap;

public class MaterialsManager {
    protected static HashMap<String, NCMaterial> all;
    protected static HashMap<String, NCMaterial> ores;
    protected static HashMap<String, NCMaterial> ingots;
    protected static HashMap<String, NCMaterial> nuggets;
    protected static HashMap<String, NCMaterial> plates;
    protected static HashMap<String, NCMaterial> blocks;
    protected static HashMap<String, NCMaterial> dusts;


    public static HashMap<String, NCMaterial> blocks()
    {
        if(blocks == null) {
            blocks = new HashMap<>();
            for(NCMaterial m: all().values()) {
                if(m.block) {
                    blocks.put(m.name, m);
                }
            }
        }
        return blocks;
    }

    public static HashMap<String, NCMaterial> all()
    {
        return Materials.all();
    }
    public static HashMap<String, NCMaterial> ores()
    {
        if(ores == null) {
            ores = new HashMap<>();
            for(NCMaterial m: all().values()) {
                if(m.normal_ore || m.deepslate_ore || m.end_ore || m.nether_ore) {
                    ores.put(m.name, m);
                }
            }
        }
        return ores;
    }

    public static HashMap<String, NCMaterial> ingots()
    {
        if(ingots == null) {
            ingots = new HashMap<>();
            for(NCMaterial m: all().values()) {
                if(m.ingot) {
                    ingots.put(m.name, m);
                }
            }
        }
        return ingots;
    }

    public static HashMap<String, NCMaterial> nuggets()
    {
        if(nuggets == null) {
            nuggets = new HashMap<>();
            for(NCMaterial m: all().values()) {
                if(m.nugget) {
                    nuggets.put(m.name, m);
                }
            }
        }
        return nuggets;
    }

    public static HashMap<String, NCMaterial> dusts()
    {
        if(dusts == null) {
            dusts = new HashMap<>();
            for(NCMaterial m: all().values()) {
                if(m.dust) {
                    dusts.put(m.name, m);
                }
            }
        }
        return dusts;
    }

    public static HashMap<String, NCMaterial> plates()
    {
        if(plates == null) {
            plates = new HashMap<>();
            for(NCMaterial m: all().values()) {
                if(m.plate) {
                    plates.put(m.name, m);
                }
            }
        }
        return plates;
    }
}
