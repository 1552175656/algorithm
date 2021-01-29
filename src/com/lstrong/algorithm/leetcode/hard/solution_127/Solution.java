package com.lstrong.algorithm.leetcode.hard.solution_127;

import javafx.util.Pair;

import java.util.*;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/28 19:40<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return 0;
        }

        int length = beginWord.length();

        Map<String, List<String>> map = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < length; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, length);
                List<String> list = map.getOrDefault(newWord, new ArrayList<>());
                list.add(word);
                map.put(newWord, list);
            }
        }

        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(beginWord, 1));

        HashSet<String> exist = new HashSet<>();

        while (!queue.isEmpty()) {
            Pair<String, Integer> top = queue.poll();
            String word = top.getKey();
            int level = top.getValue();

            for (int i = 0; i < length; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, length);
                for (String word1 : map.getOrDefault(newWord, new ArrayList<>())) {
                    if (endWord.equals(word1)) {
                        return level + 1;
                    }

                    if (!exist.contains(word1)) {
                        exist.add(word1);
                        queue.offer(new Pair<>(word1, level + 1));
                    }
                }
            }

        }
        return 0;
    }
}
