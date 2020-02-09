package com.rongxianren.algorithm.greed_algorithm;

/**
 * 万圣节到了，小明从n个糖果屋领取糖果，每次领取的糖果屋互不相领，小明怎么才能拿到最多的糖果,返回最多取法？
 * 糖果屋的糖果数：[1,5,3,1,5,2,8,9,1,4]
 */
public class CandyQuestion {
    public int[] takeCandys(int[] candys) {

        int placeHodler = -1;
        int max = placeHodler;
        int index = 0;
        do {
            max = placeHodler;
            for (int i = 0; i < candys.length; i++) {
                if (max < candys[i]) {
                    max = candys[i];
                    index = i;
                }
            }
            if (index - 1 > 0 && index + 1 < candys.length) {

            }
        } while (max == placeHodler);


        return null;
    }
}
