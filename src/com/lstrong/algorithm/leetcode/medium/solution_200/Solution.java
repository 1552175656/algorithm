package com.lstrong.algorithm.leetcode.medium.solution_200;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/2/1 17:13<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {

    int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int r;
    int c;

    public int numIslands(char[][] grid) {
        int res = 0;
        r = grid.length;
        c = grid[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }

        return res;
    }


    private void dfs(char[][] grid, int x, int y) {

        if (!inArea(x, y) || grid[x][y] == '0') {
            return;
        }

        grid[x][y] = '0';
        for (int i = 0; i < 4; i++) {
            int newX = x + direction[i][0];
            int newY = y + direction[i][1];
            dfs(grid, newX, newY);
        }
    }


    private boolean inArea(int x, int y) {
        return x >= 0 && x < r && y >= 0 && y < c;
    }
}
