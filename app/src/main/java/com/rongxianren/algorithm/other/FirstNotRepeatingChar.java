package com.rongxianren.algorithm.other;

import android.text.TextUtils;

/**
 * 在字符串中找出第一个只出现一次的字符。如输入"abaccdeff"，则输出'b'。
 */
public class FirstNotRepeatingChar {
    public static void main(String[] args) {
        String testStr = "abaccdeffbd";
        int resultIndex = findFirstNotRepeatingCharIndex(testStr);
        if (resultIndex == -1) {
            System.out.println("Invalid input str");
        } else {
            System.out.println("The first not repeat Char in " + testStr + " is " + testStr.charAt(resultIndex));
        }

    }

    private static int findFirstNotRepeatingCharIndex(String testStr) {
        if (testStr == null || testStr.length() == 0) {
            return -1;
        }
        int[] repeatCountArray = new int[258];
        int result = -1;
        for (int i = 0; i < testStr.length(); i++) {
            int charAscii = testStr.charAt(i);
            repeatCountArray[charAscii] = repeatCountArray[charAscii] + 1;
        }

        for (int i = 0; i < testStr.length(); i++) {
            int charAscii = testStr.charAt(i);
            if (repeatCountArray[charAscii] == 1) {
                result = i;
                break;
            }
        }
        return result;
    }
}
