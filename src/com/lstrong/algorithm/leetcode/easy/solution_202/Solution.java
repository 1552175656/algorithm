package com.lstrong.algorithm.leetcode.easy.solution_202;

import java.util.HashSet;
import java.util.Set;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/21 16:37<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {


    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = count(n);
        }
        return n == 1;
    }

    private int count(int n) {
        int res = 0;
        while (n > 0) {
            res += Math.pow(n % 10, 2);
            n /= 10;
        }
        return res;
    }
}
