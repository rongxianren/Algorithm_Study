package com.rongxianren.algorithm.sort;

import com.rongxianren.algorithm.sort.impl.HeapSort;
import com.rongxianren.algorithm.sort.inter.Sort;

public class SortAlgorithmClient {
    public static void main(String[] args) {
        int[] data = {4, 5, 6, 3, 2, 1};

        Sort sort;
        sort = new HeapSort();
        sort.sort(data);
        printArray(data);
        int a = 10;

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


