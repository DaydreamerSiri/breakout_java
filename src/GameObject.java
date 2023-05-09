package src;
import java.awt.*;

/**
 * Parent-Klasse für die einzelnen Spielobjekte
 * @Author Sehri Singh
 * @Author Tjark Jansen
 */
public class GameObject {
    private Color farbe;
    private Integer yPosition;
    private Integer xPosition;
    private Integer xSize;
    private Integer ySize;
    public GameObject(GameLogic obj, Integer xPos, Integer yPos, Integer xSize, Integer ySize) {
        this.xPosition = xPos;
        this.yPosition = yPos;
        this.xSize = xSize;
        this.ySize = ySize;
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
    public Integer getHeigth() {
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
