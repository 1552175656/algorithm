package com.lstrong.algorithm.datastructure;

/**
 * @author Administrator
 */
public interface UnionFind {

    int getSize();

    boolean isConnected(int p, int q);

    void unionElements(int p, int q);
}
