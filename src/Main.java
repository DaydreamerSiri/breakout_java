import java.awt.*;

public class Main {
    public static void main(String[] args) {
        GameLogic gl = new GameLogic(1, 0);
        Ball ball = new Ball(gl, 1, 1, 10,10, Color.red);
        System.out.println(ball.getHeigth());
    }
}