package com.lstrong.algorithm.leetcode.easy.solution_349;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/21 15:59<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {

    public  int[] intersection(int[] nums1, int[] nums2) {

        List<Integer> list = new ArrayList<>();

        Set<Integer> set = new HashSet<>();
        for (Integer i : nums1){
            set.add(i);
        }

        for(Integer i : nums2){
            if(set.contains(i)){
                list.add(i);
                set.remove(i);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

}
