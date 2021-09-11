package com.yiss;

import java.util.Arrays;

public class QuickSort {
    public static void sort(int[] a) {
        if (a == null) {
            throw new IllegalArgumentException("a cannot be null");
        }
        // 分治思想，分为两个区间，区间之间有序，区间内部元素无序。递归终止条件：区间内只有一个元素时。
        // 选择一个pivot，两个指针i，j，小于pivot的元素a[j]，移动到i索引位置
        int size = a.length;
        partition(a, 0, size - 1);
    }

    private static void partition(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }

        int i = start, pivot = end;
        // 一共三个区间；pivot 一个区间；
        for (int j = i; j < pivot; j++) {
            if (a[j] < a[pivot]) {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                i++;
            }
        }

        int tmp = a[i];
        a[i] = a[pivot];
        a[pivot] = tmp;

        partition(a, start, i - 1);
        partition(a, i + 1, end);
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 6, 5, 1};
        QuickSort.sort(a);
        System.out.println(Arrays.toString(a));

        int[] b = {};
        QuickSort.sort(b);

        int[] c = {1};
        QuickSort.sort(c);

        int[] d = {2, 1};
        QuickSort.sort(d);
        System.out.println(Arrays.toString(d));
    }
}
