import java.util.List;

public class GameRenderer {

    private Map map;
    private List<Ghost> ghosts;
    private Pacman pacman;

    public GameRenderer(Map map, List<Ghost> ghosts, Pacman pacman) {
        this.map = map;
        this.ghosts = ghosts;
        this.pacman = pacman;
    }

    public void render() {
        for (int i = 0; i < map.getHeight(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {
                if (map.isWall(i, j))
                    System.out.print("#");
                else
                    System.out.print(" ");

                if (i == pacman.getX() && j == pacman.getY())
                    System.out.print("C");

                for (Ghost ghost : ghosts)
                    if (i == ghost.getX() && j == ghost.getY())
                        System.out.print("G");
            }
            System.out.println();
        }
    }
}
