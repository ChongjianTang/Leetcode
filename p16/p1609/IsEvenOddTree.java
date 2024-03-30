package leetcode.p16.p1609;

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

public class IsEvenOddTree {
    /**
     * Feb 28, 2024 19:13
     * level BFS
     * Time Complexity: O(node.size)
     * Space Complexity: O(tree.height)
     */
    public boolean isEvenOddTree(TreeNode root) {
        if (root.val % 2 == 0) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            Queue<TreeNode> nextLevel = new LinkedList<>();
            int val = -1;
            level++;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (level % 2 == 0) {
                    if (node.left != null) {
                        if (val != -1 && val >= node.left.val) {
                            return false;
                        }
                        val = node.left.val;
                        if (val % 2 != 1) {
                            return false;
                        }
                        nextLevel.offer(node.left);
                    }
                    if (node.right != null) {
                        if (val != -1 && val >= node.right.val) {
                            return false;
                        }
                        val = node.right.val;
                        if (val % 2 != 1) {
                            return false;
                        }
                        nextLevel.offer(node.right);
                    }
                } else {
                    if (node.left != null) {
                        if (val != -1 && val <= node.left.val) {
                            return false;
                        }
                        val = node.left.val;
                        if (val % 2 != 0) {
                            return false;
                        }
                        nextLevel.offer(node.left);
                    }
                    if (node.right != null) {
                        if (val != -1 && val <= node.right.val) {
                            return false;
                        }
                        val = node.right.val;
                        if (val % 2 != 0) {
                            return false;
                        }
                        nextLevel.offer(node.right);
                    }

                }
            }
            queue = nextLevel;
        }
        return true;
    }
}
