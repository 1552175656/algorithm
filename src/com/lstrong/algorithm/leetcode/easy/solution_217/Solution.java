package com.lstrong.algorithm.leetcode.easy.solution_217;

import java.util.HashSet;
import java.util.Set;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/23 16:08<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }

        return false;
    }
}
