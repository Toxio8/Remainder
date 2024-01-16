package fr.toxio.uhc.api.menu.buttons;

import fr.toxio.uhc.api.utils.ItemBuilder;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.function.BiConsumer;

public class SimpleButton {

    @Getter
    private final ItemStack itemStack;
    @Getter
    private final String name;
    @Getter
    private final int slot;
    private final BiConsumer<Player, ItemStack> consumers;

    public SimpleButton(Material material, String name, int slot , BiConsumer<Player, ItemStack> onClick) {
        this.itemStack = new ItemBuilder(material).setName(name).toItemStack();
        this.slot = slot;
        this.consumers = onClick;
        this.name = name;
    }


    public void onClick(Player player, ItemStack itemStack) {
        this.consumers.accept(player, itemStack);
    }

}
