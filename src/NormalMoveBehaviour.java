public class NormalMoveBehaviour implements MoveBehaviour {

    @Override
    public void changeDirection(Ghost ghost) {
        int temp = ghost.getDx();
        ghost.setDx(ghost.getDy());
        ghost.setDy(-temp);
    }

    @Override
    public void move(Ghost ghost) {
        ghost.setX(ghost.getX() + ghost.getDx());
        ghost.setY(ghost.getY() + ghost.getDy());
    }
}
