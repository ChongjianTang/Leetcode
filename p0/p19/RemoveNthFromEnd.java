package leetcode.p0.p19;

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
     * One pass algorithm
     */
    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        assert head != null;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode curr = head;
        ListNode nthPrev = dummy;
        int count = 0;
        while (curr.next != null) {
            curr = curr.next;
            count++;
            if (count >= n) {
                nthPrev = nthPrev.next;
            }
        }
        nthPrev.next = nthPrev.next.next;
        return dummy.next;
        // Too clumsy. Use dummy node please!
//        ListNode ptr = head;
//        ListNode nthPrev = head;
//        int count = 0;
//        while (ptr != null) {
//            ptr = ptr.next;
//            count++;
//            if (count > n + 1) {
//                nthPrev = nthPrev.next;
//            }
//        }
        // This part is really stupid
        // Clearly I do not understand the corner case good enough at that time
//        if (count > n + 1) {
//            nthPrev.next = nthPrev.next.next;
//        } else if (count == n) {
//            head = head.next;
//        } else if (count == n + 1) {
//            head.next = head.next.next;
//        }
        // Updated version
//        if (count >= n + 1) {
//            nthPrev.next = nthPrev.next.next;
//        } else {
//            head = head.next;
//        }

//        return head;
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

    /**
     * Two pass algorithm
     */
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        int length = 0;
        ListNode curr = head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        while (curr != null) {
            curr = curr.next;
            length++;
        }

        curr = dummy;
        for (int i = 0; i < length - n; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return dummy.next;
    }

    /**
     * Mar 02, 2024 23:44
     * One pass
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode right = head;
        ListNode left = dummy;
        while (n > 0) {
            right = right.next;
            n--;
        }
        while (right != null) {
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head;


        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head = removeNthFromEnd(head, 2);

        int[] result = new int[]{1, 2, 3, 5};
        for (int i = 0; i < 4; i++) {
            System.out.println(head.val == result[i]);
            head = head.next;
        }
        System.out.println(head == null);

        head = new ListNode(1);
        System.out.println(removeNthFromEnd(head, 1) == null);

        head = new ListNode(1);
        head.next = new ListNode(2);
        head = removeNthFromEnd(head, 1);
        System.out.println(head.val == 1);
        System.out.println(head.next == null);
    }
}
