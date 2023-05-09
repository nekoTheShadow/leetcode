package spiral_matrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[] dx = {0, 1,  0, -1};
        int[] dy = {1, 0, -1,  0};
        int p = 0;
        List<Integer> a = new ArrayList<>();
        boolean[][] visited = new boolean[m][n];
        int x = 0;
        int y = 0;
        for (int time=0; time<m*n; time++) {
            a.add(matrix[x][y]);
            visited[x][y] = true;
            
            int nx = x+dx[p];
            int ny = y+dy[p];
            if (0<=nx && nx<m && 0<=ny && ny<n && !visited[nx][ny]) {
                x = nx;
                y = ny;
            } else {
                p++;
                p %= 4;
                x += dx[p];
                y += dy[p];
            }
        }
        
        return a;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
        System.out.println(new Solution().spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
    }
}
