package fr.toxio.uhc.core.game.config.enchant;

import fr.toxio.uhc.api.game.config.enchant.IConfigEnchant;

public class ConfigEnchant implements IConfigEnchant {

    private int ironProtection = 4;
    private int diamondProtection = 4;
    private int ironSwordSharpness = 5;
    private int diamondSwordSharpness = 5;


    @Override
    public int getIronProtection() {
        return ironProtection;
    }
    @Override
    public void setIronProtection(int ironProtection) {
        this.ironProtection = ironProtection;
    }
    @Override
    public int getDiamondProtection() {
        return diamondProtection;
    }
    @Override
    public void setDiamondProtection(int diamondProtection) {
        this.diamondProtection = diamondProtection;
    }
    @Override
    public int getIronSwordSharpness() {
        return ironSwordSharpness;
    }
    @Override
    public void setIronSwordSharpness(int ironSwordSharpness) {
        this.ironSwordSharpness = ironSwordSharpness;
    }
    @Override
    public int getDiamondSwordSharpness() {
        return diamondSwordSharpness;
    }
    @Override
    public void setDiamondSwordSharpness(int diamondSwordSharpness) {
        this.diamondSwordSharpness = diamondSwordSharpness;
    }
}
