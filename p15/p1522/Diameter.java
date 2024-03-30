package leetcode.p15.p1522;

import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;


    public Node() {
        children = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class Diameter {
    /**
     * Feb 27, 2024 22:59
     * The idea is from problem 543
     * Time Complexity: O(node.size)
     * Space Complexity: O(tree.height)
     */
    public int diameter(Node root) {
        if (root == null) {
            return 0;
        }

        int[] diameters = new int[root.children.size()];
        int maxChildrenDiameter = 0;
        int first = -1;
        int second = -1;
        for (int i = 0; i < diameters.length; i++) {
            diameters[i] = diameter(root.children.get(i));
            maxChildrenDiameter = Math.max(maxChildrenDiameter, diameters[i]);
            if (root.children.get(i).val > first) {
                second = first;
                first = root.children.get(i).val;
            } else if (root.children.get(i).val > second) {
                second = root.children.get(i).val;
            }
        }
        root.val = Math.max(first, second) + 1;
        return Math.max(first + second + 2, maxChildrenDiameter);
    }

    public static void main(String[] args) {
        Diameter d = new Diameter();
        Node root = new Node(1);
        root.children = new ArrayList<>();
        root.children.add(new Node(3));
        root.children.add(new Node(2));
        root.children.add(new Node(4));
        root.children.get(0).children = new ArrayList<>();
        root.children.get(0).children.add(new Node(5));
        root.children.get(0).children.add(new Node(6));

        System.out.println(d.diameter(root) == 3);
    }
}
