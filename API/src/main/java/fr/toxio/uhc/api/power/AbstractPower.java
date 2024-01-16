package fr.toxio.uhc.api.power;

import fr.toxio.uhc.api.UHCAPI;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;

import java.util.function.BiConsumer;

@Getter
@Setter
public abstract class AbstractPower {

    private final int maximumUses;
    private Cooldown cooldown;
    private UtilisationType utilisationType;
    private BiConsumer<Player, Action> consumer;

    public AbstractPower(int maximumUses, int cooldown) {
        this.maximumUses = maximumUses;
        this.cooldown = new Cooldown(getName(),cooldown);
        this.consumer = this::onClick;
        if (cooldown == -1) {
            this.utilisationType = UtilisationType.USABLE;

        }
        UHCAPI.get().getPowerManager().getPowers().add(this);
    }

    public void onClick(Player player, Action action) {
        this.consumer.accept(player, action);
    }

    public abstract ItemStack getItem();

    public abstract String getName();

}
