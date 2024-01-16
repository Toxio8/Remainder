package fr.toxio.uhc.api.role;

import fr.toxio.uhc.api.power.AbstractPower;
import lombok.Getter;
@Getter
public class RoleInfo {


    private final String name;
    private final String id;
    private final RoleMeta roleMeta;
    private final Class<? extends AbstractPower>[] powerList;


    public RoleInfo(RoleMeta roleMeta) {
        this.roleMeta = roleMeta;
        this.id = roleMeta.id();
        this.name = roleMeta.name().isEmpty() ? id : roleMeta.name();
        this.powerList = roleMeta.powerList();
    }


}
