package fr.toxio.uhc.api.role;

import fr.toxio.uhc.api.power.AbstractPower;
import fr.toxio.uhc.api.team.AbstractTeam;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractRole {



    protected AbstractRole() {
    }

    public abstract void onDistribute(Player player);

    public abstract void onSecond(Player player);

    public abstract void onDay(Player player);

    public abstract void onNight(Player player);

    public abstract void onHit(Player player);


    public String getName() {
        return getClass().getAnnotation(RoleMeta.class).name();
    }


    public List<Class<? extends AbstractPower>> getPowerList() {
        return Arrays.asList(getClass().getAnnotation(RoleMeta.class).powerList());
    }

    public String getId() {
        return getClass().getAnnotation(RoleMeta.class).id();
    }

    public Class<? extends AbstractTeam> getTeam() {
        return getClass().getAnnotation(RoleMeta.class).team();
    }

}
