package com.lstrong.algorithm.leetcode.easy.solution_303;


/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/1 10:38<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class NumArray {

    private interface Merger<E> {
        E merge(E a, E b);
    }



    private class SegmentTree<E> {

        private final E[] data;
        private final E[] tree;
        private final Merger<E> merger;

        public SegmentTree(E[] arr, Merger<E> merger) {
            this.merger = merger;
            data = (E[]) new Object[arr.length];

            System.arraycopy(arr, 0, data, 0, arr.length);

            tree = (E[]) new Object[4 * arr.length];

            buildSegmentTree(0, 0, data.length - 1);
        }

        //以treeIndex为根，创建[l...r]的线段树。
        private void buildSegmentTree(int treeIndex, int l, int r) {

            if (l == r) {
                tree[treeIndex] = data[l];
                return;
            }

            int leftTreeIndex = leftChild(treeIndex);
            int rightTreeIndex = rightChild(treeIndex);

            int mid = l + (r - l) / 2;
            buildSegmentTree(leftTreeIndex, l, mid);
            buildSegmentTree(rightTreeIndex, mid + 1, r);

            tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
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


        public E query(int queryL, int queryR) {

            if (queryL < 0 || queryL >= data.length ||
                    queryR < 0 || queryR >= data.length || queryL > queryR) {
                throw new IllegalArgumentException("Index is illegal");
            }

            return query(0, 0, data.length - 1, queryL, queryR);
        }

        //在以treeIndex为根的线段树中[l...r]的范围里， 搜索区间[queryL...queryR]的值
        private E query(int treeIndex, int l, int r, int queryL, int queryR) {

            if (l == queryL && r == queryR) {
                return tree[treeIndex];
            }

            int mid = l + (r - l) / 2;
            int leftTreeIndex = leftChild(treeIndex);
            int rightTreeIndex = rightChild(treeIndex);

            if (queryL >= mid + 1) {
                return query(rightTreeIndex, mid + 1, r, queryL, queryR);
            } else if (queryR <= mid) {
                return query(leftTreeIndex, l, mid, queryL, queryR);
            }

            E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
            E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);

            return merger.merge(leftResult, rightResult);
        }
    }


    private SegmentTree<Integer> segmentTree;

    public NumArray(int[] nums) {
        if (nums.length > 0) {
            Integer[] integers = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                integers[i] = nums[i];
            }
            segmentTree = new SegmentTree<>(integers, new Merger<Integer>() {
                @Override
                public Integer merge(Integer a, Integer b) {
                    return a + b;
                }
            });
        }
    }

    public int sumRange(int i, int j) {

        return segmentTree.query(i, j);
    }



    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0, 2));
        //System.out.println(numArray.sumRange(2, 5));
        //System.out.println(numArray.sumRange(0, 5));
    }
}
