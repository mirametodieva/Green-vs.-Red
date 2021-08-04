package game;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.println("Input: ");
        
        String sizeGrid = in.nextLine();
        String[] parts = sizeGrid.split(", ");
        int sizeX = Integer.parseInt(parts[0]);
        int sizeY = Integer.parseInt(parts[1]);
        
        int[][] grid = new int[sizeX][sizeY];
        
        for (int i = 0; i < sizeX; i++) {
            String line = in.nextLine();
            String[] row = line.split("");
            for (int j = 0; j < sizeY; j++) {
                grid[i][j] = Integer.parseInt(row[j]);
            }
        }
        
        String lastLine = in.nextLine();
        String[] lastPart = lastLine.split(", ");
        int x1 = Integer.parseInt(lastPart[0]);
        int y1 = Integer.parseInt(lastPart[1]);
        int n = Integer.parseInt(lastPart[2]);
        
        Grid object = new Grid(grid, sizeX, sizeY);
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (grid[x1][y1] == 1) {
                count++;
            }
            // printArray(grid);
            grid = object.nextGeneration();
            object.setGrid(grid);
        }
        
        System.out.printf("expected result: %d \n", count);
    }
    
}
