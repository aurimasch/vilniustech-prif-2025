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
            int attempts = 0;
            boolean found = false;
            while (attempts < 4) {
                boolean pathClear = true;
                int moveDist = ghost.getMoveDistance();
                for (int step = 1; step <= moveDist; step++) {
                    int nextX = ghost.getX() + ghost.dx * step;
                    int nextY = ghost.getY() + ghost.dy * step;
                    if (map.isWall(nextX, nextY)) {
                        pathClear = false;
                        break;
                    }
                }
                if (pathClear) {
                    found = true;
                    break;
                }
                ghost.changeDirection();
                attempts++;
            }
            if (found) {
                ghost.move();
            }

            if (pacman.collidesWith(ghost)) {
                System.out.println("Game Over!");
                System.exit(0);
            }

            if (pacman.getSteps() >= 20)
                changeStaticGhostsToFast();

        }
    }

    private void changeStaticGhostsToFast() {
        for (Ghost ghost : ghosts) {
            if (ghost.getMoveBehaviour() instanceof NoMoveBehaviour) {
                ghost.setMoveBehaviour(new FastMoveBehaviour());
            }
        }
    }
}
