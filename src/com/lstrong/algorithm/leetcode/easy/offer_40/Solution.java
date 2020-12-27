package com.lstrong.algorithm.leetcode.easy.offer_40;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2020/12/27 16:26<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }

        select(arr, 0, arr.length - 1, k - 1);

        return Arrays.copyOf(arr, k);
    }


    private int select(int[] nums, int l, int r, int k) {

        int p = partition(nums, l, r);
        if (p == k) {
            return nums[p];
        } else if (p > k) {
            return select(nums, l, p - 1, k);
        } else {
            return select(nums, p + 1, r, k);
        }
    }

    private int partition(int[] nums, int l, int r) {

        int i = l + 1;
        int j = r;

        while (true) {

            while (i <= j && nums[i] < nums[l]) {
                i++;
            }

            while (i <= j && nums[j] > nums[l]) {
                j--;
            }

            if (i >= j) {
                break;
            }
            swap(nums, i, j);
            i++;
            j--;
        }
        swap(nums, j, l);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public int[] getLeastNumbers1(int[] arr, int k) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((v1, v2 ) -> (v2 - v1));

        for (int i = 0; i < k; i++) {
            priorityQueue.offer(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if(!priorityQueue.isEmpty() && arr[i] < priorityQueue.peek()){
                Integer poll = priorityQueue.poll();
                System.out.println(poll);
                priorityQueue.offer(arr[i]);
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = priorityQueue.poll();
        }
        return res;
    }
}
