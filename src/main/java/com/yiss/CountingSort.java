package com.yiss;

import java.util.Arrays;

public class CountingSort {
    /**
     * @param a 数组内的元素都是正整数，且小于100
     */
    public static void sort(int[] a) {
        if (a == null) {
            throw new IllegalArgumentException("a cannot be null");
        }
        if (a.length <= 0) {
            return;
        }

        // 计数排序，适用场景：排序的元素在一定的范围内。

        int max = a[0];
        for (int i : a) {
            if (i > max) {
                max = i;
            }
        }

        // 注意：数组的长度，边界。
        int[] c = new int[max + 1];
        for (int i = 0; i < max + 1; i++) {
            c[i] = 0;
        }

        for (int i = 0; i < a.length; i++) {
            c[a[i]]++;
        }

        // 计数数组，元素累加
        for (int i = 1; i < max + 1; i++) {
            c[i] += c[i - 1];
        }

        int[] r = new int[a.length];

        for (int i = a.length - 1; i >= 0; i--) {
            // 求index, c的累计数量含义：当前位置，元素值小于、等于当前位置元素值，的元素的个数。
            // 为什么减一？表示索引下标，从0开始。
            int index = c[a[i]]-- - 1;
            r[index] = a[i];
        }

        for (int i = 0; i < a.length; i++) {
            a[i] = r[i];
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 9, 0, 4, 5, 22, 3, 1, 5};
        CountingSort.sort(a);
        System.out.println(Arrays.toString(a));

        int[] b = {1};
        CountingSort.sort(b);
        System.out.println(Arrays.toString(b));
    }

}
