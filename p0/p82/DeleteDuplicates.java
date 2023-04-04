package leetcode.p0.p82;

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

public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode curr = head;
        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        prev.next = curr;
        while (curr.next != null) {
            if (curr.next.val == curr.val) {
                while (curr.next != null && curr.next.val == curr.val) {
                    curr = curr.next;
                }
                if (curr.next == null) {
                    prev.next = null;
                    return dummy.next;
                } else {
                    prev.next = curr.next;
                    curr = prev.next;
                }
            } else {
                prev = prev.next;
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
