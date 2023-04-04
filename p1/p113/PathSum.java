package leetcode.p1.p113;

import com.sun.source.tree.Tree;

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

public class PathSum {
    /**
     * Recursion
     * DFS
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        backtracking1(root, targetSum, new ArrayList<>(), result);
        return result;
    }

    public void backtracking1(TreeNode root, int targetSum, List<Integer> path, List<List<Integer>> result) {
        if (root.left == null && root.right == null) {
            if (targetSum == root.val) {
                path.add(root.val);
                result.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
        } else {
            path.add(root.val);
            if (root.left != null) {
                backtracking1(root.left, targetSum - root.val, path, result);
            }
            if (root.right != null) {
                backtracking1(root.right, targetSum - root.val, path, result);
            }
            path.remove(path.size() - 1);
        }
    }

}
