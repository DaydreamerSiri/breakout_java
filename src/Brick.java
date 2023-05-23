import java.awt.*;

/**
 * Die Klasse für die einzelnen Blöcke im Spiel
 * @author Sehri Singh
 * @author Tjark Jansen
 */
public class Brick extends GameObject {
    private boolean isDestroyed;

    /**
     * Konstruktor Methode für Brick Klasse
     * @param obj die GameLogic obj als GameLogic
     * @param xPos die x-Position des Blocks als Integer
     * @param yPos die y-Position des Blocks als Integer
     * @param xSize die Breite des Blocks als Integer
     * @param ySize die Höhe des Blocks als Integer
     * @param color die Farbe des Blocks als Color
     */
    public Brick(GameLogic obj, Integer xPos, Integer yPos, Integer xSize, Integer ySize, Color color) {
        super(obj, xPos, yPos, xSize, ySize, color);
    }

    /**
     * Abfrage Methode um zu schauen ob der Block zerstört ist oder nicht
     * @return der Status ob es zerstört ist als boolean
     */
    public boolean isDestroyed() {
        return this.isDestroyed;
    }

    /**
     * Setzt den Block als zerstört
     */
    public void setDestroyed() {
    }

    /**
     * Setzt den Block als aktiv im Spiel
     */
    public void isIntact() {
    }
}
