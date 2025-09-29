import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class WindowsMain extends JFrame {

    private Map map = new Map();
    private Ghost simpleGhost = new SimpleGhost(10, 10, new NormalMoveBehaviour());
    private Ghost smartGhost = new SmartGhost(12, 12, new FastMoveBehaviour());
    private Ghost staticGhost = new StaticGhost(5, 5, new NoMoveBehaviour());

    private List<Ghost> ghosts = List.of(simpleGhost, smartGhost, staticGhost);    private Pacman pacman = new Pacman(1, 1);

    private GameRules gameRules = new GameRules(map, ghosts, pacman);

    private WindowsRenderer windowsRenderer;

    public WindowsMain() throws Exception {
        super.setPreferredSize(new Dimension(1500, 900));
        super.pack();
        super.setVisible(true);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);

        windowsRenderer =  new WindowsRenderer(map, ghosts, pacman);

        super.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                char userInput = e.getKeyChar();

                gameRules.processUserInput(userInput);

                repaint();
            }
        });

        new Timer(300, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                gameRules.progressFrame();
                repaint();
            }
        }).start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        windowsRenderer.render(g);
    }

    public static void main(String s[]) throws InvocationTargetException, InterruptedException {
        SwingUtilities.invokeAndWait(new Runnable() {

            @Override
            public void run() {
                try {
                    new WindowsMain();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

