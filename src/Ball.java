package src;

import src.GameObject;

/**
 * Klasse des Ball Objekts im Breakout Spiel
 * @author Sehri Singh
 * @author Tjark Jansen
 */
public class Ball extends GameObject {
    private Integer xVelocity;
    private Integer yVelocity;

    /**
     * Konstruktor für die Ballklasse
     * @param obj das Ballobjekt als GameLogic Typ
     * @param xPos die X-Position des Balls als Integer
     * @param yPos die Y-Position des Balls als Integer
     * @param xSize die Breite des Balls als Integer
     * @param ySize die Höhe des Balls als Integer
     */
    public Ball(GameLogic obj, Integer xPos, Integer yPos, Integer xSize, Integer ySize) {
        super(obj, xPos, yPos, xSize, ySize);
    }

    /**
     * Methode um die B
     * @param xVelocity
     * @param yVelocity
     */
    public void setVelocity(Integer xVelocity, Integer yVelocity) {
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
    }

    public Integer getXVelocity() {
        return this.xVelocity;
    }
    public Integer getYVelocity() {
        return this.yVelocity;
    }
}
