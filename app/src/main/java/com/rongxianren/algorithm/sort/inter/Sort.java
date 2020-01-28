package com.rongxianren.algorithm.sort.inter;

public abstract class Sort {
    public abstract void sort(int[] data);

    protected static void printArray(int[] data) {
        StringBuilder builder = new StringBuilder();
        builder.append("[ ");
        for (int item : data) {
            builder.append(item + " ");
        }
        builder.append("]");
        System.out.println(builder.toString());
    }
}
