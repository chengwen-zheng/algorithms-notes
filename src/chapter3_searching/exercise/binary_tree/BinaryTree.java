package chapter3_searching.exercise.binary_tree;


import java.util.*;

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
        if (preorder.length == 0) return null;
        if (inorder.length == 0) return null;
        if (preorder.length != inorder.length) return null;
        int root = preorder[0];
        int rootIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root) {
                rootIndex = i;
                break;
            }
        }
        TreeNode left;
        TreeNode right;

        int[] inorderSubLeft = Arrays.copyOfRange(inorder, 0, rootIndex);
        int[] inorderSubRight = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);


        int[] preorderSubLeft = Arrays.copyOfRange(preorder, 1, rootIndex + 1);

        int[] preorderSubRight = Arrays.copyOfRange(preorder, rootIndex + 1, preorder.length);

        right = deduceTree(preorderSubRight, inorderSubRight);
        left = deduceTree(preorderSubLeft, inorderSubLeft);


        return new TreeNode(root, left, right);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                assert node != null;
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(level);
        }

        return res;
    }


}
