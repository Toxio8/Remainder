package fr.toxio.uhc.api.player;


import fr.toxio.uhc.api.role.AbstractRole;
import fr.toxio.uhc.api.team.AbstractTeam;
import org.bukkit.entity.Player;

import java.util.UUID;

public interface IUHCProfile {

    UUID getUuid();

    void setProfileStates(ProfileStates profileStates);

    ProfileStates getProfileStates();

    String getName();

    int getKills();

    void setKills(int kills);

    int getMinedDiamonds();

    void setMinedDiamonds(int diamonds);

    int getMinedGold();

    void setMinedGold(int gold);

    int getMinedIron();

    void setMinedIron(int iron);

    Player getPlayer();

    boolean isMainHost();

    boolean hasHostAccess();

    AbstractTeam getTeam();

    void setTeam(AbstractTeam team);

    AbstractRole getRole();

    void setRole(AbstractRole role);

    boolean isAlive();

}

