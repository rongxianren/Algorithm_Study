package com.rongxianren.algorithm.sort.impl;

import com.rongxianren.algorithm.sort.inter.Sort;

public class InsertSort extends Sort {
    @Override
    public void sort(int[] data) {
        insertSort(data);
    }

    /**
     * 插入排序
     * <p>
     * 稳定排序算法
     * 原地排序
     * 时间复杂度最好O(n) 最坏O(n^2)
     */
    public static void insertSort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int temp = data[i];
            int k = i - 1;
            for (; k >= 0; k--) {
                if (data[k] > temp) {
                    data[k + 1] = data[k];
                } else {
                    break;
                }
            }
            data[k + 1] = temp;
        }
    }
}
