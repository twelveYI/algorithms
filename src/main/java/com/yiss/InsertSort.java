package com.yiss;

import java.util.Arrays;

public class InsertSort {
    public void sort(int[] a) {
        if (a == null) {
            throw new IllegalArgumentException("a cannot be null");
        }
        int size = a.length;
        // 一个元素的场景，不需要排序
        if (size <= 1) {
            return;
        }

        // 已排序区间，未排序区间；未排序区间的首元素（存储到栈中），插入到已排序区间，并且保证已排序区间有序。
        // 比较、移动

        // 从索引为1的元素开始；注意条件判断。ss
        for (int i = 1; i < size; i++) {
            int value = a[i];

            for (int j = i - 1; j >= 0; j--) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    // 注意索引位置
                    a[j + 1] = value;
                    break;
                }
            }
        }

    }

    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        int[] a = {1, 2, 3, 6, 5, 4};
        insertSort.sort(a);
        System.out.println(Arrays.toString(a));
        insertSort.sort(new int[]{});
        insertSort.sort(new int[]{1});
    }
}
