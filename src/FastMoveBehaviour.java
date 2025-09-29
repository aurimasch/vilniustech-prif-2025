import java.util.Random;

public class FastMoveBehaviour implements MoveBehaviour {
    @Override
    public void changeDirection(Ghost ghost) {
        // Randomly choose one of four directions: up, down, left, right
        Random rand = new Random();
        int dir = rand.nextInt(4);
        switch (dir) {
            case 0: // up
                ghost.setDx(0);
                ghost.setDy(-1);
                break;
            case 1: // down
                ghost.setDx(0);
                ghost.setDy(1);
                break;
            case 2: // left
                ghost.setDx(-1);
                ghost.setDy(0);
                break;
            case 3: // right
                ghost.setDx(1);
                ghost.setDy(0);
                break;
        }
    }

    @Override
    public void move(Ghost ghost) {
        ghost.setX(ghost.getX() + ghost.getDx() * 2);
        ghost.setY(ghost.getY() + ghost.getDy() * 2);
    }
}
