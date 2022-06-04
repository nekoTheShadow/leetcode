package n_queens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solveNQueens(4));
        System.out.println(sol.solveNQueens(1));
    }
    
    public List<List<String>> solveNQueens(int n) {
        List<int[]> res = new ArrayList<>();
        dfs(new int[n], n, 0, res);
        
        List<List<String>> answers = new ArrayList<>();
        for (int[] board : res) {
            List<String> answer = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(isQueen(board, n, i, j) ? "Q" : ".");
                }
                answer.add(sb.toString());
            }
            answers.add(answer);
        }
        return answers;
    }
    
    // 0: 未決定, 1:Queen, 2: だめ
    public void dfs(int[] board, int n, int x, List<int[]> res) {
        if (x == n) {
            res.add(board);
            return;
        }
        
        for (int y = 0; y < n; y++) {
            if (isOK(board, n, x, y)) {
                int[] nextBoard = Arrays.copyOf(board, n);
                nextBoard[x] |= (1<<y);
                dfs(nextBoard, n, x+1, res);
            }
        }
    }
    
    public boolean isOK(int[] board, int n, int x, int y) {
        for (int i = 0; i < n; i++) {
            if (isQueen(board, n, i, y)) {
                return false;
            }
        }
        
        for (int p = 0; p < n; p++) {
            for (int[] diff : new int[][] {{x+p, y+p}, {x+p, y-p}, {x-p, y+p}, {x-p, y-p}}) {
                int i = diff[0];
                int j = diff[1];
                if (!(0<=i && i<n && 0<=j && j<n)) {
                    continue;
                }
                
                if (isQueen(board, n, i, j)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public boolean isQueen(int[] board, int n, int x, int y) {
        return (board[x]&(1<<y)) != 0;
    }
}
