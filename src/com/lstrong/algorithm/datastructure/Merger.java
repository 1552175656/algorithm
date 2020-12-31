package com.lstrong.algorithm.datastructure;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2020/12/30 21:50<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public interface Merger<E> {
    E merge(E a, E b);
}
