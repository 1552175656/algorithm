package com.lstrong.algorithm.sort;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/12 21:27<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class CountingSort {

    public int[] sort(int[] nums) {

        int[] res = new int[nums.length];
        int max = nums[0];
        int min = nums[0];

        for (int num : nums) {
            if (num > max) {
                max = num;
            }

            if (num < min) {
                min = num;
            }
        }

        int k = max - min + 1;
        int[] cnt = new int[k];

        for (int num : nums) {
            cnt[num - min]++;
        }

        for (int i = 1; i < cnt.length; i++) {
            cnt[i] = cnt[i] + cnt[i - 1];
        }

        for (int i = nums.length - 1; i >= 0; --i) {
            res[--cnt[nums[i] - min]] = nums[i];
        }

        return res;
    }

}
