package com.yiss;

import java.util.Arrays;

public class SelectionSort {
    public void sort(int[] a) {
        if (a == null) {
            throw new IllegalArgumentException("a cannot be null");
        }
        // 已排序区间，未排序区间；从未排序区间，查找最小的元素，插入到已排序队尾位置。

        int size = a.length;
        for (int i = 0; i < size - 1; i++) {

            int minPos = i;
            for (int j = i; j < size; j++) {
                if (a[j] < a[minPos]) {
                    minPos = i;
                }
            }

            int tmp = a[i];
            a[i] = a[minPos];
            a[minPos] = tmp;

        }
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] a = {1, 2, 3};
        selectionSort.sort(a);
        System.out.println(Arrays.toString(a));

        int[] b = {};
        selectionSort.sort(b);
        System.out.println(Arrays.toString(b));
    }
}
