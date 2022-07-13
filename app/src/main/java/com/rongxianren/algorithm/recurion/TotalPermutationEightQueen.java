package com.rongxianren.algorithm.recurion;

import java.util.HashSet;
import java.util.Set;

/**
 * 利用数组全排列求解八皇后问题
 * a[8] 下标表示行，下标对应的值代表列。  a[8]={0,1,2,3,4,5,6,7}
 */
public class TotalPermutationEightQueen {
    private static int sCount = 0;

    public static void main(String[] args) {
        int[] queenArray = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
        Set<String> resultSet = new HashSet<String>();
        totalPermutation(queenArray, 0);
        for (String value : resultSet) {
            //有相同字符的话就要用set去重
            //System.out.println(value);
        }
        System.out.println("sCount = " + sCount);
    }

    private static void totalPermutation(int[] queenArray, int beginIndex) {
        if (beginIndex >= queenArray.length) {
//            printArray(queenArray);
            if (checkQueen(queenArray)) {
                sCount = sCount + 1;
                printQueenArray(queenArray);
            }
        }
        for (int i = beginIndex; i < queenArray.length; i++) {
            swapValue(queenArray, beginIndex, i);
            totalPermutation(queenArray, beginIndex + 1);
            swapValue(queenArray, beginIndex, i);
        }
    }

    private static void swapValue(int[] queenArray, int right, int left) {
        int temp = queenArray[right];
        queenArray[right] = queenArray[left];
        queenArray[left] = temp;
    }

    private static void printArray(int[] queenArray) {
        for (int value : queenArray) {
            System.out.print(value);
        }
        System.out.println();
    }

    private static void printQueenArray(int[] queenArray) {
        for (int i = 0; i < queenArray.length; i++) {
            for (int j = 0; j < queenArray.length; j++) {
                if (queenArray[i] == j) {
                    System.out.print("8 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
        System.out.println("-------------------");
    }

    private static boolean checkQueen(int[] queenArray) {
        for (int i = 0; i < queenArray.length; i++) {
            for (int j = i + 1; j < queenArray.length; j++) {
                if (i + queenArray[i] == j + queenArray[j] || queenArray[i] - i == queenArray[j] - j) {
                    return false;
                }
            }
        }
        return true;
    }
}
