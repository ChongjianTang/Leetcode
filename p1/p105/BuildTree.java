package leetcode.p1.p105;


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
     * My method
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper1(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    public TreeNode helper1(int[] preorder, int start1, int end1, int[] inorder, int start2, int end2) {
        if (end1 - start1 == 1) {
            return new TreeNode(preorder[start1]);
        } else {
            for (int i = start2; i < end2; i++) {
                if (inorder[i] == preorder[start1]) {
                    TreeNode treeNode = new TreeNode(preorder[start1]);
                    treeNode.left = helper1(preorder, start1 + 1, start1 + 1 + i - start2, inorder, start2, i);
                    treeNode.right = helper1(preorder, start1 + 1 + i - start2, end1, inorder, i + 1, end2);
                    return treeNode;
                }
            }
        }
        return null;
    }

    // TODO more to do
}
