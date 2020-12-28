package com.lstrong.algorithm.sort;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2020/12/28 20:29<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class BubbleSort {

    private BubbleSort() {

    }

    public static <E extends Comparable<E>> void sort(E[] data) {

        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    swap(data, j, j + 1);
                }
            }
        }
    }

    public static <E extends Comparable<E>> void sort2(E[] data) {

        for (int i = 0; i < data.length - 1; i++) {

            boolean isSwapped = false;
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    swap(data, j, j + 1);
                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                break;
            }
        }
    }

    public static <E extends Comparable<E>> void sort3(E[] data) {

        for (int i = 0; i < data.length - 1;) {

            int lastSwappedIndex = 0;
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    swap(data, j, j + 1);
                    lastSwappedIndex = j + 1;
                }
            }
//            if (lastSwappedIndex == 0) {
//                break;
//            }
            i = data.length - lastSwappedIndex;
        }
    }

    private static <E> void swap(E[] data, int i, int j) {
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
