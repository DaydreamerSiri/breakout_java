import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.*;
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

    private Timer timer;

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
        setFocusable(true);
        addKeyListener(new BreakoutKeyAdapter());
    }

    /**
     * Private Klasse welches die KeyEvents überschreibt
     */
    private class BreakoutKeyAdapter extends KeyAdapter {
        /**
         * Methode für das loslassen einer Taste
         * @param event the event to be processed
         */
        @Override
        public void keyReleased(KeyEvent event) {
            onKeyReleased(event);
        }
        /**
         * Methode für das gedrückt halten einer Taste
         * @param event the event to be processed
         */
        @Override
        public void keyPressed(KeyEvent event) {
            onKeyPressed(event);
        }
    }

    /**
     * Methode welches beim gedrückt halten einer Taste ausgeführt wird
     * @param event das KeyEvent welches gedrückt wurde
     */
    void onKeyPressed(KeyEvent event) {

        if (event.getKeyCode() == KeyEvent.VK_D) {
            System.out.println("Key has been pressed");
            this.paddle.setVelocity(Configuration.PADDLE_VELOCITY * 2);
        }
        if (event.getKeyCode() == KeyEvent.VK_A) {
            System.out.println("Key has been pressed");
            this.paddle.setVelocity(-Configuration.PADDLE_VELOCITY * 2);
        }
    }

    /**
     * Methode welches beim loslassen einer Taste ausgeführt wird
     * @param event das KeyEvent welches gedrückt wurde
     */
    void onKeyReleased(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_D || event.getKeyCode() == KeyEvent.VK_A) {
            this.paddle.setVelocity(0);
        }
    }

    /**
     * Methode welches das Breakout game startet
     */
    public void start() {
        GameState state = GameState.RUNNING;
        timer = new Timer(Configuration.LOOP_PERIOD + 30, new GameLoop());
        timer.start();
    }

    /**
     *  Private Klasse bei dem der Gameloop festgelegt wird
     */
    private class GameLoop implements ActionListener {
        /**
         * Führt den Gameloop des Breakoutspiel durchs.
         * @param e der Event welches bearbeitet wird
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            onTick();
        }
    }

    /**
        Methode welches eine bestimmte Reihenfolge von Ausführungen ausführt während eines Ticks des Timers
     */
    private void onTick() {

        Rectangle ballHitBox = ball.getHitBox();
        Rectangle nextX = new Rectangle(ballHitBox);
        nextX.setLocation(nextX.x + ball.getXVelocity(), nextX.y);
        Rectangle nextY = new Rectangle(ballHitBox);
        nextY.setLocation(nextY.x, nextY.y + ball.getYVelocity());
        this.ball.move();
        paddle.move();

        // check physics and rules
        if (ball.getHitBox().intersects(paddle.getHitBox())) { // ball hits paddle
            System.out.println(ball.getHitBox().intersects(paddle.getHitBox()));
            ball.setVelocity(ball.getXVelocity(), -ball.getYVelocity());
        } else if (ball.yPosition > Configuration.PADDLE_Y_POSITION) { // ball is lost
            // reduce number of balls
            --ballCount;
            if (ballCount <= 0) { // no balls left
                GameState state = GameState.GAME_OVER;
                System.out.printf("Game over: You lost. Score = %d%n", score);
                System.exit(-1);
            } else { // at least one ball left, continue level
                restartWithNewBall();
            }
        }

        Brick hitBrick = null;
        for (Brick brick : bricks) {
            if (brick.getHitBox().intersects(nextX)) { // hit in the west or east
                ball.setVelocity(-ball.getXVelocity(), ball.getYVelocity());
                hitBrick = brick;
                break;
            }
            if (brick.getHitBox().intersects(nextY)) { // hit in the north or south
                ball.setVelocity(ball.getXVelocity(), -ball.getYVelocity());
                hitBrick = brick;
                break;
            }
        }
        if (hitBrick != null) { // if hit brick then remove it and score
            bricks.remove(hitBrick);
            score += Configuration.BRICK_SCORE;
        } else if (bricks.isEmpty()) {
            System.out.println("Game Over");
            System.out.println("Reached Highscore:");
            System.out.println(score);
            GameState state = GameState.GAME_OVER;
        }

        repaint();
    }

    /**
     * Methode welches beim verlieren eines Balls die Position des Schlägers und Balls zurücksetzt
     */
    private void restartWithNewBall() {
        this.ball.yPosition = Configuration.PADDLE_Y_POSITION;
        this.ball.xPosition = restartXPosition;
        this.paddle.xPosition = restartXPosition;
        this.paddle.yPosition = Configuration.PADDLE_Y_POSITION;
    }

    /**
     * Setzt die Spielgeschwindigkeit vom Ball fest
     * @param xspeed die x-Geschwindigkeit des Balls als int
     * @param yspeed die y-Geschwindigkeit des Balls als int
     */
    public void setDifficulty(int xspeed, int yspeed) {
        this.ball.setVelocity(xspeed, yspeed);
    }

    /**
     * Generiert die Spielfläche
     */
    private void genField() {
        this.paddle = new Paddle(this, 160,280,Configuration.PADDLE_X_SIZE,Configuration.PADDLE_Y_SIZE, Color.BLUE);
        this.ball = new Ball(this, 160, this.paddle.yPosition - 60, Configuration.BALL_Y_SIZE, Configuration.BALL_X_SIZE, Color.BLACK);
        this.bricks = new HashSet<>();
        for(int row = 0; row <= 3; row++){
            for(int i = 0; i <= 3; i++) {
                bricks.add(new Brick(this, 70 + (i*60),30 + (row * 55),Configuration.BRICK_X_SIZE,Configuration.BRICK_Y_SIZE,Color.red));
            }
        }
    }

    /**
     * Generiert die erstellten Objekte auf dem Spielfeld
     * @param graphics the <code>Graphics</code> object to protect
     */
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
