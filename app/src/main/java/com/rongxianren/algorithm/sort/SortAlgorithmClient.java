package com.rongxianren.algorithm.sort;

import com.rongxianren.algorithm.sort.impl.QuickSort;
import com.rongxianren.algorithm.sort.inter.Sort;

public class SortAlgorithmClient {
    public static void main(String[] args) {
        int[] data = {4, 5, 6, 3, 2, 1};

        Sort sort;
        sort = new QuickSort();
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

    public static void quickSort(int[] data, int low, int high){
        if(low>=high)
            return;
        int pivot = partition(data, low, high);
        quickSort(data, low, pivot-1);
        quickSort(data, pivot+1, high);
    }

    public static int partition(int[] data, int start, int end){
        int pivot = data[end];
        while(start<end){
            while(start < end && data[start]< pivot )start++;
            data[end] = data[start];
            end--;
            while(start<end && data[end]>=pivot) end--;
            data[start] = data[end];
            start++;
        }
        data[end] = pivot;
        return end;
    }
}


