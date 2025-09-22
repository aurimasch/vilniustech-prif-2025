import java.io.IOException;

public class Main {

    // 0 - empty, 1 - wall generate simple map
    static int[][] map = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,},
            {1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,},
            {1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,},
            {1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,},
            {1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,},
            {1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,},
            {1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,},
            {1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,},
            {1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1,},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1,},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,},
    };

    static int pacmanX = 1;
    static int pacmanY = 1;

    static int ghostX = 10;
    static int ghostY = 10;

    static int ghostDx = 1;
    static int ghostDy = 0;



    public static void main(String[] args) throws IOException {

        while (true) {

            for (int i = 0; i< map.length; i++) {
                for (int j = 0; j< map[i].length; j++)  {
                    if (map[i][j] == 1)
                        System.out.print("#");
                    else if (i == pacmanX && j == pacmanY)
                        System.out.print("C");
                    else if (i == ghostX && j == ghostY)
                        System.out.print("G");
                    else
                        System.out.print(" ");
                }
                System.out.println();
            }


            int read = System.in.read();
            if (read == 10)
                continue;

            if (read == 'w' && map[pacmanX-1][pacmanY] == 0)
                pacmanX--;
            else if (read == 's' && map[pacmanX+1][pacmanY] == 0)
                pacmanX++;
            else if (read == 'a' && map[pacmanX][pacmanY-1] == 0)
                pacmanY--;
            else if (read == 'd' && map[pacmanX][pacmanY+1] == 0)
                pacmanY++;

            if (map[ghostX + ghostDx][ghostY + ghostDy] == 1) {
                if (ghostDx == 1 && ghostDy == 0) {
                    ghostDx = 0;
                    ghostDy = 1;
                } else if (ghostDx == 0 && ghostDy == 1) {
                    ghostDx = -1;
                    ghostDy = 0;
                } else if (ghostDx == -1 && ghostDy == 0) {
                    ghostDx = 0;
                    ghostDy = -1;
                } else if (ghostDx == 0 && ghostDy == -1) {
                    ghostDx = 1;
                    ghostDy = 0;
                }
            }
            ghostX += ghostDx;
            ghostY += ghostDy;

            if (pacmanX == ghostX && pacmanY == ghostY) {
                System.out.println("Game Over!");
                break;
            }
        }

    }

}
