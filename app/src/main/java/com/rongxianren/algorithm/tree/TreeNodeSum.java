package com.rongxianren.algorithm.tree;


import java.util.ArrayList;
import java.util.List;

/**
 * 例如: 给定下面一个二叉树，以及一个n为22,
 * 存在一个从根节点到叶子节点的完整路径 5->4->11->2 ，
 * 每个节点加起来正好为 22，则返回ture.
 * 注意：路径必须是根节点到叶子节点,每个节点可以是正数或负数。
 */
public class TreeNodeSum {

    public static void main(String[] args) {
        int[] values = {5, 4, 11, -7, Integer.MIN_VALUE, Integer.MIN_VALUE, 2, Integer.MIN_VALUE, Integer.MIN_VALUE,
                Integer.MIN_VALUE, -8, 4, Integer.MIN_VALUE, 1, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

        TreeNode root = new TreeNode();
        root.buildTree(root, values, 0);

        List nodeValues = new ArrayList();
        root.traverseInPre(root, nodeValues);
        System.out.println(nodeValues);

        List nodePath = new ArrayList();
        treeNodeSum(root, 0, 22, nodePath);

    }


    public static void treeNodeSum(TreeNode root, int current, int sum, List nodePath) {
        if (root.value == Integer.MIN_VALUE) {
            if (sum == current) {
                System.out.println("存在路径");
                System.out.println(nodePath);
            }
            return;
        }
        current = root.value + current;
        nodePath.add(root.value);
        treeNodeSum(root.left, current, sum, nodePath);
        treeNodeSum(root.right, current, sum, nodePath);
    }
}



