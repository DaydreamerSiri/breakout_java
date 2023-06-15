import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Break Out");
        // exit application on close
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // show window in the center of the screen
        frame.setLocationRelativeTo(null);
        // window is not resizable
        frame.setResizable(false);
        // Game Logic with set Bricks Arrays
        GameLogic gl = new GameLogic(3, 0);
        frame.add(gl);
        // arrange components
        frame.pack();
        // show window
        frame.setVisible(true);
        gl.setDifficulty(1,1);
        gl.start();
    }


}