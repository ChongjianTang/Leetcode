package leetcode.p2.p234;

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

public class IsPalindrome {
    /**
     * My method
     * Reverse Second Half In-place
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public boolean isPalindrome1(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode prev = slow;
        slow = slow.next;
        while (slow != null) {
            ListNode temp = slow;
            slow = slow.next;
            temp.next = prev;
            prev = temp;
        }
        fast = head;
        slow = prev;
        while (fast.val == slow.val && fast.next != slow && fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return (fast.next == slow || fast == slow) && fast.val == slow.val;
    }

    /**
     * Recursive
     */
    public static boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }

    private static boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) return false;
            if (currentNode.val != frontPointer.val) return false;
            frontPointer = frontPointer.next;
        }
        return true;
    }

    private static ListNode frontPointer;


    public static void main(String[] args) {
        ListNode head;

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(head));
    }
}
