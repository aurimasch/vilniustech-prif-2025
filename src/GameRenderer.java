import java.util.List;

public class GameRenderer {

    private int height;
    private int width;
    private List<ConsoleRenderable> renderables;

    public GameRenderer(int height, int width, List<ConsoleRenderable> renderables) {
        this.height = height;
        this.width = width;
        this.renderables = renderables;
    }

    public void render() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                for (ConsoleRenderable renderable : renderables)
                    renderable.render(i, j);
            }

            System.out.println();
        }
    }
}
