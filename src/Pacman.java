public class Pacman implements ConsoleRenderable {

    private int x = 1;
    private int y = 1;

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
    }

    public void moveRight() {
        y++;
    }

    public void moveUp() {
        x--;
    }

    public void moveDown() {
        x++;
    }

    public boolean collidesWith(Ghost ghost) {
        return this.x == ghost.getX() && this.y == ghost.getY();
    }

    @Override
    public void render(int i, int j) {
        if (i == getX() && j == getY())
            System.out.print("C");
    }
}
