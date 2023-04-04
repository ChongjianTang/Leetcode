package leetcode.p1.p142;


import java.util.HashSet;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }
}

public class DetectCycle {
    /**
     * HashSet
     */
    public ListNode detectCycle1(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            } else {
                set.add(head);
                head = head.next;
            }
        }
        return null;
    }

    /**
     * Updated from method 3 Floyd's Cycle Finding Algorithm in p141
     * Basically it is a math problem.
     * l is the distance before the node A that tail's next pointer is connected to.
     * Suppose that the fast and slow will meet at Node B in the end.
     * The distance from A to B is l1 and the distance from B to A is l2
     * 2*ds = df (the fast pointer moves twice as far as the slow pointer)
     * 2*(l+l1) = l+l1+k(l1+l2) while k is an ar rary integer.
     * So l+l1 = k(l1+l2)
     * l = (k-1)(l1+l2) + l2
     * This is important because we can know that
     * if we start two pointers from the head and B with a speed at 1-move/step,
     * they will eventually meet at A.
     *
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}
