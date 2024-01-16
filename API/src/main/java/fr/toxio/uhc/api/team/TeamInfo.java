package fr.toxio.uhc.api.team;

public class TeamInfo {
    private final String name;
    private final String id;
    private final boolean solitary;
    private TeamMeta teamMeta;


    public TeamInfo(TeamMeta teamMeta) {
        this.teamMeta = teamMeta;
        this.id = teamMeta.id();
        this.name = teamMeta.name().isEmpty() ? id : teamMeta.name();
        this.solitary = teamMeta.solitary();
    }

    public String getName() {
        return name;
    }

    public boolean isSolitary() {
        return solitary;
    }
}
