import java.awt.*;
/**
 * Klasse des Paddle Objekts im Breakout Spiel
 * @author Sehri Singh
 * @author Tjark Jansen
 */

public class Paddle extends GameObject {
    private Integer xVelocity = 0;
    /**
    Konstruktor für die Paddle Klasse
     @param obj das Paddleobjekt als src.Ball.GameLogic Typ
     @param xPos die X-Position des Paddles als Integer
     @param yPos die Y-Position des Paddles als Integer
     @param xSize die Breite des Paddles als Integer
     @param ySize die Höhe des Paddles als Integer
     @param color die  Farbe des Paddles
     **/
    public Paddle(GameLogic obj, Integer xPos, Integer yPos, Integer xSize, Integer ySize, Color color) {
        super(obj,xPos,yPos,xSize,ySize,color);
    }

    /**
     * Methode setzt Geschwindigkeit des Paddles fest
     */
    public void setVelocity(int xVelocity) {
        this.xVelocity = xVelocity;
    }

    /**
     * Methode gibt Geschwindigkeit des Paddles wieder
     */
    public Integer getVelocity() {
        return this.xVelocity;
    }

    public void move() {
        xPosition += xVelocity;
        int xHalf = xSize / 2;
        if (xPosition < xHalf) {
            xPosition = xHalf;
        } else if (xPosition >= Configuration.FIELD_X_SIZE - xHalf) {
            xPosition = Configuration.FIELD_X_SIZE - xHalf;
        }
    }

    public void render(Graphics graphics) {
        graphics.setColor(color);
        graphics.fillRect(xPosition - xSize / 2, yPosition - ySize / 2, xSize, ySize);
    }

    public Rectangle getHitBox() {
        Rectangle hitbox = new Rectangle();
        hitbox.height = this.getHeight();
        hitbox.width = this.getWidth();
        hitbox.y = this.getYPosition();
        hitbox.x = this.getXPosition();
        System.out.println(hitbox + "Paddle");
        return hitbox;
    }

}
