package fr.toxio.uhc.core.player;

import fr.toxio.uhc.api.player.IUHCProfile;
import fr.toxio.uhc.api.player.ProfileStates;
import fr.toxio.uhc.api.role.AbstractRole;
import fr.toxio.uhc.api.team.AbstractTeam;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;
@Getter
@Setter
public class UHCProfile implements IUHCProfile {
    private final UUID uuid;
    private final String name;
    private int kills;
    private int minedDiamonds;
    private int minedGolds;
    private int minedIrons;
    private boolean mainHost;
    private boolean hostAccess;
    private boolean alive;
    private ProfileStates profileStates;
    private AbstractTeam team;
    private AbstractRole role;

    public UHCProfile(UUID uuid) {
        this.uuid = uuid;
        this.name = Bukkit.getPlayer(uuid).getName();
        this.alive = true;
        this.profileStates = ProfileStates.WAITING;
        this.kills = 0;
        this.minedDiamonds = 0;
        this.minedGolds = 0;
        this.minedIrons = 0;
        this.mainHost = false;
        this.hostAccess = false;
        this.team = null;
        this.role = null;
    }

    @Override
    public ProfileStates getProfileStates() {
        return this.profileStates;
    }
    @Override
    public void setProfileStates(ProfileStates profileStates) {
        this.profileStates = profileStates;
    }

    @Override
    public String getName() {
        return this.name;
    }


    @Override
    public int getKills() {
        return this.kills;
    }

    @Override
    public void setKills(int kills) {
        this.kills = kills;
    }

    @Override
    public int getMinedDiamonds() {
        return this.minedDiamonds;
    }

    @Override
    public void setMinedDiamonds(int diamonds) {
        this.minedDiamonds = diamonds;
    }

    @Override
    public int getMinedGold() {
        return this.minedGolds;
    }

    @Override
    public void setMinedGold(int gold) {
        this.minedGolds = gold;
    }

    @Override
    public int getMinedIron() {
        return this.minedIrons;
    }

    @Override
    public void setMinedIron(int iron) {
        this.minedIrons = iron;
    }


    @Override
    public Player getPlayer() {
        return Bukkit.getPlayer(uuid);
    }

    @Override
    public boolean isMainHost() {
        return this.mainHost;
    }

    @Override
    public boolean hasHostAccess() {
        return this.hostAccess;
    }

    @Override
    public AbstractTeam getTeam() {
        return this.team;
    }

    @Override
    public void setTeam(AbstractTeam team) {
        this.team = team;
    }

    @Override
    public AbstractRole getRole() {
        return this.role;
    }

    @Override
    public void setRole(AbstractRole role) {
        this.role = role;
    }



    @Override
    public boolean isAlive() {
        return this.alive;
    }

    public UUID getUuid() {
        return uuid;
    }
}
