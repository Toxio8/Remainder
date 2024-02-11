package fr.toxio.uhc.core.worldgen.cave;

import com.google.common.collect.Lists;
import fr.toxio.uhc.api.worldgen.BlockParameters;
import fr.toxio.uhc.api.worldgen.ICaveManager;
import org.bukkit.Material;

import java.util.List;

public class CaveManager implements ICaveManager {

    public List<BlockParameters> oresCave;

    public CaveManager() {
        this.oresCave = Lists.newArrayList();
        this.oresCave.add(new BlockParameters(Material.DIAMOND_ORE, 0, 1, 0, 16, 0.25));
        this.oresCave.add(new BlockParameters(Material.COAL_ORE, 0, 0, 0, 132, 0));
        this.oresCave.add(new BlockParameters(Material.GOLD_ORE, 0, 1, 0, 34, 0.2));
        this.oresCave.add(new BlockParameters(Material.IRON_ORE, 0, 0, 0, 68, 0));
        this.oresCave.add(new BlockParameters(Material.LAPIS_ORE, 0, 0, 0, 34, 0));
    }
    @Override
    public List<BlockParameters> getOresCave() {
        return oresCave;
    }

}
