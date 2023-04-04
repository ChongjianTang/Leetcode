package leetcode.p16.p1644;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class LowestCommonAncestor {
    private static TreeNode answer = null;

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        answer = null;
        helper1(root, p, q);
        return answer;
    }

    public static int helper1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return 0;
        }
        int left, mid, right;
        if (root.val == p.val || root.val == q.val) {
            mid = 1;
        } else {
            mid = 0;
        }
        left = helper1(root.left, p, q);
        right = helper1(root.right, p, q);
        if (mid + left + right >= 2) {
            answer = root;
        }
        if (mid + left + right >= 1) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        TreeNode p = root.left;
        TreeNode q = root.left.right.right;

        System.out.println(lowestCommonAncestor(root, p, q) == root.left);

        q = new TreeNode(10);
        answer = null;
        System.out.println(lowestCommonAncestor(root, p, q) == null);
    }
}
