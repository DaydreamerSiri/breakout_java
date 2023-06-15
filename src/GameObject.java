import java.awt.*;

/**
 * Parent-Klasse für die einzelnen Spielobjekte
 * @author Sehri Singh
 * @author Tjark Jansen
 */
public class GameObject {
    protected Color color;
    protected Integer yPosition;
    protected Integer xPosition;
    protected Integer xSize;
    protected Integer ySize;

    /**
     * Konstruktor Klasse für die Spielobjekte
     * @param obj das Spielobjekt als src.GameLogic Type
     * @param xPos die x-Position des Spielobjekts als Integer
     * @param yPos die y-Position des Spielobjekts als Integer
     * @param xSize die Breite des Spielobjekts als Integer
     * @param ySize die Höhe des Spielobjekts als Integer
     */
    public GameObject(GameLogic obj, Integer xPos, Integer yPos, Integer xSize, Integer ySize, Color color) {
        this.xPosition = xPos;
        this.yPosition = yPos;
        this.xSize = xSize;
        this.ySize = ySize;
        this.color = color;
    }

    /**
     * Setzt die Position des Spielobjekts
     * @param xPos die X Position im Koordinatensystem
     * @param yPos die Y Position im Koordinatensystem
     */
    public void SetPosition(int xPos, int yPos) {
        this.xPosition = xPos;
        this.yPosition = yPos;
    }

    /**
     * Gibt die Breite des Spielobjekts zurück
     * @return Breite als Integer
     */
    public Integer getWidth() {
        return this.xSize;
    }

    /**
     * Gibt die Höhe des Spielobjekts zurück
     * @return Die Höhe als Integer
     */
    public Integer getHeight() {
        return this.ySize;
    }

    /**
     * Gibt die Y-Position des Spielobjekts im Koordinatensystem zurück
     * @return die Y-Position als Integer
     */
    public Integer getYPosition() {
        return this.yPosition;
    }

    /**
     * Gibt die X-Position des Spielobjekts im Koordinatensystem zurück
     * @return
     */
    public Integer getXPosition() {
        return this.xPosition;
    }

    /**
     * Gibt die Hitbox des Spielobjekts zurück
     * @return die Hitbox des Spielobjekts
     */
    public Rectangle getHitBox() {
        Rectangle Hitbox = null;
        return Hitbox;
    }

}
