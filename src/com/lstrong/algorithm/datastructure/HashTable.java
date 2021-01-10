package com.lstrong.algorithm.datastructure;

import java.util.TreeMap;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/10 20:01<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class HashTable<K, V> {

    private TreeMap<K, V>[] hashTable;
    private int M;
    private int size;

    public HashTable(int M) {
        this.M = M;
        size = 0;
        hashTable = new TreeMap[M];
        for (int i = 0; i < M; i++) {
            hashTable[i] = new TreeMap<>();
        }
    }

    public HashTable() {
        this(97);
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public int getSize() {
        return size;
    }

    public void add(K key, V value) {
        TreeMap<K, V> map = hashTable[hash(key)];

        if (map.containsKey(key)) {
            map.put(key, value);
        } else {
            map.put(key, value);
            size++;
        }
    }

    public V remove(K key) {
        TreeMap<K, V> map = hashTable[hash(key)];
        V ret = null;
        if(map.containsKey(key)){
            ret = map.remove(key);
            size--;
        }
        return ret;
    }

    public void set(K key, V value){
        TreeMap<K, V> map = hashTable[hash(key)];
        if(!map.containsKey(key)){
            throw new IllegalArgumentException(key + "doesn't exist!");
        }

        map.put(key, value);
    }


}
