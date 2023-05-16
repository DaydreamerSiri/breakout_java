package src;

import java.awt.*;

public class Brick extends GameObject {
    private boolean isDestroyed;
    public Brick(GameLogic obj, Integer xPos, Integer yPos, Integer xSize, Integer ySize, Color color) {
        super(obj, xPos, yPos, xSize, ySize, color);
    }

    public boolean isDestroyed() {
        return this.isDestroyed;
    }

    public void setDestroyed() {
    }
    public void isIntact() {
    }
}
