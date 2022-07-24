package com.rongxianren.algorithm.other;

import android.text.style.AlignmentSpan;

import java.util.ArrayList;
import java.util.List;

/**
 * 我们把只包含因子2、3和5的数称作丑数（UglyNumber）。
 * 求按从小到大的顺序的第1500个丑数。例如6、8都是丑数，但14不是，
 * 因为它包含因子7。习惯上我们把1当做第一个丑数。
 */
public class UglyNumber {
    public static void main(String[] args) {
        List numbers = new ArrayList<Integer>();
        numbers.add(1);
        int numberIndex = 1500;
        int result = findSpecifyUglyNumber(numbers, numberIndex);
        System.out.println(" The " + numberIndex + " is " + result);
    }

    private static int findSpecifyUglyNumber(List<Integer> numbers, int uglyNumberIndex) {
        int uglyNumber2 = 0, uglyNumber3 = 0, uglyNumber5 = 0;
        int index = 1;
        while (index < uglyNumberIndex) {
            int lastIndex = numbers.size() - 1;
            for (int value : numbers) {
                if (value * 2 > numbers.get(lastIndex)) {
                    uglyNumber2 = value * 2;
                    break;
                }
            }

            for (int value : numbers) {
                if (value * 3 > numbers.get(lastIndex)) {
                    uglyNumber3 = value * 3;
                    break;
                }
            }

            for (int value : numbers) {
                if (value * 5 > numbers.get(lastIndex)) {
                    uglyNumber5 = value * 5;
                    break;
                }
            }
            numbers.add(Min(uglyNumber2, uglyNumber3, uglyNumber5));
            index = index + 1;
        }
        return numbers.get(index-1);
    }

    private static int Min(int number1, int number2, int number3) {
        return Math.min(Math.min(number1, number2), number3);
    }
}
