package com.lstrong.algorithm.datastructure;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2020/12/26 11:59<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class LinkedListStack<E> implements Stack<E>{

    private final LinkedList<E> list;

    public LinkedListStack(){
        list = new LinkedList<>();
    }



    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }
}
