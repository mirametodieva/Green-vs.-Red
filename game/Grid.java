package game;

public class Grid {

    private int[][] grid;
    private int sizeX;
    private int sizeY;

    public Grid(int[][] grid, int sizeX, int sizeY) {
        this.grid = grid;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public int[][] getGrid() {
        return grid;
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }

    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public void printArray(int[][] arr) {
        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    public int[][] nextGeneration() {
        int[][] temp = new int[sizeX][sizeY];

        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                temp[i][j] = grid[i][j];
            }
        }

        for (int x = 0; x < sizeX; x++) {
            for (int y = 0; y < sizeY; y++) {

                int greenCount = 0;

                // left
                if (left(y)) {
                    if (grid[x][y - 1] == 1) {
                        greenCount++;
                    }
                }
                // right
                if (right(y)) {
                    if (grid[x][y + 1] == 1) {
                        greenCount++;
                    }
                }
                // up
                if (up(x)) {
                    if (grid[x - 1][y] == 1) {
                        greenCount++;
                    }
                }
                // down
                if (down(x)) {
                    if (grid[x + 1][y] == 1) {
                        greenCount++;
                    }
                }

                // DIAGONALS
                // up left
                if (left(y) && up(x)) {
                    if (grid[x - 1][y - 1] == 1) {
                        greenCount++;
                    }
                }
                // down left
                if (left(y) && down(x)) {
                    if (grid[x + 1][y - 1] == 1) {
                        greenCount++;
                    }
                }
                // up right
                if (right(y) && up(x)) {
                    if (grid[x - 1][y + 1] == 1) {
                        greenCount++;
                    }
                }
                // down right
                if (right(y) && down(x)) {
                    if (grid[x + 1][y + 1] == 1) {
                        greenCount++;
                    }
                }

                // apply rules
                if (grid[x][y] == 1) {
                    if (greenCount == 2 || greenCount == 3 || greenCount == 6) {
                        temp[x][y] = 1;
                    } else {
                        temp[x][y] = 0;
                    }
                } else {
                    if (greenCount == 3 || greenCount == 6) {
                        temp[x][y] = 1;
                    }
                }
            }
        }
        return temp;
    }

    public static boolean left(int y) {
        return y > 0;
    }

    public boolean right(int y) {
        return y < sizeY - 1;
    }

    public static boolean up(int x) {
        return x > 0;
    }

    public boolean down(int x) {
        return x < sizeX - 1;
    }
}
