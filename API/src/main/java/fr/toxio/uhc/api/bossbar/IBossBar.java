package fr.toxio.uhc.api.bossbar;

import org.bukkit.Color;

import java.util.UUID;

public interface IBossBar {


    String getTitle();

    float getHealthPercent();

    Color getColor();

    UUID getId();

    boolean isDarkenScreen();

    boolean isSeePartial();
}
