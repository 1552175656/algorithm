package com.lstrong.algorithm.datastructure;

/**
 * @author Administrator
 */
public interface Queue<E> {

    int getSize();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E getFront();
}
