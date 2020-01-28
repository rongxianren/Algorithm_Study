package com.rongxianren.algorithm.sort.impl;

import com.rongxianren.algorithm.sort.inter.Sort;

public class QuickSort extends Sort {

    @Override
    public void sort(int[] data) {
        quickSort(data, 0, data.length - 1);
    }

    /**
     * 快速排序
     *
     * <p>
     * 原地排序算法
     * 非稳定性排序
     * 时间复杂度 平均复杂度O(nlogn)  最差的情况O(n^2)
     * （1，3，5，6，8  这个序列  一最后一个元素为pivot）
     * 那每次分区得到的两个区间都是不均等的。
     * 我们需要进行大约 n 次分区操作，才能完成快排的整个过程。
     * 每次分区我们平均要扫描大约 n/2 个元素，这种情况下，
     * 快排的时间复杂度就从 O(nlogn) 退化成了 O(n2)
     *
     * @param data
     * @param left
     * @param right
     */
    public static void quickSort(int[] data, int left, int right) {

        if (left >= right)
            return;

        int pivot = partition(data, left, right);///寻找pivot点

        quickSort(data, left, pivot - 1); //左侧递归
        quickSort(data, pivot + 1, right); //右侧递归

    }


    /**
     * 寻找pivot  把数组分成三个部分  low--(pivot-1)  pivot  (pivot+1)-high
     * {4, 5, 6, 3, 2, 1}
     *
     * @param data
     * @param left
     * @param right
     * @return
     */
    private static int partition(int[] data, int left, int right) {
        int pivot = data[right];
        while (left < right) {
            while (left < right && data[left] <= pivot) left++;
            data[right] = data[left];

            while (left < right && data[right] >= pivot) right--;
            data[left] = data[right];
        }
        data[right] = pivot;
        System.out.println("left = " + left + " right = " + right);
        return right;
    }
}
