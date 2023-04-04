package leetcode.p3.p328;

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

public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode temp = even;
        ListNode curr = head;
        while (curr.next != null && curr.next.next != null) {
            curr = curr.next.next;
            odd.next = curr;
            odd = odd.next;
            even.next = curr.next;
            even = even.next;
        }
        odd.next = temp;
        return head;
    }
}
