package com.backend.bakckend.leet.node;

public class NodeBinarySearchTree {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        if(val < root.val){
            return searchBST(root.left, val);
        }
        return searchBST(root.right, val);
    }

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

    public static void main(String[] args) {
        NodeBinarySearchTree nodeBinarySearchTree = new NodeBinarySearchTree();
        TreeNode root = nodeBinarySearchTree.new TreeNode(4);
        root.left = nodeBinarySearchTree.new TreeNode(2);
        root.right = nodeBinarySearchTree.new TreeNode(7);
        root.left.left = nodeBinarySearchTree.new TreeNode(1);
        root.left.right = nodeBinarySearchTree.new TreeNode(3);

        int val = 2;
        TreeNode result = nodeBinarySearchTree.searchBST(root, val);
        System.out.println(result);
    }
}
