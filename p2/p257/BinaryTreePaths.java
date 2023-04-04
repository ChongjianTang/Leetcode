package leetcode.p2.p257;

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

public class BinaryTreePaths {
    /**
     * 08/27/2022 10:28
     * DFS
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        dfs1(root, "", result);
        return result;
    }

    public void dfs1(TreeNode root, String path, List<String> result) {
        if (root.left == null && root.right == null) {
            if (!path.equals("")) {
                result.add(path + "->" + root.val);
            } else {
                result.add("" + root.val);
            }
            return;
        }
        if (root.left != null) {
            if (!path.equals("")) {
                dfs1(root.left, path + "->" + root.val, result);
            } else {
                dfs1(root.left, "" + root.val, result);
            }
        }
        if (root.right != null) {
            if (!path.equals("")) {
                dfs1(root.right, path + "->" + root.val, result);
            } else {
                dfs1(root.right, "" + root.val, result);
            }
        }
    }
}
