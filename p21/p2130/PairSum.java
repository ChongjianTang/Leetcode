package leetcode.p21.p2130;

import java.util.ArrayList;
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

public class PairSum {
    /**
     * Mar 06, 2024 22:07
     * Slow Fast Pointer
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        List<Integer> pairSums = new ArrayList<>();
        while (fast != null && fast.next != null) {
            pairSums.add(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        int i = pairSums.size() - 1;
        int max = Integer.MIN_VALUE;
        while (slow != null) {
            max = Math.max(max, pairSums.get(i) + slow.val);
            i--;
            slow = slow.next;
        }
        return max;
    }
}
