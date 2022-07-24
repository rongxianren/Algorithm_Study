package com.rongxianren.algorithm.sort;

import com.rongxianren.algorithm.sort.impl.HeapSort;
import com.rongxianren.algorithm.sort.impl.QuickSort;
import com.rongxianren.algorithm.sort.inter.Sort;

public class SortAlgorithmClient {
    public static void main(String[] args) {
        int[] data = {1, 1, 4, 5, 2};

        Sort sort;
        sort = new HeapSort();
        sort.sort(data);
        printArray(data);
    }

    public static void printArray(int[] data) {
        StringBuilder builder = new StringBuilder();
        builder.append("[ ");
        for (int item : data) {
            builder.append(item + " ");
        }
        builder.append("]");
        System.out.println(builder.toString());
    }
}


