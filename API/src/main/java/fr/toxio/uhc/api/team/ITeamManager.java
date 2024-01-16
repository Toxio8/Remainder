package fr.toxio.uhc.api.team;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.UUID;

public interface ITeamManager {

     Map<Class<? extends  AbstractTeam>, Object> teams = Maps.newHashMap();


    void registerTeam(Class<? extends AbstractTeam> clazz);

    Map<Class<? extends  AbstractTeam>, Object> getTeams();

    void addMember(UUID uuid, Class<? extends AbstractTeam> clazz);

    void removeMember(UUID uuid, Class<? extends AbstractTeam> clazz);

    boolean isInTeam(UUID uuid, Class<? extends AbstractTeam> clazz);

    AbstractTeam getTeamByClass(Class<? extends AbstractTeam> clazz);

    boolean isRegistered(Class<? extends AbstractTeam> clazz);
}
