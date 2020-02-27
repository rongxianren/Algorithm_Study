package com.rongxianren.algorithm.recurion;

/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐
 * 标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能
 * 够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方
 * 格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个
 * 格子？
 */
public class RobotPathScope {
    private static int sCount = 0;

    public static void main(String[] args) {
        int result = movingCount(15, 20, 20);
        System.out.println("the robot's travelCount = " + result);
    }

    public static int movingCount(int threshold, int rows, int cols) {
        if (rows < 0 || cols < 0 || threshold < 0) {
            return 0;
        }
        int[][] matrix = new int[rows][cols];
        return robotTravel(matrix, threshold, 0, 0);
    }

    private static int robotTravel(int[][] matrix, int threshold, int row, int column) {

        if (matrix[row][column] == -1) {
            return sCount;
        }

        matrix[row][column] = -1;
        sCount++;

        System.out.println("count = " + sCount);
        //左
        if (column - 1 > 0 && matrix[row][column - 1] != -1 && checkPositionValid(matrix, row, column, threshold)) {
//            System.out.println("robotTravel left");
            robotTravel(matrix, threshold, row, column - 1);
        }

        //上
        if (row - 1 > 0 && matrix[row - 1][column] != -1 && checkPositionValid(matrix, row - 1, column, threshold)) {
//            System.out.println("robotTravel up");
            robotTravel(matrix, threshold, row - 1, column);
        }

        //右
        if (column + 1 < matrix[0].length && matrix[row][column + 1] != -1 && checkPositionValid(matrix, row, column + 1, threshold)) {
//            System.out.println("robotTravel right");
            robotTravel(matrix, threshold, row, column + 1);
        }

        //下
        if (row + 1 < matrix.length && matrix[row + 1][column] != -1 && checkPositionValid(matrix, row + 1, column, threshold)) {
//            System.out.println("robotTravel down");
            robotTravel(matrix, threshold, row + 1, column);
        }

        return sCount;
    }

    private static boolean checkPositionValid(int[][] matrix, int row, int column, int threshold) {
        int sum = 0;

        int r = row;
        int col = column;

        while (row != 0) {
            sum = sum + row % 10;
            row = row / 10;
        }

        while (column != 0) {
            sum = sum + column % 10;
            column = column / 10;
        }
//        System.out.println("row = " + r + " column = " + col + " sum = " + sum);
        if (sum <= threshold) {
            return true;
        } else {
            matrix[r][col] = -1;
            return false;
        }
    }
}
