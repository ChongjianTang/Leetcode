package leetcode.p1.p110;

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

public class IsBalanced {
    public boolean isBalanced1(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(height1(root.right) - height1(root.left)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int height1(TreeNode root) {
        if (root == null) {
            return -1;
        } else {
            return Math.max(height1(root.left), height1(root.right)) + 1;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return height2(root) != -1;
    }

    public int height2(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = height2(root.left);
            int rightHeight = height2(root.right);
            if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
                return -1;
            } else {
                return Math.max(height2(root.left), height2(root.right)) + 1;
            }
        }
    }
}
