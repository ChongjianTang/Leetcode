package leetcode.p1.p106;

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

public class BuildTree {
    /**
     * Jan 12, 2023 17:10
     */
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper1(postorder, 0, postorder.length, inorder, 0, inorder.length);
    }

    public static TreeNode helper1(int[] postorder, int start1, int end1, int[] inorder, int start2, int end2) {
        if (end1 - start1 == 1) {
            return new TreeNode(postorder[start1]);
        } else {
            for (int i = start2; i < end2; i++) {
                // right's length: i - start2 and left's length is end2 - 1 - i
                if (inorder[i] == postorder[end1 - 1]) {
                    TreeNode treeNode = new TreeNode(postorder[end1 - 1]);
                    treeNode.left = helper1(postorder, start1, start1 + i - start2, inorder, start2, i);
                    treeNode.right = helper1(postorder, start1 + i - start2, end1 - 1, inorder, i + 1, end2);
                    return treeNode;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] inorder, postorder;
        inorder = new int[]{9, 3, 15, 20, 7};
        postorder = new int[]{9, 15, 7, 20, 3};
        TreeNode root = buildTree(inorder, postorder);
    }
}
