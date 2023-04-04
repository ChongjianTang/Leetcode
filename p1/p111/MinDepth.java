package leetcode.p1.p111;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

public class MinDepth {
    /**
     * Recursion
     * DFS
     */
    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftDepth = minDepth1(root.left);
            int rightDepth = minDepth1(root.right);
            if (leftDepth == 0) {
                return rightDepth + 1;
            } else if (rightDepth == 0) {
                return leftDepth + 1;
            } else {
                return Math.min(rightDepth, leftDepth) + 1;
            }
        }
    }

    /**
     * BFS with two queues
     * BFS is barely always better or equal than DFS
     * DFS will always traverse the whole tree
     * Because the DFS in this problem is not to find certain nodes.
     * It is to calculate all the height and then compare all leaves and then calculate the min height.
     * In LeetCode, Recursion(DFS) is 9ms and the BFS is 1ms
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int height = 0;
        while (!queue.isEmpty()) {
            Queue<TreeNode> nextQueue = new LinkedList<>();
            height++;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return height;
                }
                if (node.left != null) {
                    nextQueue.offer(node.left);
                }
                if (node.right != null) {
                    nextQueue.offer(node.right);
                }
            }
            queue = nextQueue;
        }
        return height;
    }
}
