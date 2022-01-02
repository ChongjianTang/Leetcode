package leetcode.p19;

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

public class RemoveNthFromEnd {
    /**
     * Iteration
     */
    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode ptr = head;
        ListNode nthPrev = head;
        int count = 0;
        while (ptr != null) {
            ptr = ptr.next;
            count++;
            if (count > n + 1) {
                nthPrev = nthPrev.next;
            }
        }
        if (count > n + 1) {
            nthPrev.next = nthPrev.next.next;
        } else if (count == n) {
            head = head.next;
        } else if (count == n + 1) {
            head.next = head.next.next;
        }
        return head;
    }

//    public static ListNode removeNthFromEnd(ListNode head, int n) {
//        if (head == null && n > 0) {
//            return null;
//        } else {
//            ListNode temp = head;
//            head = removeNthFromEnd(head, n - 1);
//            return head;
//        }
//    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        head = removeNthFromEnd1(head, 1);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
