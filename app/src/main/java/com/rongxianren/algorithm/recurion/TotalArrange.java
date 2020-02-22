package com.rongxianren.algorithm.recurion;


/**
 * 利用递归打印 一个全排列
 */
public class TotalArrange {
    public static void main(String[] args) {
        int[] data = new int[6];
        totalArrange(data, 0);
    }

    private static void totalArrange(int[] data, int index) {
        if (data == null || data.length == 0) {
            return;
        }

        if (index >= data.length) {
            printArray(data);
            return;
        }

        data[index] = 0;
        totalArrange(data, index + 1);
        data[index] = 1;
        totalArrange(data, index + 1);
    }


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
