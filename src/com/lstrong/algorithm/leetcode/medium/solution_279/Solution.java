package com.lstrong.algorithm.leetcode.medium.solution_279;

import java.util.LinkedList;
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
}
