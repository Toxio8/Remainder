package fr.toxio.uhc.core.module.win;

import fr.toxio.uhc.api.UHCAPI;
import fr.toxio.uhc.api.module.win.IWinManager;
import fr.toxio.uhc.api.player.IUHCProfile;
import fr.toxio.uhc.api.player.ProfileStates;
import org.bukkit.Bukkit;

import java.util.List;

public class WinManager implements IWinManager {

    private boolean win;

    @Override
    public boolean checkWin() {
        return this.win = false;
    }

    @Override
    public void onWin() {
        List<IUHCProfile> alivePlayers = UHCAPI.get().getPlayerManager().getProfile(ProfileStates.PLAYING);
       if (alivePlayers.size() <= 1 ) {
           Bukkit.broadcastMessage("La partie est terminer " + alivePlayers.get(0) + " a gagné(e)");
       }
    }

    @Override
    public boolean isWin() {
        return win;
    }

    @Override
    public void setWin(boolean win) {
        this.win = win;
    }
}
