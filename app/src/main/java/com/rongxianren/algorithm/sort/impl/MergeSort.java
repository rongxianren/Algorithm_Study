package com.rongxianren.algorithm.sort.impl;

import com.rongxianren.algorithm.sort.inter.Sort;

public class MergeSort extends Sort {
    @Override
    public void sort(int[] data) {
        mergeSort(data, 0, data.length - 1);
    }

    /**
     * 归并排序
     * {4, 5, 6, 3, 2, 1}
     * 稳定排序算法
     * 时间复杂度为O(nlogn)
     * 非原地排序算反  空间复杂度为 O(n)
     * 归并排序的关键在于  分解后的归并函数
     *
     * @param data
     */
    public static void mergeSort(int[] data, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(data, start, mid);
        mergeSort(data, mid + 1, end);

        //merge(data, start, mid, end);
        merge2(data, start, mid, end);
    }

    /**
     * @param data
     * @param start 实际下标值
     * @param mid   实际下标值
     * @param end   实际下标值
     *              <p>
     *              不带哨兵的merge实现
     */
    private static void merge(int[] data, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int pre = start;
        int after = mid + 1;

        int i = 0;
        for (; i < temp.length; i++) {
            if (pre > mid || after > end) {
                break;
            }

            if (data[pre] > data[after]) {
                temp[i] = data[after++];
            } else {
                temp[i] = data[pre++];
            }
        }

        for (; i < temp.length; i++) {
            if (pre <= mid) {
                temp[i] = data[pre++];
            }

            if (after <= end) {
                temp[i] = data[after++];
            }
        }

        /// 把归并好的部分 复制到指定位置
        for (int k = start, l = 0; k <= end; k++, l++) {
            data[k] = temp[l];
        }
    }

    /**
     * 带哨兵的实现方式
     */
    public static void merge2(int[] data, int start, int mid, int end) {

        ///mid - start + 2 d多分配一个位置 放置哨兵
        int[] leftArray = new int[mid - start + 2];
        int[] rightArray = new int[end - mid + 1];


        for (int k = start, index = 0; index < leftArray.length - 1; k++, index++) {
            leftArray[index] = data[k];
        }
        leftArray[leftArray.length - 1] = Integer.MAX_VALUE; //哨兵

        for (int k = mid + 1, index = 0; index < rightArray.length - 1; k++, index++) {
            rightArray[index] = data[k];
        }
        rightArray[rightArray.length - 1] = Integer.MAX_VALUE; //哨兵

        int leftIndex = 0, rightIndex = 0;

        for (int i = start; i <= end; i++) {
            ///有了哨兵后  leftIndex 和 rightIndex 可以省去边界判断
            if (leftArray[leftIndex] > rightArray[rightIndex]) {
                data[i] = rightArray[rightIndex++];
            } else {
                data[i] = leftArray[leftIndex++];
            }
        }

    }

}
