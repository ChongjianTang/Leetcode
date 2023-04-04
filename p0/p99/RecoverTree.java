package leetcode.p0.p99;


class TreeNode {
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

public class RecoverTree {
    public static void recoverTree(TreeNode root) {
        node1 = null;
        node2 = null;
        prev = null;
        dfs1(root);
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }

    public static void dfs1(TreeNode root) {
        if (root.left != null) {
            dfs1(root.left);
        }
        if (prev != null) {
            if (prev.val > root.val) {
                if (node1 == null) {
                    node1 = prev;
                }
                node2 = root;
            }
        }
        prev = root;

        if (root.right != null) {
            dfs1(root.right);
        }
    }


    public static TreeNode node1;

    public static TreeNode node2;

    public static TreeNode prev;


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);

        recoverTree(root);
    }
}
