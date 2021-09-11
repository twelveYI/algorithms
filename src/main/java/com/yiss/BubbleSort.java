package com.yiss;

import java.util.Arrays;

public class BubbleSort {
    public void sort(int[] a) {
        if (a == null) {
            throw new IllegalArgumentException("a cannot be null");
        }
        int size = a.length;
        for (int i = 0; i < size; i++) {
            // 标志位：当前循环交换过元素
            boolean flag = false;

            // 内层循环的指针 j, 代表待比较第一个元素，j+1是待比较的第二个元素；注意j 的边界
            for (int j = 0; j < size - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    // 每一个元素，比较、交换；
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] a = {1, 2, 3, 4, 9, 8, 7, 6, 5};
        System.out.println(Arrays.toString(a));
        bubbleSort.sort(a);
        System.out.println(Arrays.toString(a));
        bubbleSort.sort(new int[]{});
        bubbleSort.sort(null);
    }
}
