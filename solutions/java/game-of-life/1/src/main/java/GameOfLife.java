import java.util.ArrayList;
import java.util.List;

class GameOfLife {
  public int[][] tick(int[][] matrix) {
    int height = matrix.length;
    int width = matrix.length == 0 ? 0 : matrix[0].length;

    List<List<Cell>> cells = new ArrayList<>();

    // go over the "cells"
    for (int y = 0; y < height; y++) {
      List<Cell> row = new ArrayList<>();

      for (int x = 0; x < width; x++) {
        row.add(new Cell(matrix[y][x] == 1, countLivingNeighbours(matrix, x, y)));
      }

      cells.add(row);
    }

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        Cell cell = cells.get(y).get(x);
        matrix[y][x] = cell.shouldBeAliveNextTick() ? 1 : 0;
      }
    }

    return matrix;
  }

  private int countLivingNeighbours(int[][] matrix, int x, int y) {
    int height = matrix.length;
    int width = height == 0 ? 0 : matrix[0].length;

    int livingNeighbours = 0;

    for (int i = y - 1; i <= y + 1; i++) {
      if (i < 0 || i + 1 > height)
        continue;

      for (int j = x - 1; j <= x + 1; j++) {
        if (j < 0 || j + 1 > width || (i == y && j == x))
          continue;

        livingNeighbours += matrix[i][j];
      }
    }

    return livingNeighbours;
  }

}
