package com.lstrong.algorithm.leetcode.easy.solution_303;


import java.util.Arrays;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/1 10:38<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
class NumArray1 {

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

    public NumArray1(int[] nums) {
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


    class NumArray2 {

        private int[] data, blocks;
        private int N;
        private int B;
        private int Bn;

        public NumArray2(int[] nums) {
            N = nums.length;
            if (N == 0) {
                return;
            }

            B = (int) Math.sqrt(N);
            Bn = N / B + (N % B > 0 ? 1 : 0);

            data = Arrays.copyOf(nums, N);
            blocks = new int[Bn];

            for (int i = 0; i < N; i++) {
                blocks[i / B] += nums[i];
            }
        }

        public int sumRange(int x, int y) {

            if (x < 0 || x >= N || y < 0 || y >= N || x > y) {
                return 0;
            }

            int bstart = x / B, bend = y / B;

            int res = 0;
            if (bstart == bend) {
                for (int i = x; i <= y; i++) {
                    res += data[i];
                }
                return res;
            }

            for (int i = x; i < (bstart + 1) * B; i++) {
                res += data[i];
            }

            for (int i = bstart + 1; i < bend; i++) {
                res += blocks[i];
            }

            for (int i = bend * B; i <= y; i++) {
                res += data[i];
            }

            return res;
        }


    }
}
