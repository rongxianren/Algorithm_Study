package com.rongxianren.algorithm.tree;

import java.util.List;

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
    public int buildTree(TreeNode root, int[] nodes, int index) {
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


    /**
     * 递归模式 先序遍历
     *
     * @return
     */
    public void traverseInPre(TreeNode root, List<Integer> values) {
        if (root == null || root.value == Integer.MIN_VALUE)
            return;
        values.add(root.value);

        traverseInPre(root.left, values);
        traverseInPre(root.right, values);
    }


}
