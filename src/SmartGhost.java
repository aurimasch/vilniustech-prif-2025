import java.util.Random;

public class SmartGhost extends Ghost {

    public SmartGhost(int x, int y) {
        super(x, y);
    }

    @Override
    public void changeDirection() {
        // Randomly choose one of four directions: up, down, left, right
        Random rand = new Random();
        int dir = rand.nextInt(4);
        switch (dir) {
            case 0: // up
                dx = 0; dy = -1;
                break;
            case 1: // down
                dx = 0; dy = 1;
                break;
            case 2: // left
                dx = -1; dy = 0;
                break;
            case 3: // right
                dx = 1; dy = 0;
                break;
        }
    }

    @Override
    public void move() {
        x += dx*2;
        y += dy*2;
    }

    @Override
    public int getMoveDistance() {
        return 2;
    }
}
