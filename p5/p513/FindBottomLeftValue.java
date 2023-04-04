package leetcode.p5.p513;

import java.util.LinkedList;
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

public class FindBottomLeftValue {
    /**
     * Two queues
     */
    public int findBottomLeftValue1(TreeNode root) {
        int firstValue = root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            boolean isFirst = true;
            Queue<TreeNode> nextQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (isFirst) {
                    firstValue = node.val;
                    isFirst = false;
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
        return firstValue;
    }

    /**
     * Two queues without sentinel
     */
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode node = root;
        while (!queue.isEmpty()) {
            Queue<TreeNode> nextQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                node = queue.poll();
                if (node.right != null) {
                    nextQueue.offer(node.right);
                }
                if (node.left != null) {
                    nextQueue.offer(node.left);
                }
            }
            queue = nextQueue;
        }
        return node.val;
    }
}
