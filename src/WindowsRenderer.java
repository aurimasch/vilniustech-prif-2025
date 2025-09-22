import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class WindowsRenderer {

    private Map map;
    private Ghost ghost;
    private Pacman pacman;

    private BufferedImage pacmanImage;
    private BufferedImage ghostImage;
    private BufferedImage wallImage;

    public WindowsRenderer(Map map, Ghost ghost, Pacman pacman) throws IOException {
        this.map = map;
        this.ghost = ghost;
        this.pacman = pacman;

        loadImageResources();
    }

    private void loadImageResources() throws IOException {
        pacmanImage = ImageIO.read(new FileInputStream("pacman-open.png"));
        ghostImage = ImageIO.read(new FileInputStream("ghost.png"));
        wallImage = ImageIO.read(new FileInputStream("wall.png"));
    }

    public void render(Graphics g) {
        for (int i = 0; i < map.getHeight(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {
                if (map.isWall(i, j)) {
                    g.drawImage(wallImage, j * 32, i * 32 + 25, null);
                } else if (pacman.getX() == i && pacman.getY() == j) {
                    g.drawImage(pacmanImage, j * 32, i * 32 + 25, null);
                } else if (ghost.getX() == i && ghost.getY() == j) {
                    g.drawImage(ghostImage, j * 32, i * 32 + 25, null);
                }
            }
        }
    }
}
