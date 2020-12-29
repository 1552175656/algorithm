package com.lstrong.algorithm.sort;

/**
 * @author Administrator
 */
public class ShellSort {

    private ShellSort() {

    }

    public static <E extends Comparable<E>> void sort(E[] data) {

        int h = data.length / 2;

        while (h >= 1) {

            for (int start = 0; start < h; start++) {

                for (int i = start + h; i < data.length; i += h) {

                    E tmp = data[i];
                    int j;
                    for (j = i; j - h >= 0 && tmp.compareTo(data[j - h]) < 0; j -= h) {
                        data[j] = data[j - h];
                    }
                    data[j] = tmp;
                }
            }

            h /= 2;
        }
    }

    public static <E extends Comparable<E>> void sort2(E[] data) {

        int h = data.length / 2;

        while (h >= 1) {

            for (int i = h; i < data.length; i++) {

                E tmp = data[i];
                int j;
                for (j = i; j - h >= 0 && tmp.compareTo(data[j - h]) < 0; j -= h) {
                    data[j] = data[j - h];
                }
                data[j] = tmp;

            }

            h /= 2;
        }
    }

    public static <E extends Comparable<E>> void sort3(E[] data) {

        int h = 1;
        while (h < data.length) {
            h = h * 3 + 1;
        }

        while (h >= 1) {

            for (int i = h; i < data.length; i++) {

                E tmp = data[i];
                int j;
                for (j = i; j - h >= 0 && tmp.compareTo(data[j - h]) < 0; j -= h) {
                    data[j] = data[j - h];
                }
                data[j] = tmp;
            }

            h /= 3;
        }
    }
}
