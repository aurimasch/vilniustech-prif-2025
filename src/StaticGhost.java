public class StaticGhost extends Ghost {

    public StaticGhost(int x, int y) {
        super(x, y);
    }

    @Override
    public void changeDirection() {
        //ignore
    }

    @Override
    public void move() {
        //ignore
    }
}
