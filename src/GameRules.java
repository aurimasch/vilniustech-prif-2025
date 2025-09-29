import java.util.List;

public class GameRules {

    private Map map;
    private List<Ghost> ghosts;
    private Pacman pacman;

    public GameRules(Map map, List<Ghost> ghosts, Pacman pacman) {
        this.map = map;
        this.ghosts = ghosts;
        this.pacman = pacman;
    }

    public void processUserInput(int n) {
        if (n == 'a' && !map.isWall(pacman.getX(), pacman.getY() - 1))
            pacman.moveLeft();
        if (n == 'd' && !map.isWall(pacman.getX(), pacman.getY() + 1))
            pacman.moveRight();
        if (n == 'w' && !map.isWall(pacman.getX() - 1, pacman.getY()))
            pacman.moveUp();
        if (n == 's' && !map.isWall(pacman.getX() + 1, pacman.getY()))
            pacman.moveDown();
    }

    public void progressFrame() {
        for (Ghost ghost : ghosts) {
            // Try to find a valid direction if facing a wall
            int attempts = 0;
            while (map.isWall(ghost.getNextX(), ghost.getNextY()) && attempts < 4) {
                ghost.changeDirection();
                attempts++;
            }
            // Only move if the next cell is not a wall
            if (!map.isWall(ghost.getNextX(), ghost.getNextY())) {
                ghost.move();
            }

            if (pacman.collidesWith(ghost)) {
                System.out.println("Game Over!");
                System.exit(0);
            }
        }

    }
}
