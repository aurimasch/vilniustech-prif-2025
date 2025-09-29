public class SimpleGhost extends Ghost {

    public SimpleGhost(int x, int y) {
        super(x, y);
    }

    @Override
    public void changeDirection() {
        int temp = dx;
        dx = dy;
        dy = -temp;
    }


}
