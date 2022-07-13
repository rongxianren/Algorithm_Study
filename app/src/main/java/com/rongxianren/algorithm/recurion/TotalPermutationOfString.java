package com.rongxianren.algorithm.recurion;

import java.util.HashSet;
import java.util.Set;

/**
 * 字符串全排列
 */
public class TotalPermutationOfString {

    public static void main(String[] args) {
        String testStr = "12345678";
        Set<String> resultSet = new HashSet<String>();
        totalPermutation(testStr.toCharArray(), 0, resultSet);
        for (String value : resultSet) {
            //有相同字符的话就要用set去重
            //System.out.println(value);
        }
    }

    private static void totalPermutation(char[] charArray, int beginIndex, Set<String> resultSet) {
        if (beginIndex >= charArray.length) {
            resultSet.add(new String(charArray));
            System.out.println(charArray);
            return;
        }
        for (int i = beginIndex; i < charArray.length; i++) {
            swapChar(charArray, beginIndex, i);
            totalPermutation(charArray, beginIndex + 1, resultSet);
            swapChar(charArray, beginIndex, i);
        }
    }

    private static void swapChar(char[] charArray, int right, int left) {
        char temp = charArray[right];
        charArray[right] = charArray[left];
        charArray[left] = temp;
    }
}
