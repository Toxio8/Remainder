package fr.toxio.uhc.api.worldgen;

import org.bukkit.Material;

public class BlockParameters {

    public Material id;

    public int data;

    public int minY;

    public int maxY;

    public double round;

    public double size;

    public BlockParameters(Material type, int data, double round, int minY, int maxY, double size) {
        this.id = type;
        this.data = data;
        this.round = round;
        this.minY = minY;
        this.maxY = maxY;
        this.size = size;
    }
}
