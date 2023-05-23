import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

/**
 *Klasse um die Anzahl der Bälle, sowie den Spielscore wiedergibt
 * @Author Tjark Jansen
 * @Author Sehri Singh
 */
public class GameLogic extends JPanel {
    private int ballCount;
    private int score;
    Set<Brick> bricks;
    Paddle paddle;
    Ball ball;

    /**
     * Konstruktor Methode
     * @param ballCount Anzahl der noch verfügbaren Bälle
     * @param score Anzahl der verdienten Punkte
     */
    public GameLogic(int ballCount, int score){
        this.ballCount = ballCount;
        this.score = score;
        this.genField();
        setPreferredSize(new Dimension(Configuration.FIELD_Y_SIZE, Configuration.FIELD_X_SIZE));
    }
    private void genField() {
        this.paddle = new Paddle(this, 160,280,75,50, Color.BLUE);
        this.ball = new Ball(this, 160, this.paddle.yPosition - 60, 50,50, Color.BLACK);
        this.bricks = new HashSet<>();
        for(int i = 0; i < 20; i++) {
            bricks.add(new Brick(this, ,30 + (i),50,50,Color.red));
        }
    }
    @Override
    public void paintComponent(Graphics graphics) {
        // paint panel
        super.paintComponent(graphics);
        // configure rendering pipeline: Enable antialiasing and high render quality
        Graphics2D g2d = (Graphics2D) graphics;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        // render bricks, paddle and ball
        for (Brick brick: bricks) {
            brick.render(graphics);
        }
        paddle.render(graphics);
        ball.render(graphics);
        // synchronize graphics state
        Toolkit.getDefaultToolkit().sync();
    }

}
