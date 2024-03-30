package leetcode.p5.p543;

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

public class DiameterOfBinaryTree {
    /**
     * Feb 27, 2024 00:44
     * My approach
     * Time Complexity: O(node.size)
     * Space Complexity: O(node.size)
     */
    public int diameterOfBinaryTree1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int resultLeft = diameterOfBinaryTree1(root.left);
        int resultRight = diameterOfBinaryTree1(root.right);
        int longestLeft, longestRight;
        int result = 0;
        if (root.left == null) {
            longestLeft = -1;
        } else {
            result += root.left.val + 1;
            longestLeft = root.left.val;
        }
        if (root.right == null) {
            longestRight = -1;
        } else {
            result += root.right.val + 1;
            longestRight = root.right.val;
        }
        result = Math.max(result, resultRight);
        result = Math.max(result, resultLeft);
        root.val = Math.max(longestRight, longestLeft) + 1;
        return result;
    }

    int diameter = 0;

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        diameter = Math.max(left + right, diameter);
        return Math.max(left, right) + 1;
    }

    /**
     * Feb 28, 2024 02:14
     * dfs
     * Time Complexity: O(node.size)
     * Space Complexity: O(tree.height)
     */
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        dfs(root);
        return diameter;
    }

    //TODO: Check the solution later. There are several problems related to this tree's longest path problem.
    public static void main(String[] args) {
        DiameterOfBinaryTree d = new DiameterOfBinaryTree();
        TreeNode root = new TreeNode();
        root.left = new TreeNode();

        System.out.println(d.diameterOfBinaryTree(root) == 1);

        root.left.left = new TreeNode();
        root.left.right = new TreeNode();
        root.right = new TreeNode();
        System.out.println(d.diameterOfBinaryTree(root) == 3);
    }
}
