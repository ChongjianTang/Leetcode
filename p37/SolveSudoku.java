package leetcode.p37;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SolveSudoku {
    public static void solveSudoku(char[][] board) {
        helper(board);
    }

    public static boolean helper(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    List<Character> validNumbers = getValidNumbers(board, i, j);
                    for (char c : validNumbers) {
                        board[i][j] = c;
                        if (helper(board)) {
                            return true;
                        }
                    }
                    board[i][j] = '.';
                    return false;
                }
            }
        }
        return true;
    }

    public static List<Character> getValidNumbers(char[][] board, int i, int j) {
        HashSet<Character> set = new HashSet<>();
        for (int k = 0; k < 9; k++) {
            if (board[i][k] != '.') {
                set.add(board[i][k]);
            }
            if (board[k][j] != '.') {
                set.add(board[k][j]);
            }
            int x = (i / 3) * 3 + k / 3;
            int y = (j / 3) * 3 + k % 3;
            if (board[x][y] != '.') {
                set.add(board[x][y]);
            }
        }
        List<Character> list = new ArrayList<>(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9'));
        for (char c : set) {
            list.remove(Character.valueOf(c));
        }
        return list;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

    }

}
