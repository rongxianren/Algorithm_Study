package com.rongxianren.algorithm.recurion;

import java.util.HashSet;
import java.util.Set;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在
 * 数组中出现了5次，超过数组长度的一半，因此输出2。
 */
public class MoreThanHalfNum {

    public static void main(String[] args) {
        int[] numArray = {1, 13, 1, 1, 2, 1, 5, 3, 1};
        int result = moreThanHalfNum(numArray);
        System.out.println("result = " + numArray[result]);

        int[] invalidArray = {1, 13, 2, 3, 2, 6, 5, 3, 1};
        int result2 = moreThanHalfNum(invalidArray);
        System.out.println("result2 = " + invalidArray[result2]);
    }

    private static int moreThanHalfNum(int[] numArray) {
        int result = Integer.MIN_VALUE;
        if (numArray.length <= 0) {
            return result;
        }
        int middle = numArray.length >> 1;
        int start = 0;
        int end = numArray.length - 1;
        int index = partition(numArray, start, end);
        while (index != middle) {
            if (index < middle) {
                index = index + 1;
                index = partition(numArray, index, end);
            } else {
                index = index - 1;
                index = partition(numArray, start, index);
            }
        }
        return index;
    }

    /**
     * 找 pivot点
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    private static int partition(int[] array, int start, int end) {
        int temp = array[end];
        while (start < end) {
            while (start < end && array[start] <= temp) {
                start++;
            }

            array[end] = array[start];

            while (end > start && array[end] >= temp) {
                end--;
            }
            array[start] = array[end];
        }
        array[start] = temp;
        return start;
    }
}
