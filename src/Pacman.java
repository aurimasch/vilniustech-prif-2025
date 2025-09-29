public class Pacman implements ConsoleRenderable {

    private int x = 1;
    private int y = 1;

    private int steps = 0;

    public Pacman(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void moveLeft() {
        y--;
        steps++;
    }

    public void moveRight() {
        y++;
        steps++;
    }

    public void moveUp() {
        x--;
        steps++;
    }

    public void moveDown() {
        x++;
        steps++;
    }

    public boolean collidesWith(Ghost ghost) {
        return this.x == ghost.getX() && this.y == ghost.getY();
    }

    public int getSteps() {
        return steps;
    }

    @Override
    public void render(int i, int j) {
        if (i == getX() && j == getY())
            System.out.print("C");
    }
}
