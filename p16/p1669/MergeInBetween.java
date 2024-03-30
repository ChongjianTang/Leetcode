package leetcode.p16.p1669;

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

public class MergeInBetween {
    /**
     * Mar 20, 2024 10:15
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy = new ListNode();
        dummy.next = list1;
        ListNode fast = dummy;
        ListNode slow = dummy;
        b++;
        while (a > 0 || b > 0) {
            if (b > 0) {
                fast = fast.next;
                b--;
            }
            if (a > 0) {
                slow = slow.next;
                a--;
            }
        }
        slow.next = list2;
        while (slow.next != null) {
            slow = slow.next;
        }
        slow.next = fast.next;
        return dummy.next;
    }
}
