package fr.toxio.uhc.api.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.Random;

public class GlobalUtils {

    public static final Random RANDOM = new Random();

    public static boolean isInsideBorder(Location location, double borderSize) {
        double x = location.getX();
        double z = location.getZ();
        return Math.abs(x) <= borderSize && Math.abs(z) <= borderSize;
    }

    public static Location getRandomLocationInsideBorder(double borderSize) {
        Random random = RANDOM;
        double x = (random.nextDouble() - 0.5) * 2 * borderSize;
        double z = (random.nextDouble() - 0.5) * 2 * borderSize;
        return new Location(Bukkit.getWorld("world"), x, 0, z);
    }
}
