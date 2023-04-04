package leetcode.p2.p235;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }
}

public class LowestCommonAncestor {
    /**
     * Brute Force
     * helper1 function is unnecessarily called too many times.
     * So this solution is still need to be optimized.
     */
    public static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val == p.val) {
            return p;
        } else if (root.val == q.val) {
            return q;
        }
        boolean pInRight = helper1(root.right, p);
        boolean qInRight = helper1(root.right, q);
        if (pInRight && !qInRight) {
            return root;
        } else if (!pInRight && qInRight) {
            return root;
        } else {
            if (pInRight) {
                return lowestCommonAncestor1(root.right, p, q);
            } else {
                return lowestCommonAncestor1(root.left, p, q);
            }
        }
    }

    public static boolean helper1(TreeNode root, TreeNode treeNode) {
        if (root == null) {
            return false;
        }
        if (root.val == treeNode.val) {
            return true;
        } else {
            return helper1(root.right, treeNode) || helper1(root.left, treeNode);
        }
    }


    /**
     * We can utilize the binary search tree's property.
     * Recursion
     */
    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            return lowestCommonAncestor2(root, q, p);
        }
        if (p.val <= root.val && root.val <= q.val) {
            return root;
        } else if (p.val > root.val) {
            return lowestCommonAncestor2(root.right, p, q);
        } else {
            return lowestCommonAncestor2(root.left, p, q);
        }
    }

    /**
     * Iteration
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ptr;
        if (p.val > q.val) {
            ptr = p;
            p = q;
            q = ptr;
        }
        ptr = root;
        while (ptr != null) {
            if (ptr.val <= q.val && ptr.val >= p.val) {
                return ptr;
            } else if (ptr.val > q.val) {
                ptr = ptr.left;
            } else {
                ptr = ptr.right;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        TreeNode p, q;
        p = root.left;
        q = root.right;


        System.out.println(lowestCommonAncestor(root, p, q).val == 6);
    }
}
