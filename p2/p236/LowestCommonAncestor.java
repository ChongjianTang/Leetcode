package leetcode.p2.p236;


import java.util.ArrayList;
import java.util.List;

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

public class LowestCommonAncestor {
    /**
     * This solution comes from p235.
     * The helper function is inefficient.
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
     * Get all their ancestors and then compare them one by one.
     * Still super slow.
     */
    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        List<TreeNode> ancestorOfP = getAncestors(root, p);
        List<TreeNode> ancestorOfQ = getAncestors(root, q);
        int i = ancestorOfP.size() - 1;
        int j = ancestorOfQ.size() - 1;
        while (i >= 0 && j >= 0 && ancestorOfP.get(i) == ancestorOfQ.get(j)) {
            i--;
            j--;
        }
        return ancestorOfP.get(i + 1);
    }

    public static List<TreeNode> getAncestors(TreeNode root, TreeNode node) {
        List<TreeNode> ancestors = new ArrayList<>();
        if (root == null) {
            return ancestors;
        }
        if (root.val == node.val) {
            ancestors.add(root);
            return ancestors;
        }
        ancestors.addAll(getAncestors(root.left, node));
        ancestors.addAll(getAncestors(root.right, node));
        if (!ancestors.isEmpty()) {
            ancestors.add(root);
        }
        return ancestors;
    }


    /**
     * Solution
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        answer = null;
        helper3(root, p, q);
        return answer;
    }

    public static int helper3(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return 0;
        }
        int left, mid, right;
        /*
        In problem 1676, there is an important fixation here.

        If I directly return here, the time will be hugely optimized.
        Because if a node is in nodes, it means the LCA should be at least above this node. So there is no need to
        dig into deeper layers of the tree.
         */
        if (root.val == p.val || root.val == q.val) {
            mid = 1;
        } else {
            mid = 0;
        }
        left = helper3(root.left, p, q);
        right = helper3(root.right, p, q);
        if (mid + left + right >= 2) {
            answer = root;
        }
        if (mid + left + right >= 1) {
            return 1;
        } else {
            return 0;
        }
    }

    private static TreeNode answer;


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

        System.out.println(root.left == lowestCommonAncestor(root, root.left, root.left.right.right));

        root = new TreeNode(-1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(-2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(8);

        System.out.println(lowestCommonAncestor(root, root.left, root.left.left.left) == root.left);
    }
}
