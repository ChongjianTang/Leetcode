package leetcode.p0.p86;


import java.util.List;

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

public class Partition {
    /**
     * Two pointer
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public ListNode partition(ListNode head, int x) {
        ListNode before = new ListNode();
        ListNode beforePtr = before;
        ListNode after = new ListNode();
        ListNode afterPtr = after;

        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                beforePtr.next = cur;
                beforePtr = beforePtr.next;
            } else {
                afterPtr.next = cur;
                afterPtr = afterPtr.next;
            }
            cur = cur.next;
        }
        afterPtr.next = null;
        beforePtr.next = after.next;
        return before.next;
    }
}
