package leetcode.p0.p61;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class RotateRight {
    /**
     * My approach
     */
    public ListNode rotateRight1(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;

        int length = 0;
        while (fast != null) {
            fast = fast.next;
            length++;
        }
        k = k % length;
        if (k == 0) {
            return head;
        }
        fast = head;
        int i = 0;
        while (fast.next != null) {
            fast = fast.next;
            if (i >= k) {
                slow = slow.next;
            } else {
                i++;
            }
        }

        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;
    }
}
