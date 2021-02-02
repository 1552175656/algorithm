package com.lstrong.algorithm.leetcode.medium.solution_279;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/28 19:31<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {

    //BFS
    public int numSquares(int n) {
        int count = 0;
        int max = (int) Math.sqrt(n);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        queue.offer(-1);

        while (!queue.isEmpty()) {
            int first = queue.poll();
            if (first == -1) {
                count++;
                if (queue.peek() != -1) {
                    queue.offer(-1);
                }
            }

            for (int i = max; i > 0; i--) {
                int next = first - i * i;
                if (next > 0) {
                    queue.offer(next);
                }

                if (next == 0) {
                    return count + 1;
                }
            }


        }
        return count;
    }


    //贪心 + dfs;

    int res = Integer.MAX_VALUE;

    public int numSquaresR(int n) {
        List<Integer> arr = new ArrayList<>();
        int index = 1;
        while (index * index <= n) {
            arr.add(index * index);
            index++;
        }
        dfs(arr, n, arr.size() - 1, 0);
        return res;
    }


    private void dfs(List<Integer> arr, int n, int index, int count) {
        if (n == 0) {
            res = Math.min(res, count);
            return;
        }

        if (index < 0) {
            return;
        }


        for (int i = n / arr.get(index); i >= 0 && i + count < res; i--) {
            dfs(arr, n - i * arr.get(index), index - 1, count + i);
        }

    }

    //dp
    public int numSquaresD(int n) {

        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }


        return dp[n];
    }


}
