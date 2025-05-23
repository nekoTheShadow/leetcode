package set_matrix_zeroes;

import java.util.stream.IntStream;

public class Solution {
  public void setZeroes(int[][] matrix) {
    int h = matrix.length;
    int w = matrix[0].length;
    
    boolean firstRowZero = IntStream.range(0, w).anyMatch(j -> matrix[0][j] == 0);
    boolean firstColZero = IntStream.range(0, h).anyMatch(i -> matrix[i][0] == 0);
    
    for (int i = 1; i < h; i++) {
      for (int j = 1; j < w; j++) {
        if (matrix[i][j] == 0) {
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }
    }
    
    for (int i = 1; i < h; i++) {
      if (matrix[i][0] == 0) {
        for (int j = 1; j < w; j++) {
          matrix[i][j] = 0;
        }
      }
    }
    for (int j = 1; j < w; j++) {
      if (matrix[0][j] == 0) {
        for (int i = 1; i < h; i++) {
          matrix[i][j] = 0;
        }
      }
    }
    
    if (firstRowZero) {
      IntStream.range(0, w).forEach(j -> matrix[0][j] = 0);
    }
    if (firstColZero) {
      IntStream.range(0, h).forEach(i -> matrix[i][0] = 0);
    }
  }
}
