package leetcode.p1.p133;

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {
    /**
     * 08/05/2022 19:54
     * My approach
     * BFS
     */
    public Node cloneGraph1(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        Queue<Node> originalQueue = new LinkedList<>();
        Node root = new Node(node.val);
        map.put(node, root);
        queue.add(root);
        originalQueue.add(node);
        while (!originalQueue.isEmpty() && !queue.isEmpty()) {
            Node ptr1 = queue.poll();
            Node ptr2 = originalQueue.poll();
            for (Node n : ptr2.neighbors) {
                if (!map.containsKey(n)) {
                    Node temp = new Node(n.val);
                    ptr1.neighbors.add(temp);
                    queue.offer(temp);
                    originalQueue.offer(n);
                    map.put(n, temp);
                } else {
                    Node temp = map.get(n);
                    ptr1.neighbors.add(temp);
                }
            }
        }
        return root;
    }

    /**
     * DFS
     */
    public Node cloneGraph(Node node) {
        return null; // TODO
    }
}
