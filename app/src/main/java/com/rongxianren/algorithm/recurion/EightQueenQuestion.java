package com.rongxianren.algorithm.recurion;


/**
 * 8皇后问题
 * 8x8的棋盘 希望往里面放8个棋子，每个棋子所在的行，列，对角线都不能有另一个棋子
 */
public class EightQueenQuestion {
    private static int totalCount = 0;

    public static void main(String[] args) {
        int[][] queenBoard = new int[8][8];
        callQueens(queenBoard, 0);
        System.out.println("totalCount = " + totalCount);
    }


    private static void callQueens(int[][] queens, int row) {
        if (queens == null || queens[0].length == 0) {
            return;
        }

        if (row == queens.length) {
            printQueen(queens);
            totalCount++;
            return;
        }


        for (int k = 0; k < queens[0].length; k++) {
            if (checkQueens(queens, row, k)) {
                queens[row][k] = 8;
                callQueens(queens, row + 1);
                queens[row][k] = 0;
            }

        }

    }


    /**
     * 检查当前queens的合法性
     * 检查当前位置皇后的合法性
     */
    private static boolean checkQueens(int[][] queens, int row, int column) {

        ///纵向方向
        for (int i = row; i >= 0; i--) {
            if (queens[i][column] == 8) {
                return false;
            }
        }

        ///横向方向
        for (int i = column; i >= 0; i--) {
            if (queens[row][i] == 8) {
                return false;
            }
        }

        ///左上方
        for (int r = row, c = column; r >= 0 && c >= 0; r--, c--) {
            if (queens[r][c] == 8) {
                return false;
            }
        }

        ///右上方
        for (int r = row, c = column; r >= 0 && c < queens[0].length; r--, c++) {
            if (queens[r][c] == 8) {
                return false;
            }
        }

        return true;
    }


    /**
     * 打印合法皇后布局
     *
     * @param queens
     */
    private static void printQueen(int[][] queens) {
        if (queens == null || queens[0].length == 0) {
            return;
        }
        System.out.println("{");

        int row = queens.length;
        int column = queens[0].length;

        for (int i = 0; i < row; i++) {
            for (int k = 0; k < column; k++) {
                System.out.print(queens[i][k] + " ");
            }
            System.out.println();
        }

        System.out.println("}");
    }
}
