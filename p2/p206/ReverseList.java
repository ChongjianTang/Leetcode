package leetcode.p2.p206;

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

public class ReverseList {
    /**
     * Iterative
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode ptr = head;
        ListNode prev = null;
        ListNode temp;
        while (ptr != null) {
            temp = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = temp;
        }
        return prev;
    }

    /**
     * Recursive
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode result = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }
}
