package com.rongxianren.algorithm.search.impl;

import com.rongxianren.algorithm.search.inter.Search;

public class BinarySearch extends Search {
    @Override
    public int search(int[] data, int element) {
//        return bSearch(data, 0, data.length - 1, element);
//        return bSearchRecursion(data, 0, data.length - 1, element);
//        return lastEqualSearch(data, 0, data.length - 1, element);
//        return firstBiggerSearch(data, 0, data.length - 1, element);
        return lastSmallSearch(data, 0, data.length - 1, element);
    }


    /**
     * 非递归实现方式
     */
    private int bSearch(int[] data, int low, int high, int target) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target > data[mid]) {
                low = mid + 1;
            } else if (target < data[mid]) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    /**
     * 递归实现
     *
     * @param data
     * @param low
     * @param high
     * @param target
     * @return
     */
    private int bSearchRecursion(int[] data, int low, int high, int target) {
        if (low > high) return -1;
        int mid = (low + high) / 2;
        if (target > data[mid]) {
            return bSearchRecursion(data, mid + 1, high, target);
        } else if (target < data[mid]) {
            return bSearchRecursion(data, low, mid - 1, target);
        } else {
            return mid;
        }
    }

    /**
     * 查找第一个 等于指定元素的位置
     *
     * @return
     */
    private int firstEqualSearch(int[] data, int low, int high, int target) {
        if (low > high) return -1;

        int mid = low + ((high - low) >> 1);
        System.out.println("firstEqualSearch mid = " + mid);
        if (target > data[mid]) {
            return firstEqualSearch(data, mid + 1, high, target);
        } else if (target < data[mid]) {
            return firstEqualSearch(data, low, mid - 1, target);
        } else {
            if (mid == 0 || data[mid - 1] != target) {
                return mid;
            }
            return firstEqualSearch(data, low, mid - 1, target);
        }
    }

    /**
     * 查找最后一个 等于指定元素的位置
     *
     * @return
     */
    private int lastEqualSearch(int[] data, int low, int high, int target) {
        if (low > high) return -1;

        int mid = low + ((high - low) >> 1);
        if (target > data[mid]) {
            return lastEqualSearch(data, mid + 1, high, target);
        } else if (target < data[mid]) {
            return lastEqualSearch(data, low, mid - 1, target);
        } else {
            if (mid == data.length - 1 || data[mid + 1] != target) {
                return mid;
            }
            return lastEqualSearch(data, mid + 1, high, target);
        }
    }


    /**
     * 查找第一个大于给定值的元素
     *
     * @param data
     * @param low
     * @param high
     * @param target
     * @return
     */
    private int firstBiggerSearch(int[] data, int low, int high, int target) {
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (target >= data[mid]) {
                low = mid + 1;
            } else if (target < data[mid]) {
                if (mid == 0 || data[mid - 1] <= target) {
                    return mid;
                }
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个小于给定值的元素
     *
     * @param data
     * @param low
     * @param high
     * @param target
     * @return
     */
    private int lastSmallSearch(int[] data, int low, int high, int target) {
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (target <= data[mid]) {
                high = mid - 1;
            } else if (target > data[mid]) {
                if (mid == data.length - 1 || data[mid + 1] >= target) {
                    return mid;
                }
                low = mid + 1;
            }
        }
        return -1;
    }
}
