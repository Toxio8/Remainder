package fr.toxio.uhc.api.team;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.UUID;

public abstract class AbstractTeam {

    private final List<UUID> members;

    protected AbstractTeam() {
        this.members = Lists.newArrayList();
    }

    public String getName() {
        return getClass().getAnnotation(TeamMeta.class).name();
    }

    public String getId() {
        return getClass().getAnnotation(TeamMeta.class).id();
    }

    public boolean isSolitary() {
        return getClass().getAnnotation(TeamMeta.class).solitary();
    }


    public List<UUID> getMembers() {
        return members;
    }
}

