package com.yiss;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {
    public void sort(int[] a) {
        if (a == null) {
            throw new IllegalArgumentException("a cannot be null");
        }

        // 归并排序：分治思想，大问题拆分成小问题。
        // 大数组拆分成小数组，递归的过程，终止条件：数组元素数量==1时，这个数组自然有序。 合并两个有序的数组
        int size = a.length;
        if (size <= 1) {
            return;
        }
        partition(a, 0, size - 1);

    }

    private void partition(int[] a, int p, int r) {
        // why? == 是否可以？
        if (p >= r) {
            return;
        }
        int q = p + (r - p) / 2;
        partition(a, p, q);
        partition(a, q + 1, r);
        merge(a, p, q, r);
    }

    /**
     * 合并两个有序数组
     */
    private void merge(int[] a, int p, int q, int r) {
        // 注意j索引的位置
        int i = p, j = q + 1, k = 0;
        int[] tmp = new int[r - p + 1];

        while (i <= q && j <= r) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }

        // 移动剩余的元素
        int start = i, end = q;
        // 注意条件
        if (j <= r) {
            start = j;
            end = r;
        }

        for (int l = start; l <= end; l++) {
            tmp[k++] = a[l];
        }

        int m = p;
        for (int l = 0; l < r - p + 1; l++) {
            a[m++] = tmp[l];
        }
    }


    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] a = {1, 2, 3, 4, 5};
        mergeSort.sort(a);
        System.out.println(Arrays.toString(a));
        int[] c = {1, 2, 3, 4, 6, 7, 5, 6};
        mergeSort.sort(c);
        System.out.println(Arrays.toString(c));

        int[] b = {};
        mergeSort.sort(b);
        System.out.println(Arrays.toString(b));
    }

}
