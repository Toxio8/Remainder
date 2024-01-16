package fr.toxio.uhc.api.role;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.UUID;

public interface IRoleManager {

    Map<Class<? extends  AbstractRole>, Object> roles = Maps.newHashMap();

    void setRole(UUID uuid, Class<? extends AbstractRole> clazz);

    void registerRole(Class<? extends AbstractRole> clazz);

    boolean isRegistered(Class<? extends AbstractRole> clazz);

    AbstractRole getRole(Class<? extends AbstractRole> clazz);
}
