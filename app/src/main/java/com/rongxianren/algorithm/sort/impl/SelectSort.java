package com.rongxianren.algorithm.sort.impl;

import com.rongxianren.algorithm.sort.inter.Sort;

public class SelectSort extends Sort {

    @Override
    public void sort(int[] data) {
        selectSort(data);
    }

    /**
     * 选择排序
     * 原地排序
     * 非稳定性排序  (5，8，5，2，9  这个序列就可以体现其非稳定性)
     * 时间复杂度 最好最坏平均都是O(n^2)
     *
     * @param data
     */
    public static void selectSort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int temp = data[i];
            int index = i;
            for (int k = i; k < data.length; k++) {
                if (temp > data[k]) {
                    temp = data[k];
                    index = k;
                }
            }
            data[index] = data[i];
            data[i] = temp;
        }
    }

}
