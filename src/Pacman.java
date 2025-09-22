public class Pacman {

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
}
