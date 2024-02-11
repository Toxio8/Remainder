package fr.toxio.uhc.core.team;

import fr.toxio.uhc.api.UHCAPI;
import fr.toxio.uhc.api.player.IUHCProfile;
import fr.toxio.uhc.api.team.AbstractTeam;
import fr.toxio.uhc.api.team.ITeamManager;
import fr.toxio.uhc.api.team.TeamInfo;
import fr.toxio.uhc.api.team.TeamMeta;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.UUID;

public class TeamManager implements ITeamManager {

    @Override
    public void registerTeam(Class<? extends AbstractTeam> clazz) {
        TeamMeta teamMeta = clazz.getAnnotation(TeamMeta.class);
        TeamInfo teamInfo = new TeamInfo(teamMeta);
        if (isRegistered(clazz)) {
            System.out.println(clazz.getName() + " is registered");
            return;
        }
        teams.put(clazz, teamInfo);
    }
    @Override
    public Map<Class<? extends  AbstractTeam>, Object> getTeams() {
        return teams;
    }

    @Override
    public void addMember(UUID uuid,Class<? extends AbstractTeam> clazz) {
        AbstractTeam team = getTeamByClass(clazz);
        if (team == null) {
            return;
        }
        IUHCProfile profile = UHCAPI.get().getPlayerManager().getProfile(uuid);
        profile.setTeam(team);
        team.getMembers().add(uuid);
    }
    @Override
    public void removeMember(UUID uuid, Class<? extends AbstractTeam> clazz) {
       AbstractTeam team = getTeamByClass(clazz);

       IUHCProfile profile = UHCAPI.get().getPlayerManager().getProfile(uuid);
       profile.setTeam(null);

       team.getMembers().remove(uuid);
    }
    @Override
    public boolean isInTeam(UUID uuid, Class<? extends AbstractTeam> clazz) {
        AbstractTeam team = getTeamByClass(clazz);
        if (team == null) {
            return false;
        }
        return team.getMembers().contains(uuid);
    }
    @Override
    public AbstractTeam getTeamByClass(Class<? extends AbstractTeam> clazz) {
        for (Class<? extends AbstractTeam> team : teams.keySet()) {
            if (team.equals(clazz)) {
                try {
                    return team.getDeclaredConstructor().newInstance();
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                         NoSuchMethodException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return null;
    }
    @Override
    public boolean isRegistered(Class<? extends AbstractTeam> clazz) {
        return teams.containsKey(clazz);
    }
}
