public abstract class Ghost {

    protected int x = 10;
    protected int y = 10;

    protected int dx = 0;
    protected int dy = 1;

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

    public abstract void changeDirection();

    public abstract void move();

    public int getMoveDistance() {
        return 1;
    }


}
