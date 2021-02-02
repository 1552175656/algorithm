package com.lstrong.algorithm.leetcode.medium.solution_130;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/2/1 17:34<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {

    int r;
    int c;
    int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public void solve(char[][] board) {
        r = board.length;
        if (r == 0) {
            return;
        }
        c = board[0].length;

        for (int i = 0; i < r; i++) {
            dfs(board, i, 0);
            dfs(board, i, c - 1);
        }

        for (int i = 1; i < c - 1; i++) {
            dfs(board, 0, i);
            dfs(board, r - 1, i);
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }


    private void dfs(char[][] board, int x, int y) {

        if (!inArea(x, y) || board[x][y] != 'O') {
            return;
        }

        board[x][y] = 'A';
        for (int i = 0; i < 4; i++) {
            int newX = x + direction[i][0];
            int newY = y + direction[i][1];
            dfs(board, newX, newY);
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < r && y >= 0 && y < c;
    }


}
