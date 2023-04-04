package leetcode.p2.p297;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Codec {

    Queue<TreeNode> queue = new LinkedList<>();

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        queue.clear();
        queue.offer(root);
        int count = 1;
        while (!queue.isEmpty() && count > 0) {
            TreeNode cur = queue.poll();
            if (!result.toString().equals("")) {
                result.append(",");
            }
            if (cur == null) {
                result.append("null");
            } else {
                result.append(cur.val);
                count--;
            }
            if (cur != null) {
                if (cur.left != null) {
                    count++;
                }
                queue.add(cur.left);
                if (cur.right != null) {
                    count++;
                }
                queue.add(cur.right);
            }
        }
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }
        String[] treeData = data.split(",");
        queue.clear();
        TreeNode root = new TreeNode(Integer.parseInt(treeData[0]));
        int index = 1;
        queue.offer(root);
        while (!queue.isEmpty() && index < treeData.length) {
            TreeNode cur = queue.poll();
            if (!treeData[index].equals("null")) {
                cur.left = new TreeNode(Integer.parseInt(treeData[index]));
                queue.offer(cur.left);
            }
            index++;
            if (index == treeData.length) {
                break;
            }
            if (!treeData[index].equals("null")) {
                cur.right = new TreeNode(Integer.parseInt(treeData[index]));
                queue.offer(cur.right);
            }
            index++;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        Codec c = new Codec();
        String s = c.serialize(root);
        TreeNode temp = c.deserialize(s);
        System.out.println("hi");


    }
    // TODO
}
