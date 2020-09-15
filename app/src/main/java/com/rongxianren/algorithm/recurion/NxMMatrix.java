package com.rongxianren.algorithm.recurion;

/**
 * nxm的的格子矩阵，从矩阵的左下角移动到右上角，每次只能向右或者向上移动一个
 * 格子。求一共有多少种走法。
 */
public class NxMMatrix {

    private static int Raw = 3;
    private static int Column = 2;

    public static void main(String[] args) {
        int n = move(Raw, 1);
        System.out.println(" n  = " + n);
    }

    public static int move(int y, int x) {
        if (x == Column) {
            return 1;
        }

        if (y == 1) {
            return 1;
        }

        return move(y - 1, x) + move(y, x + 1);

    }

}
