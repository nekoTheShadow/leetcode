package sudoku_solver;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Solution {
    public void solveSudoku(char[][] board) {
        backtrace(board);
    }

    private boolean backtrace(char[][] board) {
        Optional<Cell> cell = getEmptyCell(board);
        if (cell.isEmpty()) {
            return true;
        }

        int x = cell.get().x();
        int y = cell.get().y();
        for (char digit : getAvailableDigits(board, x, y)) {
            board[x][y] = digit;
            if (backtrace(board)) {
                return true;
            }
            board[x][y] = '.';
        }
        return false;
    }

    private Optional<Cell> getEmptyCell(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    return Optional.of(new Cell(i, j));
                }
            }
        }
        return Optional.empty();
    }

    private Set<Character> getAvailableDigits(char[][] board, int x, int y) {
        Set<Character> digits = new HashSet<>();
        for (char ch = '1'; ch <= '9'; ch++) {
            digits.add(ch);
        }

        for (int i = 0; i < 9; i++) {
            digits.remove(board[i][y]);
        }
        for (int j = 0; j < 9; j++) {
            digits.remove(board[x][j]);
        }

        int sx = x / 3 * 3;
        int sy = y / 3 * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                digits.remove(board[sx + i][sy + j]);
            }
        }

        return digits;
    }
}

record Cell(int x, int y) {

}
