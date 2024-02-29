package chapter3_searching.exercise.binary_tree;


import java.util.Arrays;

public class BinaryTree {
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

        TreeNode t = null;
        t = invertTree(x.left);
        x.left = invertTree(x.right);
        x.right = t;
        return x;
    }

    public TreeNode pruneTree(TreeNode x) {
        if (x == null) return null;

        x.left = pruneTree(x.left);
        x.right = pruneTree(x.right);
        if (x.left == null && x.right == null && x.val == 0) {
            return null;
        }

        return x;
    }

    public int calculateDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(calculateDepth(root.left), calculateDepth(root.right));
    }


    public TreeNode deduceTree(int[] preorder, int[] inorder) {
        // 计算出root元素
        int root = preorder[0];
        int rootIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i] == root){
                rootIndex = i;
                break;
            }
        }
        int[] subLeft = Arrays.copyOfRange(inorder, 0, rootIndex);
        int[] right = Arrays.copyOfRange(inorder, rootIndex, inorder.length-1);


        int subLeftLen = subLeft.length;



    }





}
