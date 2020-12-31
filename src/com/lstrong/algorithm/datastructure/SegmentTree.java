package com.lstrong.algorithm.datastructure;

/**
 * @author Administrator
 */
public class SegmentTree<E> {

    private E[] tree;

    private E[] data;

    public SegmentTree(E[] arr){

        data = (E[]) new Object[arr.length];

        System.arraycopy(arr, 0, data, 0, arr.length);

        tree = (E[]) new Object[4 * arr.length];

    }

    public int getSize(){
        return data.length;
    }

    public E get(int index){

        if(index < 0 || index >= data.length){
            throw new IllegalArgumentException("Index is illegal");
        }

        return data[index];
    }
}
