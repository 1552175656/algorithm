package com.lstrong.algorithm.leetcode.easy.solution_350;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/21 16:12<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {

    public int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer> tmp = new ArrayList<>();

        for (int i : nums2) {
            if (map.containsKey(i) && map.get(i) > 0) {
                tmp.add(i);
                map.put(i, map.get(i) - 1);
            }
        }

        int[] res = new int[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            res[i] = tmp.get(i);
        }
        return res;
    }
}
