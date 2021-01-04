package com.lstrong.algorithm.datastructure;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/4 21:48<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class UnionFind2 implements UnionFind{

    private int[] parent;

    public UnionFind2(int size){

        parent = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }



    @Override
    public int getSize() {
        return parent.length;
    }

    private int find(int p) {

        if(p < 0 || p >= parent.length){
            throw new IllegalArgumentException("p is out of bound.");
        }

        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {

        int pRoot = find(p);
        int qRoot = find(q);

        if(pRoot == qRoot){
            return;
        }

        parent[pRoot] = qRoot;
    }
}
