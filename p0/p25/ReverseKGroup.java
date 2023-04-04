package leetcode.p0.p25;

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

public class ReverseKGroup {
    /**
     * Recursion
     * Time complexity: O(n)
     * Space complexity: O(n/k)
     */
    public static ListNode reverseKGroup1(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        if (head == null) {
            return null;
        }
        ListNode ptr1 = head;
        int num = k - 2;
        while (ptr1.next != null && num > 0) {
            ptr1 = ptr1.next;
            num--;
        }
        if (ptr1.next == null) {
            return head;
        }
        num = k - 2;
        ListNode ptr2 = head.next;
        head.next = reverseKGroup(ptr1.next.next, k);
        ptr1 = ptr2;
        ptr2 = ptr1.next;
        while (num > 0) {
            ptr1.next = head;
            head = ptr1;
            ptr1 = ptr2;
            ptr2 = ptr1.next;
            num--;
        }
        ptr1.next = head;
        head = ptr1;
        return head;
    }

    /**
     * Iteration
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        if (head == null) {
            return null;
        }

        ListNode sentinel = head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy.next;
        ListNode prev = dummy;

        while (true) {
            int i = 0;
            while (sentinel != null && i < k - 1) {
                sentinel = sentinel.next;
                i++;
            }
            if (sentinel == null) {
                return dummy.next;
            }

            i = 0;
            ListNode start = cur;
            ListNode startPrev = prev;
            while (i < k - 1) {
                ListNode temp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = temp;
                i++;
            }
            startPrev.next = cur;
            start.next = cur.next;
            cur.next = prev;
            cur = start.next;
            sentinel = start.next;
            prev = start;
        }
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
//        head = reverseKGroup(head, 2);
//        while (head != null) {
//            System.out.println(head.val);
//            head = head.next;
//        }
//        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
//        head = reverseKGroup(head, 3);
//        while (head != null) {
//            System.out.println(head.val);
//            head = head.next;
//        }
        head = new ListNode(1, new ListNode(2));
        head = reverseKGroup(head, 2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
