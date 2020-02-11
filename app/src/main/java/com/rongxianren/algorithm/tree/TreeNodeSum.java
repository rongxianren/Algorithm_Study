package com.rongxianren.algorithm.tree;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 例如: 给定下面一个二叉树，以及一个n为22,
 * 存在一个从根节点到叶子节点的完整路径 5->4->11->2 ，
 * 每个节点加起来正好为 22，则返回ture.
 * 注意：路径必须是根节点到叶子节点,每个节点可以是正数或负数。
 */
public class TreeNodeSum {

    public static void main(String[] args) {
        int[] values = {5, 17, 11, -7, Integer.MIN_VALUE, Integer.MIN_VALUE, 2, Integer.MIN_VALUE, Integer.MIN_VALUE,
                Integer.MIN_VALUE, -8, 4, Integer.MIN_VALUE, 1, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        Queue valueQueue = new ArrayDeque();
        for (int i = 0; i < values.length; i++) {
            valueQueue.add(values[i]);
        }


        List nodeValues = new ArrayList();
        List nodePath = new ArrayList();

        TreeNode treeRoot = new TreeNode();
        TreeNode.createdBinaryTree(treeRoot, valueQueue);
        treeRoot.traverseInPre(treeRoot, nodeValues);
        System.out.println(nodeValues);


        hasSum = false;
        boolean result = treeNodeSum(treeRoot, 0, 22, nodePath);
        System.out.println("treeNodeSum result = " + result);

    }


    private static boolean hasSum = false;

    public static boolean treeNodeSum(TreeNode root, int current, int sum, List nodePath) {
        if (root.value == Integer.MIN_VALUE) {
            return false;
        }

        current = root.value + current;
        nodePath.add(root.value);
        if (sum == current
                && root.left.value == Integer.MIN_VALUE
                && root.right.value == Integer.MIN_VALUE) {
            System.out.println("存在路径");
            System.out.println(nodePath);
            hasSum = true;
        }

        treeNodeSum(root.left, current, sum, nodePath);
        treeNodeSum(root.right, current, sum, nodePath);
        return hasSum;
    }
}



