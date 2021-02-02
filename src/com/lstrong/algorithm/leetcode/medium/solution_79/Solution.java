package com.lstrong.algorithm.leetcode.medium.solution_79;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/2/1 15:17<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {

    int[][] direction = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int m, n;
    boolean[][] visited;


    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (searchWord(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }


    private boolean searchWord(char[][] board, String word, int x, int y, int index) {
        if (index == word.length() - 1) {
            return board[x][y] == word.charAt(index);
        }

        if (board[x][y] == word.charAt(index)) {
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int newX = x + direction[i][0];
                int newY = y + direction[i][1];
                if (inArea(newX, newY) && !visited[newX][newY] &&
                        searchWord(board, word, newX, newY, index + 1)) {
                    return true;
                }
            }
            visited[x][y] = false;
        }

        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }


}
