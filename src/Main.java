import java.io.IOException;
import java.util.List;

public class Main {

    static Pacman pacman = new Pacman(1, 1);
    static List<Ghost> ghost = List.of(new Ghost(10, 10));
    static Map map = new Map();

    static GameRules gameRules = new GameRules(map, ghost, pacman);
    static GameRenderer gameRenderer = new GameRenderer(map, ghost, pacman);


    public static void main(String[] args) throws IOException {

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
