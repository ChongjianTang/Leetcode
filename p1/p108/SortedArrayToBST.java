package leetcode.p1.p108;

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

public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helperForSortedArrayToBST(nums, 0, nums.length);
    }

    public TreeNode helperForSortedArrayToBST(int[] nums, int left, int right) {
        if (right == left) {
            return null;
        }
        if (right - left == 1) {
            return new TreeNode(nums[left]);
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helperForSortedArrayToBST(nums, left, mid);
        root.right = helperForSortedArrayToBST(nums, mid + 1, right);
        return root;
    }
}
