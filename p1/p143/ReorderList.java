package leetcode.p1.p143;

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

public class ReorderList {
    /**
     * My approach 1
     * Recursion
     * Around 471ms -- too slow
     * Time complexity: O(n^2)
     * Space complexity: O(n)
     */
    public void reorderList1(ListNode head) {
        if (head.next == null || head.next.next == null) {
            return;
        }
        ListNode cur = head;
        while (cur.next.next != null) {
            cur = cur.next;
        }
        ListNode end = cur.next;
        cur.next = null;
        reorderList(head.next);
        end.next = head.next;
        head.next = end;
    }

    /**
     * Middle of the Linked List + Reverse Linked List + Merge Two Sorted Lists
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public static void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode prev = slow;
        ListNode cur = slow.next;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        cur = prev;

        ListNode ptr = head;

        while (ptr != cur && ptr.next != cur) {
            ListNode temp = ptr;
            ptr = ptr.next;
            temp.next = cur;
            cur = cur.next;
            temp.next.next = ptr;
        }
        cur.next = null;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        reorderList(root);
    }
}
