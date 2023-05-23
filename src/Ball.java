import java.awt.*;

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
     * @param obj das Ballobjekt als src.GameLogic Typ
     * @param xPos die X-Position des Balls als Integer
     * @param yPos die Y-Position des Balls als Integer
     * @param xSize die Breite des Balls als Integer
     * @param ySize die Höhe des Balls als Integer
     */
    public Ball(GameLogic obj, Integer xPos, Integer yPos, Integer xSize, Integer ySize, Color color) {
        super(obj, xPos, yPos, xSize, ySize, color);
    }

    /**
     * Methode um die Beschleunigung des Balls zu setzen
     * @param xVelocity die X-Beschleunigung des Balls als Integer
     * @param yVelocity die Y-Beschleunigung des Balls als Integer
     */
    public void setVelocity(Integer xVelocity, Integer yVelocity) {
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
    }

    /**
     * Getter Methode um die X-Beschleunigung zu bekommen
     * @return die X-Beschleunigung als Integer
     */
    public Integer getXVelocity() {

        return this.xVelocity;
    }

    /**
     * Getter Methode um die Y-Beschleunigung zu bekommen
     * @return die Y-Beschlunigung als Integer
     */
    public Integer getYVelocity() {
        return this.yVelocity;
    }

    public void render(Graphics graphics) {
        graphics.setColor(color);
        graphics.fillOval(xPosition - xSize / 2, yPosition - ySize / 2, xSize, ySize);
    }
}
