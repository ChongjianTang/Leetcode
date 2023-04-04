package leetcode.p0.p21;


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
    public static ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        if (list1 != null) {
            curr.next = list1;
        } else {
            curr.next = list2;
        }
        return dummy.next;
        // Too clumsy. The dummy node will save a lot of work
//        ListNode ptr1, ptr2;
//        ListNode temp;
//        if (l1.val < l2.val) {
//            temp = l1;
//            ptr1 = l1.next;
//            ptr2 = l2;
//        } else {
//            temp = l2;
//            ptr1 = l1;
//            ptr2 = l2.next;
//        }
//        ListNode head = temp;
//        while (ptr1 != null && ptr2 != null) {
//            if (ptr1.val < ptr2.val) {
//                temp.next = ptr1;
//                ptr1 = ptr1.next;
//            } else {
//                temp.next = ptr2;
//                ptr2 = ptr2.next;
//            }
//            temp = temp.next;
//        }
//        if (ptr1 != null) {
//            temp.next = ptr1;
//        }
//        if (ptr2 != null) {
//            temp.next = ptr2;
//        }
//        return head;
    }

    /**
     * Recursion
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list2.next, list1);
            return list2;
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
