package leetcode.p5.p590;


import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class Postorder {
    public List<Integer> postorder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        for (Node n : root.children) {
            result.addAll(postorder(n));
        }
        result.add(root.val);
        return result;
    }
}
