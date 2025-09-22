import java.io.IOException;
import java.util.Scanner;


public class Main {

    static Pacman pacman = new Pacman(1, 1);
    static Ghost ghost = new Ghost(10, 10);
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

    private static Scanner scanner = new Scanner(System.in);

    private static Integer getUserInput() {
        if (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.length() == 0) return null;
            return (int) line.charAt(0);
        }
        return null;
    }

}
