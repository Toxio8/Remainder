package fr.toxio.uhc.api.team;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface TeamMeta {

    String name() default "";

    String id();

    boolean solitary() default false;
}
