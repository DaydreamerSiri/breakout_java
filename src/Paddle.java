package src;

import java.awt.*;
/**
 * Klasse des Paddle Objekts im Breakout Spiel
 * @author Sehri Singh
 * @author Tjark Jansen
 */

public class Paddle extends GameObject {
    private Integer xVelocityPaddle;
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
    public void setxVelocityPaddle(int xVelocityPaddle) {
        this.xVelocityPaddle = xVelocityPaddle;
    }

    /**
     * Methode gibt Geschwindigkeit des Paddles wieder
     */
    public Integer getXVelocityPaddle(){
        return this.xVelocityPaddle;
    }
}
