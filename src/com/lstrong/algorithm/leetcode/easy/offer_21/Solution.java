package com.lstrong.algorithm.leetcode.easy.offer_21;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2020/12/26 16:14<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {

    //private int res = 0;

    public int reversePairs(int[] nums) {

        int[] tmp = new int[nums.length];

        return sort(nums, 0, nums.length - 1, tmp);
    }

    private int sort(int[] arr, int l, int r, int[] tmp) {

        if (l >= r) {
            return 0;
        }
        int res = 0;
        int mid = l + (r - l) / 2;
        res += sort(arr, l, mid, tmp);
        res += sort(arr, mid + 1, r, tmp);
        if (arr[mid] > arr[mid + 1]) {
            res += merge(arr, l, mid, r, tmp);
        }

        return res;
    }

    private int merge(int[] arr, int l, int mid, int r, int[] tmp) {
        System.arraycopy(arr, l, tmp, l, r - l + 1);

        int i = l;
        int j = mid + 1;
        int res = 0;

        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = tmp[j];
                j++;
            } else if (j > r) {
                arr[k] = tmp[i];
                i++;
            } else if (tmp[i] <= tmp[j]) {
                arr[k] = tmp[i];
                i++;
            } else {
                res += (mid - i) + 1;
                arr[k] = tmp[j];
                j++;
            }
        }
        return res;
    }
}
