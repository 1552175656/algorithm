package com.lstrong.algorithm.leetcode.medium.solution_417;

import java.util.ArrayList;
import java.util.List;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/2/1 17:37<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {

    int m;
    int n;
    int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int[][] matrix;

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        m = matrix.length;
        if (m == 0) {
            return res;
        }
        this.matrix = matrix;
        n = matrix[0].length;
        boolean[][] visitedP = new boolean[m][n];
        boolean[][] visitedA = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(visitedP, i, 0);
            dfs(visitedA, i, n - 1);
        }

        for (int i = 0; i < n; i++) {
            dfs(visitedP, 0, i);
            dfs(visitedA, m - 1, i);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visitedA[i][j] && visitedP[i][j]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }
            }
        }


        return res;
    }

    private void dfs(boolean[][] visited, int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + direction[i][0];
            int newY = y + direction[i][1];
            if (inArea(newX, newY) && matrix[x][y] <= matrix[newX][newY] &&
                    !visited[newX][newY]) {
                dfs(visited, newX, newY);
            }
        }

    }


    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }


}
