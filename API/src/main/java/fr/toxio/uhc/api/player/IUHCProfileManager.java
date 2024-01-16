package fr.toxio.uhc.api.player;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public interface IUHCProfileManager {

    HashMap<UUID, IUHCProfile> getProfiles();

    IUHCProfile getProfile(Player player);

    List<IUHCProfile> getProfile(ProfileStates uhcProfile);

    IUHCProfile getProfile(UUID uuid);
}

