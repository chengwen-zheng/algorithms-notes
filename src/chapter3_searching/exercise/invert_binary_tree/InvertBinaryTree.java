package chapter3_searching.exercise.invert_binary_tree;


public class InvertBinaryTree {
    private TreeNode root;

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode invertTree(TreeNode x) {
        if (x == null) return null;
        if (x.left == null || x.right == null) {
            return null;
        }
        TreeNode t = null;
        t = invertTree(x.left);
        x.left = invertTree(x.right);
        x.right = t;
        return x;
    }

}
