import java.io.IOException;
import java.util.List;

public class Main {

    Pacman pacman = new Pacman(1, 1);

    Ghost simpleGhost = new SimpleGhost(10, 10, new NormalMoveBehaviour());
    Ghost smartGhost = new SmartGhost(12, 12, new FastMoveBehaviour());
    Ghost staticGhost = new StaticGhost(5, 5, new NoMoveBehaviour());

    List<Ghost> ghosts = List.of(simpleGhost, smartGhost, staticGhost);
    Map map = new Map();

    GameRules gameRules = new GameRules(map, ghosts, pacman);
    GameRenderer gameRenderer = new GameRenderer(map, ghosts, pacman);


    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        while (true) {
            gameRenderer.render();

            Integer read = getUserInput();
            if (read == null)
                continue;

            gameRules.processUserInput(read);
            gameRules.progressFrame();
        }
    }

    private static Integer getUserInput() throws IOException {
        int read = System.in.read();
        if (read == 10)
            return null;
        return read;
    }

}
