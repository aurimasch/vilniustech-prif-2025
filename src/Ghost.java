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
        int temp = dx;
        dx = dy;
        dy = -temp;
    }

    public void move() {
        x += dx;
        y += dy;
    }
}
