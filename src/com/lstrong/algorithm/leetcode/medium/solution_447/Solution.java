package com.lstrong.algorithm.leetcode.medium.solution_447;

import java.util.HashMap;
import java.util.Map;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/23 11:34<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;

        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> map = new HashMap<>(points.length / 2);
            for (int j = 0; j < points.length; j++) {
                if (j != i) {
                    map.put(dis(points[i], points[j]), map.getOrDefault(dis(points[i], points[j]), 0) + 1);
                }
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                res += entry.getValue() * (entry.getValue() - 1);
            }

        }

        return res;
    }

    private int dis(int[] point1, int[] point2) {
        return (point1[0] - point2[0]) * (point1[0] - point2[0]) +
                (point1[1] - point2[1]) * (point1[1] - point2[1]);
    }


}
