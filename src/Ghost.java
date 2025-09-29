public abstract class Ghost implements ConsoleRenderable {

    protected int x = 10;
    protected int y = 10;

    protected int dx = 0;
    protected int dy = 1;

    protected MoveBehaviour moveBehaviour;

    public Ghost(int x, int y, MoveBehaviour behaviour) {
        this.x = x;
        this.y = y;
        this.moveBehaviour = behaviour;
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
        moveBehaviour.changeDirection(this);
    };

    public void move() {
        moveBehaviour.move(this);
    }

    public int getMoveDistance() {
        return 1;
    }

    @Override
    public void render(int i, int j) {
        if (i == getX() && j == getY())
            System.out.print("G");
    }

    public Ghost setX(int x) {
        this.x = x;
        return this;
    }

    public Ghost setY(int y) {
        this.y = y;
        return this;
    }

    public int getDx() {
        return dx;
    }

    public Ghost setDx(int dx) {
        this.dx = dx;
        return this;
    }

    public int getDy() {
        return dy;
    }

    public Ghost setDy(int dy) {
        this.dy = dy;
        return this;
    }
}
