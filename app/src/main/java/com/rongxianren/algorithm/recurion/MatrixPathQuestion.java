package com.rongxianren.algorithm.recurion;

/**
 * 剑指offer
 * <p>
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向
 * 下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该
 * 格子。 例如
 * {
 * a b c e
 * s f c s
 * a d e e
 * }
 * 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class MatrixPathQuestion {

    private static boolean hasPath = false;

    public static void main(String[] args) {
        String[][] matrix = {
                {"a", "b", "c", "e"},
                {"s", "f", "c", "s"},
                {"a", "d", "e", "e"}
        };
//        String target = "bcced";
        String target = "abcese";

        int row = matrix.length;
        int column = matrix[0].length;

        boolean result = false;
        for (int i = 0; i < row; i++) {
            for (int k = 0; k < column; k++) {
                result = findMatrixPath(matrix, i, k, "", target);
                if (result) {
                    break;
                }
            }
        }
        System.out.println("this path is in the Matrix = " + result);
    }

    private static boolean findMatrixPath(String[][] matrix, int row, int column, String path, String target) {

        path = path + matrix[row][column];

        if (!target.startsWith(path)) {
            return false;
        }
        System.out.println("the path = " + (path));

        //左
        if (column - 1 >= 0 && target.startsWith(path + matrix[row][column - 1])) {
            System.out.println("left the path = " + (path));
//            path = path + matrix[row][column - 1];
            System.out.println("path + matrix[row][column - 1] = " + (path + matrix[row][column - 1]));
            if (target.equals(path + matrix[row][column - 1])) {
                hasPath = true;
                return hasPath;
            }
            findMatrixPath(matrix, row, column - 1, path, target);
            path = path.substring(0, path.length() - 1);
        }

        //上
        if (row - 1 >= 0 && target.startsWith(path + matrix[row - 1][column])) {
            System.out.println("up the path = " + (path));
//            path = path + matrix[row - 1][column];
            if (target.equals(path + matrix[row - 1][column])) {
                hasPath = true;
                return hasPath;
            }
            findMatrixPath(matrix, row - 1, column, path, target);
            path = path.substring(0, path.length() - 1);
        }


        //右
        if (column + 1 < matrix[0].length && target.startsWith(path + matrix[row][column + 1])) {
            System.out.println("right the path = " + (path));
//            path = path + matrix[row][column + 1];
            if (target.equals(path + matrix[row][column + 1])) {
                hasPath = true;
                return hasPath;
            }
            findMatrixPath(matrix, row, column + 1, path, target);
            path = path.substring(0, path.length() - 1);
        }


        //下
        if (row + 1 < matrix.length && target.startsWith(path + matrix[row + 1][column])) {
            System.out.println("down the path = " + (path));
//            path = path + matrix[row + 1][column];
            if (target.equals(path + matrix[row + 1][column])) {
                hasPath = true;
                return hasPath;
            }
            findMatrixPath(matrix, row + 1, column, path, target);
            path = path.substring(0, path.length() - 1);
        }

        System.out.println(" hasPath = " + hasPath);
        return hasPath;
    }
}
