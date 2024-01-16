package fr.toxio.uhc.api.role;

import fr.toxio.uhc.api.power.AbstractPower;
import fr.toxio.uhc.api.team.AbstractTeam;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface RoleMeta {

    String name() default "";

    String id();

    Class<? extends AbstractPower>[] powerList() default {};

    Class<? extends AbstractTeam> team();

}
