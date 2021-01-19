package com.lstrong.algorithm.leetcode.medium.solution_215;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2020/12/27 13:16<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class Solution {



    public int findKthLargest(int[] nums, int k) throws Exception {

        int l = 0, r = nums.length - 1;

        while (l <= r){

            int p = partition(nums, l , r);
            if(p == k){
                return nums[p];
            }else if(p > k){
                r = p - 1;
            }else {
                l = p + 1;
            }
        }

        throw new Exception("No Solution");
    }

    public int findKthLargestR(int[] nums, int k) {
        return select(nums, 0, nums.length - 1, nums.length - k);
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
}
