package fr.toxio.uhc.core.game.inventoryconfig;

import fr.toxio.uhc.api.UHCAPI;
import fr.toxio.uhc.api.menu.AbstractMenu;
import fr.toxio.uhc.api.menu.buttons.SimpleButton;
import fr.toxio.uhc.api.utils.ItemBuilder;
import fr.toxio.uhc.api.worldgen.biome.BiomeState;
import net.minecraft.server.v1_8_R3.BiomeBase;
import net.minecraft.server.v1_8_R3.ItemStack;
import org.bukkit.Material;

public class BiomeMenu extends AbstractMenu {




    public BiomeMenu() {
        super(54, "§lBiome au centre");

    }

    @Override
    public void loadItems() {
        SimpleButton taigaButton = new SimpleButton(new ItemBuilder(Material.SAPLING,1,(byte)1).toItemStack().getType(),"§fForêt de sapin",10,(player, itemStack) -> {
            UHCAPI.get().getBiomeCenterManager().setBiome(BiomeState.TAIGA);
        } );
        SimpleButton roofedForestButton = new SimpleButton(new ItemBuilder(Material.SAPLING,1,(byte)5).toItemStack().getType(),"§aRoof Forest",11,(player, itemStack) -> {
            UHCAPI.get().getBiomeCenterManager().setBiome(BiomeState.ROOFED_FOREST);
        });
        SimpleButton desertButton = new SimpleButton(Material.SAND,"§aDesert",12, (player, itemStack) -> {
            UHCAPI.get().getBiomeCenterManager().setBiome(BiomeState.DESERT);
        });
        SimpleButton forestButton = new SimpleButton(new ItemBuilder(Material.SAPLING).toItemStack().getType(), "§aForêt de chaîne",13,(player, itemStack) -> {
            UHCAPI.get().getBiomeCenterManager().setBiome(BiomeState.FOREST);
        });
        SimpleButton plainButton = new SimpleButton(Material.GRASS,"§aPlaine",14,(player, itemStack) -> {
            UHCAPI.get().getBiomeCenterManager().setBiome(BiomeState.PLAINS);
        });
        SimpleButton backButton = new SimpleButton(Material.BARRIER,"§aRetour",53,(player, itemStack) -> {
            UHCAPI.get().getMenuManager().openMenu(player,new MainMenu());
        });
        getButtons().add(taigaButton);
        getButtons().add(plainButton);
        getButtons().add(roofedForestButton);
        getButtons().add(desertButton);
        getButtons().add(forestButton);
    }
}
