package com.backend.bakckend.leet.node;

public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }

        //값이 같고, 서브트리끼리도 같으면 대칭
        return (t1.val == t2.val) && isSymmetric(t1.left, t2.right) && isSymmetric(t1.right, t2.left);
    }

    public static void main(String[] args) {
        IsSymmetric isSymmetric = new IsSymmetric();
        TreeNode root = isSymmetric.new TreeNode(1);
        root.left = isSymmetric.new TreeNode(2);
        root.right = isSymmetric.new TreeNode(2);
        root.left.left = isSymmetric.new TreeNode(3);
        root.left.right = isSymmetric.new TreeNode(4);
        root.right.left = isSymmetric.new TreeNode(4);
        root.right.right = isSymmetric.new TreeNode(3);
        System.out.println(isSymmetric.isSymmetric(root));
    }


     // Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

}
