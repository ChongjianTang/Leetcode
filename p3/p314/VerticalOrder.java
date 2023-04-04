package leetcode.p3.p314;

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

public class VerticalOrder {
    public static List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<Integer> positionQueue = new ArrayDeque<>();
        Queue<TreeNode> nodeQueue = new ArrayDeque<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();


        nodeQueue.add(root);
        positionQueue.add(0);
        while (!nodeQueue.isEmpty()) {
            TreeNode temp = nodeQueue.poll();
            int position = positionQueue.poll();
            if (map.get(position) == null) {
                map.put(position, new ArrayList<>());
            }
            map.get(position).add(temp.val);
            if (temp.left != null) {
                nodeQueue.add(temp.left);
                positionQueue.add(position - 1);
            }
            if (temp.right != null) {
                nodeQueue.add(temp.right);
                positionQueue.add(position + 1);
            }
        }

        int max = Collections.max(map.keySet());
        int min = Collections.min(map.keySet());
        List<List<Integer>> result = new ArrayList<>();
        for (int i = min; i < max + 1; i++) {
            result.add(map.get(i));
        }
        return result;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(0);
        root.left.right.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(1);
        root.right.left.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = verticalOrder(root);
        for (List<Integer> temp : result) {
            for (int num : temp) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }
}
