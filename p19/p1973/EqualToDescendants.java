package leetcode.p19.p1973;

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

public class EqualToDescendants {
    int count = 0;

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left + right == root.val) {
            count++;
        }
        return left + right + root.val;
    }

    /**
     * Feb 28, 2024 18:30
     * DFS
     * Time Complexity: O(node.size)
     * Space Complexity: O(tree.height)
     */
    public int equalToDescendants(TreeNode root) {
        count = 0;
        dfs(root);
        return count;
    }
}
