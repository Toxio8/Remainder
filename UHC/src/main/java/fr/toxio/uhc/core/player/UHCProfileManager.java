package fr.toxio.uhc.core.player;


import com.google.common.collect.Lists;
import fr.toxio.uhc.api.player.IUHCProfile;
import fr.toxio.uhc.api.player.IUHCProfileManager;
import fr.toxio.uhc.api.player.ProfileStates;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class UHCProfileManager implements IUHCProfileManager {

    public HashMap<UUID,IUHCProfile> profiles = new HashMap<>();

    @Override
    public HashMap<UUID, IUHCProfile> getProfiles() {
        return profiles;
    }

    @Override
    public IUHCProfile getProfile(Player player) {
        return getProfiles().computeIfAbsent(player.getUniqueId(),uuid -> new UHCProfile(player.getUniqueId()));
    }
    @Override
    public List<IUHCProfile> getProfile(ProfileStates uhcProfile) {
        List<IUHCProfile> profiles1 = Lists.newArrayList();
        for (IUHCProfile uhcProfile1 : profiles.values()) {
            if (uhcProfile1.getProfileStates().equals(uhcProfile)) {
                profiles1.add(uhcProfile1);
                return profiles1;
            }
        }
        return null;
    }
    @Override
    public IUHCProfile getProfile(UUID uuid) {
        return getProfiles().compute(uuid,(uuid1, profile) -> new UHCProfile(uuid));
    }
}
