import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class WindowsRenderer {

    private Map map;
    private List<Ghost> ghosts;
    private Pacman pacman;

    private BufferedImage pacmanImage;
    private BufferedImage ghostImage;
    private BufferedImage wallImage;

    public WindowsRenderer(Map map, List<Ghost> ghosts, Pacman pacman) throws IOException {
        this.map = map;
        this.ghosts = ghosts;
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
                if (map.isWall(i, j))
                    g.drawImage(wallImage, j * 32, i * 32 + 25, null);

                if (pacman.getX() == i && pacman.getY() == j)
                    g.drawImage(pacmanImage, j * 32, i * 32 + 25, null);

                for (Ghost ghost : ghosts)
                    if (ghost.getX() == i && ghost.getY() == j)
                        g.drawImage(ghostImage, j * 32, i * 32 + 25, null);
            }
        }
    }
}
