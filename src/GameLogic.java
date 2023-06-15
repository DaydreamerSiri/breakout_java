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


    private class BreakoutKeyAdapter extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent event) {
            onKeyReleased(event);
        }
        @Override
        public void keyPressed(KeyEvent event) {
            onKeyPressed(event);
        }
    }

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
    void onKeyReleased(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_D || event.getKeyCode() == KeyEvent.VK_A) {
            this.paddle.setVelocity(0);
        }
    }


    public void start() {
        GameState state = GameState.RUNNING;
        timer = new Timer(Configuration.LOOP_PERIOD + 30, new GameLoop());
        timer.start();
    }

    private class GameLoop implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            onTick();
        }
    }

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
            //--ballCount;
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
        }

        repaint();
    }

    private void restartWithNewBall() {
        this.ball.yPosition = this.paddle.yPosition - 60;
        this.ball.xPosition = 160;
    }

    public void setDifficulty(int xspeed, int yspeed) {
        this.ball.setVelocity(xspeed, yspeed + 2);
    }

    private void genField() {
        this.paddle = new Paddle(this, 160,280,Configuration.PADDLE_X_SIZE,Configuration.PADDLE_Y_SIZE, Color.BLUE);
        this.ball = new Ball(this, 160, this.paddle.yPosition - 60, Configuration.BALL_Y_SIZE, Configuration.BALL_X_SIZE, Color.BLACK);
        this.bricks = new HashSet<>();
        for(int row = 0; row < 3; row++){
            for(int i = 0; i < 4; i++) {
                bricks.add(new Brick(this, 70 + (i*60),30 + (row * 55),Configuration.BRICK_X_SIZE,Configuration.BRICK_Y_SIZE,Color.red));
            }
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
