package com.rongxianren.algorithm.tree;

import java.util.List;
import java.util.Queue;

public class TreeNode {


    int value = Integer.MIN_VALUE;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int value) {
        this.value = value;
    }

    /**
     * 递归先序建立树
     *
     * @param root
     * @param nodes
     * @param index
     * @return
     */
    public static int buildTree(TreeNode root, int[] nodes, int index) {
        if (root == null) return -1;
        if (Integer.MIN_VALUE == nodes[index]) {
            return index + 1;
        }

        root.value = nodes[index];

        root.left = new TreeNode();
        int left = buildTree(root.left, nodes, index + 1);


        root.right = new TreeNode();
        int right = buildTree(root.right, nodes, left);
        return right;
    }

    public static void createdBinaryTree(TreeNode root, Queue<Integer> valueQueue) {
        //递归建树二叉树


        int value = valueQueue.poll();
        if (value == Integer.MIN_VALUE) {
            return;
        } else {
            System.out.println("createdBinaryTree  = " + value);

            root.value = value;

            root.left = new TreeNode();
            createdBinaryTree(root.left, valueQueue);

            root.right = new TreeNode();
            createdBinaryTree(root.right, valueQueue);
        }
    }


    /**
     * 递归模式 先序遍历
     *
     * @return
     */
    public static void traverseInPre(TreeNode root, List<Integer> values) {
        /// 这里判断根节点是通过根节点的默认value值来进行的
        if (root.value == Integer.MIN_VALUE)
            return;
        values.add(root.value);

        traverseInPre(root.left, values);
        traverseInPre(root.right, values);
    }


}
