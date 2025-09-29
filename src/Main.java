import java.io.IOException;
import java.util.List;

public class Main {

    Pacman pacman = new Pacman(1, 1);
    List<Ghost> ghosts = List.of(new SimpleGhost(10, 10), new SmartGhost(11, 11), new StaticGhost(5, 5));
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
