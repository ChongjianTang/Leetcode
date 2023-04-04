package leetcode.p0.p24;

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

public class SwapPairs {
    /**
     * Recursive
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public static ListNode swapPairs1(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode temp = head.next;
        head.next = swapPairs1(temp.next);
        temp.next = head;
        return temp;
    }

    /**
     * Iterative
     */
    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode curr = dummy;
        ListNode temp;
        while (curr.next != null && curr.next.next != null) {
            temp = curr.next;
            curr.next = curr.next.next;
            temp.next = curr.next.next;
            curr.next.next = temp;
            curr= curr.next.next;
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        head = swapPairs(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
