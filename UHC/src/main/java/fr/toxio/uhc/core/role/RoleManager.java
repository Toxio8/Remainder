package fr.toxio.uhc.core.role;

import fr.toxio.uhc.api.UHCAPI;
import fr.toxio.uhc.api.player.IUHCProfile;
import fr.toxio.uhc.api.role.AbstractRole;
import fr.toxio.uhc.api.role.IRoleManager;
import fr.toxio.uhc.api.team.TeamInfo;
import fr.toxio.uhc.api.team.TeamMeta;

import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

public class RoleManager implements IRoleManager {

    @Override
    public void registerRole(Class<? extends AbstractRole> clazz) {
        TeamMeta teamMeta = clazz.getAnnotation(TeamMeta.class);
        TeamInfo teamInfo = new TeamInfo(teamMeta);
        if (teamInfo == null) {
            return;
        }
        roles.put(clazz, teamInfo);
    }


    @Override
    public void setRole(UUID uuid, Class<? extends AbstractRole> clazz) {
        IUHCProfile profile = UHCAPI.get().getPlayerManager().getProfile(uuid);
        AbstractRole role = getRole(clazz);
        if(profile == null) {
            return;
        }
        profile.setRole(role);
        if (profile.getPlayer() == null) {
            return;
        }
        role.onDistribute(profile.getPlayer());
    }


    @Override
    public boolean isRegistered(Class<? extends AbstractRole> clazz) {
        for (Class<? extends  AbstractRole> role : roles.keySet()){
            if(role.equals(clazz)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public AbstractRole getRole(Class<? extends AbstractRole> clazz) {
        for (Class<? extends AbstractRole> role : roles.keySet()) {
            if (clazz.equals(role)) {
                try {
                    return role.getConstructor().newInstance();
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                         NoSuchMethodException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return null;
    }
}
