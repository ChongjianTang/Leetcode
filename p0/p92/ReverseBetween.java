package leetcode.p0.p92;

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

public class ReverseBetween {
    /**
     * Iterative
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode leftNode = head;
        ListNode leftNodePrev = dummy;

        for (int i = 0; i < left - 1; i++) {
            leftNodePrev = leftNode;
            leftNode = leftNode.next;
        }

        ListNode ptr = leftNode;
        ListNode prev = null;
        ListNode temp;

        int i = 0;
        while (i < right - left) {
            temp = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = temp;
            i++;
        }

        ListNode rightNext = ptr.next;
        ptr.next = prev;
        leftNodePrev.next = ptr;
        leftNode.next = rightNext;
        return dummy.next;
    }
}
