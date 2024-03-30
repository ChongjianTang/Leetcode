package leetcode.p30.p3062;

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

public class GameResult {
    /**
     * Feb 29, 2024 23:10
     * Too easy
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public String gameResult(ListNode head) {
        ListNode even = head;
        ListNode odd = head.next;
        int evenPoints = 0;
        int oddPoints = 0;
        if (even.val > odd.val) {
            evenPoints++;
        } else {
            oddPoints++;
        }
        while (odd.next != null) {
            even = odd.next;
            odd = even.next;
            if (even.val > odd.val) {
                evenPoints++;
            } else {
                oddPoints++;
            }
        }
        if (evenPoints > oddPoints) {
            return "Even";
        } else if (oddPoints > evenPoints) {
            return "Odd";
        } else {
            return "Tie";
        }
    }
}
