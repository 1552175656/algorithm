package com.lstrong.algorithm.leetcode.medium.solution_347;





import java.util.*;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/29 14:33<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>(nums.length / 2);
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(Pair::getKey));
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (queue.size() == k) {
                if (entry.getValue() > queue.peek().getKey()) {
                    queue.poll();
                    queue.offer(new Pair<>(entry.getValue(), entry.getKey()));
                }
            } else {
                queue.offer(new Pair<>(entry.getValue(), entry.getKey()));
            }
        }

        int[] res = new int[k];
        int index = 0;
        while (!queue.isEmpty()) {
            res[index++] = queue.poll().getValue();
        }

        return res;
    }

    public static class Pair<K, V> {
        private final K key;
        private final V value;



        public Pair(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

    }
}
