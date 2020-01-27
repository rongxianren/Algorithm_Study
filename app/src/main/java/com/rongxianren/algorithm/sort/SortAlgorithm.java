package com.rongxianren.algorithm.sort;

public class SortAlgorithm {
    public static void main(String[] args) {
        int[] data = {4, 5, 6, 3, 2, 1};
        SortUtils.bubbleSort(data);
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


