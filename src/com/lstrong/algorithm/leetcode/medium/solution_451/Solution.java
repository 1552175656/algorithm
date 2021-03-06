package com.lstrong.algorithm.leetcode.medium.solution_451;

import java.util.PriorityQueue;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/21 19:08<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {
    public static String frequencySort(String s) {
        // 此类问题也可以看作时查找问题, 从一个字符串中找出出现频率最高的字符, 然后拍在最前面
        // 使用Java 提供的优先队列来按照出现次数进行排序


        if (s == null || s.length() < 2) {
            return s;
        }

        // 存储字符/对应字符出现次数
        int[] frequency = new int[128];
        char[] chars = s.toCharArray();

        // 计算每个字符出现次数
        for (char aChar : chars) {
            frequency[aChar]++;
        }

        // 定义一个大顶堆
        PriorityQueue<Character> heap2 = new PriorityQueue<>((a, b) -> frequency[b] - frequency[a]);

        // 将数据写入到PriorityQueue中
        for (int j = 0; j < 128; j++) {
            if (frequency[j] != 0) {
                heap2.offer((char) j);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!heap2.isEmpty()) {
            char ch = heap2.poll();
            while (frequency[ch] > 0) {
                stringBuilder.append(ch);
                frequency[ch]--;
            }
        }

        return stringBuilder.toString();

    }


    public static void main(String[] args) {
        System.out.println(frequencySort("hree"));
    }
}
