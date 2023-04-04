package leetcode.p16.p1650;

import com.sun.source.tree.Tree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
}

public class LowestCommonAncestor {

    public static Node lowestCommonAncestor(Node p, Node q) {
        List<Node> ancestorOfP = new ArrayList<>();
        List<Node> ancestorOfQ = new ArrayList<>();
        Node ptr = p;
        while (ptr != null) {
            ancestorOfP.add(ptr);
            ptr = ptr.parent;
        }
        ptr = q;
        while (ptr != null) {
            ancestorOfQ.add(ptr);
            ptr = ptr.parent;
        }
        int i = ancestorOfP.size() - 1;
        int j = ancestorOfQ.size() - 1;
        while (i >= 0 && j >= 0 && ancestorOfP.get(i) == ancestorOfQ.get(j)) {
            i--;
            j--;
        }
        return ancestorOfP.get(i + 1);
    }



    public static void main(String[] args) {
        Node root = new Node();
        root.val = 3;
        root.left = new Node();
        root.left.val = 5;
        root.left.parent = root;
        root.left.left = new Node();
        root.left.left.val = 6;
        root.left.left.parent = root.left;
        root.left.right = new Node();
        root.left.right.val = 2;
        root.left.right.parent = root.left;

        root.left.right.left = new Node();
        root.left.right.left.val = 7;
        root.left.right.left.parent = root.left.right;
        root.left.right.right = new Node();
        root.left.right.right.val = 4;
        root.left.right.right.parent = root.left.right;

        root.right = new Node();
        root.right.val = 1;
        root.right.parent = root;

        root.right.left = new Node();
        root.right.left.val = 0;
        root.right.left.parent = root.right;
        root.right.right = new Node();
        root.right.right.val = 8;
        root.right.right.parent = root.right;

        Node p = root.left;
        Node q = root.left.right.right;

        System.out.println(lowestCommonAncestor(p, q) == root.left);
    }
}
