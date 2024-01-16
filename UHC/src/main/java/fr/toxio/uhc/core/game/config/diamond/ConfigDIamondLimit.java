package fr.toxio.uhc.core.game.config.diamond;

import fr.toxio.uhc.api.game.config.diamond.IConfigDiamondLimit;

public class ConfigDIamondLimit implements IConfigDiamondLimit {

    int diamondLimit = -1;
    @Override
    public int getDiamondLimit() {
        return diamondLimit;
    }

    @Override
    public void setDiamondLimit(int limit) {
        this.diamondLimit = limit;
    }
}
