package com.lstrong.algorithm.binarysearch;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2021/1/19 12:44<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class BinarySearch {

    private BinarySearch() {

    }

    //非递归实现1
    public static <E extends Comparable<E>> int binarySearch1(E[] data, E target) {

        int l = 0, r = data.length - 1;

        //data[l,r] 寻找解
        while (l <= r) {

            int mid = l + (r - l) / 2;
            if (data[mid].compareTo(target) == 0) {
                return mid;
            } else if (data[mid].compareTo(target) < 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }

    //非递归实现2
    public static <E extends Comparable<E>> int binarySearch2(E[] data, E target) {

        int l = 0, r = data.length;

        //data[l, r]寻找解
        while (l < r) {

            int mid = l + (r - l) / 2;
            if (data[mid].compareTo(target) < 0) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }


        if (l < data.length && data[l].compareTo(target) == 0) {
            return l;
        }

        return -1;
    }

    //递归实现
    public static <E extends Comparable<E>> int binarySearchR(E[] data, E target) {

        return binarySearchR(data, 0, data.length - 1, target);
    }


    private static <E extends Comparable<E>> int binarySearchR(E[] data, int l, int r, E target) {

        if (l > r) {
            return -1;
        }

        int mid = l + (r - l) / 2;

        if (data[mid].compareTo(target) == 0) {
            return mid;
        } else if (data[mid].compareTo(target) < 0) {
            return binarySearchR(data, mid + 1, r, target);
        } else {
            return binarySearchR(data, l, mid - 1, target);
        }
    }


    //大于target的最小值索引
    public static <E extends Comparable<E>> int upper(E[] data, E target) {

        int l = 0, r = data.length;

        //data[l, r]中寻找解
        while (l < r) {

            int mid = l + (r - l) / 2;
            if (data[mid].compareTo(target) <= 0) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }


    // > target ,返回最小值索引
    // == target, 返回最大索引
    public static <E extends Comparable<E>> int ceil(E[] data, E target) {

        int u = upper(data, target);
        if (u - 1 >= 0 && data[u - 1].compareTo(target) == 0) {
            return u - 1;
        }
        return u;
    }


    // >= target的最小索引
    public static <E extends Comparable<E>> int lower_ceil(E[] data, E target) {

        int l = 0, r = data.length;

        //data[l, r]寻找解
        while (l < r) {

            int mid = l + (r - l) / 2;
            if (data[mid].compareTo(target) < 0) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }


    // < target的最大值索引
    public static <E extends Comparable<E>> int lower(E[] data, E target) {

        int l = -1, r = data.length - 1;

        //data[l, r]寻找解
        while (l < r) {

            int mid = l + (r - l + 1) / 2;
            if (data[mid].compareTo(target) < 0) {
                l = mid;
            } else {
                r = mid - 1;
            }

        }
        return l;
    }


    // 存在target 返回最小索引， 不存在，返回lower
    public static <E extends Comparable<E>> int lower_floor(E[] data, E target) {

        int l = lower(data, target);
        if (l + 1 < data.length && data[l + 1] == target) {
            return l + 1;
        }
        return l;
    }

    // 存在target 返回最大索引， 不存在，返回upper(即 <= target 的最大索引
    public static <E extends Comparable<E>> int upper_floor(E[] data, E target) {

        int l = -1, r = data.length - 1;

        //data[l, r]寻找解
        while (l < r) {

            int mid = l + (r - l + 1) / 2;
            if (data[mid].compareTo(target) <= 0) {
                l = mid;
            } else {
                r = mid - 1;
            }

        }
        return l;
    }

}
