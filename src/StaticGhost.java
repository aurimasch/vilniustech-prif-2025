public class StaticGhost extends Ghost {

    public StaticGhost(int x, int y, MoveBehaviour behaviour) {
        super(x, y, behaviour);
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
