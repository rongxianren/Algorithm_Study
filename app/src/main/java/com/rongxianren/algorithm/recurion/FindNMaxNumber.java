package com.rongxianren.algorithm.recurion;

public class FindNMaxNumber {
    public static void main(String[] args) {
        int[] numArray = {1, 13, 1, 1, 2, 1, 5, 3, 1};
        int resultIndex = findSpecifyMaxNumber(numArray, 8);
        if (resultIndex < 0) {
            System.out.println(" the specify max number is invalid");
            return;
        }
        System.out.println(" the " + resultIndex + " max = " + numArray[resultIndex]);
    }

    private static int findSpecifyMaxNumber(int[] array, int specifyMax) {
        if (array == null || array.length == 0) {
            return -1;
        }

        if (specifyMax >= array.length) {
            return -1;
        }
        int start = 0;
        int end = array.length - 1;
        int index = partition(array, start, end);
        while (index != specifyMax) {
            if (index > specifyMax) {
                index = partition(array, start, index - 1);
            } else {
                index = partition(array, index + 1, end);
            }
        }
        return index;
    }

    private static int partition(int[] array, int start, int end) {
        int temp = array[end];
        while (start < end) {
            while (array[start] <= temp && start < end) {
                start++;
            }
            array[end] = array[start];
            while (array[end] >= temp && end > start) {
                end--;
            }
            array[start] = array[end];
        }
        array[start] = temp;
        return start;
    }
}
