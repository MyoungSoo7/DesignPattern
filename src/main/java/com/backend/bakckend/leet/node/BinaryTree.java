package com.backend.bakckend.leet.node;

public class BinaryTree {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode root = binaryTree.new TreeNode(1);
        root.right = binaryTree.new TreeNode(2);
        root.right.left = binaryTree.new TreeNode(3);
     ///   System.out.println(binaryTree.inorderTraversal(root));
    }
/*
    public List<Integer> inorderTraversal(TreeNode root) {

    }*/

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
