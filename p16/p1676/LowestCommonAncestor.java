package leetcode.p16.p1676;


import java.util.Arrays;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class LowestCommonAncestor {
    private static TreeNode answer;

    /**
     * This solution is updated from problem 236.
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        answer = root;
        helper1(root, nodes);
        return answer;
    }

    public static int helper1(TreeNode root, TreeNode[] nodes) {
        if (root == null) {
            return 0;
        }
        int left, mid = 0, right;
        for (TreeNode node : nodes) {
            if (node.val == root.val) {
                /*
                If I directly return here, the time will be hugely optimized.
                Because if a node is in nodes, it means the LCA should be at least above this node. So there is no need to
                dig into deeper layers of the tree.
                 */
                answer = root;
                return 1;
//                mid = 1;
//                if (nodes.length == 1) {
//                    answer = root;
//                    return 1;
//                }
//                break;
            }
        }
        left = helper1(root.left, nodes);
        right = helper1(root.right, nodes);
        if (mid + left + right >= 2) {
            answer = root;
            return 0;
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

        TreeNode p = root.left.right.right;
        TreeNode q = root.left.right.left;
        TreeNode[] nodes = new TreeNode[2];
        nodes[0] = p;
        nodes[1] = q;

        System.out.println(lowestCommonAncestor(root, nodes) == root.left.right);

        nodes = new TreeNode[1];
        nodes[0] = root.right;
        System.out.println(lowestCommonAncestor(root, nodes) == root.right);

        nodes = new TreeNode[4];
        nodes[0] = root.left.right.left;
        nodes[1] = root.left.left;
        nodes[2] = root.left.right;
        nodes[3] = root.left.right.right;
        System.out.println(lowestCommonAncestor(root, nodes) == root.left);
    }
}
