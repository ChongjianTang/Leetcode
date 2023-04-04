package leetcode.p1.p138;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyRandomList {
    /**
     * My approach
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        if (head == null) {
            return null;
        }

        Node root = new Node(head.val);
        map.put(head, root);
        Node cur1 = root;
        Node cur2 = head;
        while (cur2.next != null) {
            cur1.next = new Node(cur2.next.val);
            cur1 = cur1.next;
            cur2 = cur2.next;
            map.put(cur2, cur1);
        }

        cur1 = root;
        cur2 = head;
        while (cur2 != null) {
            if (cur2.random != null) {
                cur1.random = map.get(cur2.random);
            } else {
                cur1.random = null;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return root;
    }

    //TODO there is a weaving method whose space complexity is O(1)
}
