package com.rongxianren.algorithm.sort.impl;

import com.rongxianren.algorithm.sort.inter.Sort;

public class BubbleSort extends Sort {
    @Override
    public void sort(int[] data) {
        bubbleSort(data);
    }

    /**
     * 冒泡排序
     * <p>
     * 稳定的排序算法
     * 原地排序算法
     * 时间复杂度最好O(n) 最坏O(n^2)
     *
     * @param data
     * @return
     */
    public static int[] bubbleSort(int[] data) {
        if (data == null) {
            return null;
        }

        int temp = 0;
        for (int k = 0; k < data.length; k++) {
            boolean hasChange = false;

            ///易错点 data.length - k - 1  这里容易忽略-1造成 l+1边界越界问题
            for (int l = 0; l < data.length - k - 1; l++) {
                if (data[l] > data[l + 1]) {
                    temp = data[l];
                    data[l] = data[l + 1];
                    data[l + 1] = temp;
                    hasChange = true;
                }
            }
            if (!hasChange) {
                break;
            }
        }
        return data;
    }

}
