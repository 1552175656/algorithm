package com.lstrong.algorithm.datastructure;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2020/12/29 22:14<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class SegmentTree<E> {

    private E[] data;
    private E[] tree;

    public SegmentTree(E[] arr) {
        data = (E[]) new Object[arr.length];

        System.arraycopy(arr, 0, data, 0, arr.length);

        tree = (E[]) new Object[4 * arr.length];
    }

    public int getSize() {
        return data.length;
    }

    public E get(int index) {

        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index is illegal.");
        }
        return data[index];
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }


}
