package leetcode.p1.p103;

import java.util.*;

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

public class ZigzagLevelOrder {
    /**
     * Collections.reverse()
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        boolean isOdd = true;
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        List<Integer> answer = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                if (!isOdd) {
                    Collections.reverse(answer);
                }
                result.add(new ArrayList<>(answer));
                answer.clear();
                isOdd = !isOdd;
                if (queue.size() != 0) {
                    queue.offer(null);
                }
            } else {
                answer.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return result;
    }

    /**
     * Use two stacks to avoid Collections.reverse()
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        boolean isOdd = true;
        List<List<Integer>> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<Integer> answer = new ArrayList<>();
        while (!stack.isEmpty()) {
            Stack<TreeNode> nextStack = new Stack<>();
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                answer.add(node.val);
                if (isOdd) {
                    if (node.left != null) {
                        nextStack.push(node.left);
                    }
                    if (node.right != null) {
                        nextStack.push(node.right);
                    }
                } else {
                    if (node.right != null) {
                        nextStack.push(node.right);
                    }
                    if (node.left != null) {
                        nextStack.push(node.left);
                    }
                }
            }
            isOdd = !isOdd;
            result.add(new ArrayList<>(answer));
            answer.clear();
            stack = nextStack;
        }
        return result;
    }
}
