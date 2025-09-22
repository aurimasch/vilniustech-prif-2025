public class GameRules {

    private Map map;
    private Ghost ghost;
    private Pacman pacman;

    public GameRules(Map map, Ghost ghost, Pacman pacman) {
        this.map = map;
        this.ghost = ghost;
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
        if (map.isWall(ghost.getNextX(), ghost.getNextY())) {
            ghost.changeDirection();
        }
        ghost.move();

        if (pacman.collidesWith(ghost)) {
            System.out.println("Game Over!");
            System.exit(0);
        }
    }
}
