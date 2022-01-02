package leetcode.p21;


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

public class MergeTwoLists {
    /**
     * Iteration
     */
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode ptr1, ptr2;
        ListNode temp;
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            temp = l1;
            ptr1 = l1.next;
            ptr2 = l2;
        } else {
            temp = l2;
            ptr1 = l1;
            ptr2 = l2.next;
        }
        ListNode head = temp;
        while (ptr1 != null && ptr2 != null) {
            if (ptr1.val < ptr2.val) {
                temp.next = ptr1;
                ptr1 = ptr1.next;
            } else {
                temp.next = ptr2;
                ptr2 = ptr2.next;
            }
            temp = temp.next;
        }
        if (ptr1 != null) {
            temp.next = ptr1;
        }
        if (ptr2 != null) {
            temp.next = ptr2;
        }
        return head;
    }

    /**
     * Recursion
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }


    public static void main(String[] args) {
        ListNode s1 = new ListNode(1);
        s1.next = new ListNode(2);
        s1.next.next = new ListNode(4);
        ListNode s2 = new ListNode(1);
        s2.next = new ListNode(3);
        s2.next.next = new ListNode(4);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        ListNode head = mergeTwoLists(s1, s2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
