package com.lstrong.algorithm.datastructure;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/4 20:58<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class UnionFind1 implements UnionFind{

    private int[] id;

    public UnionFind1(int size){

        id = new int[size];

        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }


    @Override
    public int getSize() {
        return id.length;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    private int find(int p){
        if(p < 0 || p >= id.length){
            throw new IllegalArgumentException("p is out of bound.");
        }
        return id[p];
    }

    @Override
    public void unionElements(int p, int q) {

        int pId = find(p);
        int qId = find(q);

        if(pId == qId){
            return;
        }

        for (int i = 0; i < id.length; i++) {
            if(id[i] == pId){
                id[i] = qId;
            }
        }
    }
}
