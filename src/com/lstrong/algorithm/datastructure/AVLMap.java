package com.lstrong.algorithm.datastructure;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/9 20:38<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class AVLMap<K extends Comparable<K>, V> implements Map<K, V>{

    private final AVLTree<K, V> avl;

    public AVLMap(){
        avl = new AVLTree<>();
    }


    @Override
    public void add(K key, V value) {
        avl.add(key, value);
    }

    @Override
    public V remove(K key) {
        return avl.remove(key);
    }

    @Override
    public boolean contains(K key) {
        return avl.contains(key);
    }

    @Override
    public V get(K key) {
        return avl.get(key);
    }

    @Override
    public void set(K key, V newValue) {
        avl.set(key, newValue);
    }

    @Override
    public boolean isEmpty() {
        return avl.isEmpty();
    }

    @Override
    public int getSize() {
        return avl.getSize();
    }
}
