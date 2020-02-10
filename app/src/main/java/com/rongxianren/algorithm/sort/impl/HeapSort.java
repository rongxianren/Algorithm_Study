package com.rongxianren.algorithm.sort.impl;

import com.rongxianren.algorithm.sort.inter.Sort;


/**
 * 插入排序
 * <p>
 * 非稳定排序算法
 * 原地排序
 * 时间复杂度最好O(nlogn)
 */
public class HeapSort extends Sort {
    @Override
    public void sort(int[] data) {
        heapify(data, data.length);
        heapSort(data);
    }


    /**
     * 构造大跟堆
     *
     * @param data
     */
    private void heapify(int[] data, int length) {
        if (data == null || data.length == 0)
            return;
        int start = (length) / 2 - 1;

        for (int k = start; k >= 0; k--) {
            int index = k;
            int tempIndex = index;
            
            while (true) {
                if (index * 2 + 1 < length && data[index] < data[index * 2 + 1]) {
                    tempIndex = index * 2 + 1;
                }

                if (index * 2 + 2 < length && data[tempIndex] < data[index * 2 + 2]) {
                    tempIndex = index * 2 + 2;
                }

                if (index == tempIndex) {
                    break;
                }
                swap(data, index, tempIndex);
                index = tempIndex;
            }
        }
    }

    /**
     * 堆化后开始 堆排序
     *
     * @param data
     */
    private void heapSort(int[] data) {
        if (data == null || data.length <= 1)
            return;
        int endIndex = data.length;
        while (endIndex > 0) {
            swap(data, 0, endIndex - 1);
            heapify(data, endIndex - 1);
            endIndex--;
        }
    }

    private void swap(int[] data, int index1, int index2) {
        if (index1 > data.length || index2 > data.length) {
            return;
        }
        int temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }
}
