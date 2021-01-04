package com.lstrong.algorithm.leetcode.medium.solution_208;

import java.util. HashMap;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/2 12:30<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Trie {
    private class Node {

        public boolean isWord;
        public  HashMap<Character, Trie.Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new  HashMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Trie.Node root;


    public Trie() {
        root = new Trie.Node();
    }


    public void insert(String word) {

        Trie.Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Trie.Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            cur.isWord = true;
        }
    }

    public boolean search(String word) {

        Trie.Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    public boolean startsWith(String prefix) {

        Trie.Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }
}
