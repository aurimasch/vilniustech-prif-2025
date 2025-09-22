public class Ghost {

    private int x = 10;
    private int y = 10;

    private int dx = 0;
    private int dy = 1;

    public Ghost(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getNextX() {
        return x + dx;
    }

    public int getNextY() {
        return y + dy;
    }

    public void changeDirection() {
        if (dx == 1 && dy == 0) {
            dx = 0;
            dy = 1;
        }
        else if (dx == 0 && dy == 1) {
            dx = -1;
            dy = 0;
        } else if (dx == -1 && dy == 0) {
            dx = 0;
            dy = -1;
        } else if (dx == 0 && dy == -1) {
            dx = 1;
            dy =0;
        }
    }

    public void move() {
        x += dx;
        y += dy;
    }
}
