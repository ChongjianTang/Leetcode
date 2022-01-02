package leetcode.p22;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    String val;
    int left, right;

    TreeNode() {
    }

    TreeNode(String val, int left, int right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    TreeNode getLeftChild() {
        if (left != 0) {
            return new TreeNode(val + "(", left - 1, right + 1);
        } else {
            return null;
        }
    }

    TreeNode getRightChild() {
        if (right != 0) {
            return new TreeNode(val + ')', left, right - 1);
        } else {
            return null;
        }
    }

    boolean isLeaf() {
        return left == 0 && right == 0;
    }
}

public class GenerateParenthesis {
    public static List<String> generateParenthesis1(int n) {
        List<String> result = new ArrayList<>();
        TreeNode root = new TreeNode("", n, 0);
        helper(root, result);
        return result;
    }

    public static void helper(TreeNode root, List<String> result) {
        if (root != null) {
            if (root.isLeaf()) {
                result.add(root.val);
            }
            helper(root.getLeftChild(), result);
            helper(root.getRightChild(), result);
        }
    }

//    public static List<String> generateParenthesis1(int n) {
//        ArrayList<List<String>> OPT = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//
//        }
//    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis1(3));
    }
}
