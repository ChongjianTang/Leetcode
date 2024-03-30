package leetcode.p1.p141;

import java.util.HashSet;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }
}

public class HasCycle {
    /**
     * My method, reverse all arrow
     * Modified the original linked list
     * One pass
     * Time complexity: O(n) (Worst: 2n-1)
     * Space complexity: O(1)
     */
    public static boolean hasCycle1(ListNode head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return false;
        }
//        This part is unnecessary
//        if (head.next == head) {
//            return true;
//        }
        ListNode ptr = head.next;
        ListNode prev = head;
        ListNode next;
        prev.next = null;

        while (ptr != null) {
            next = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = next;
        }
        return prev == head;
    }

    /**
     * Hash set
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public static boolean hasCycle2(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
                head = head.next;
            }
        }
        return false;
    }

    /**
     * Floyd's Cycle Finding Algorithm
     * Use two pointer, a fast pointer and a slow pointer
     * If the linked list has a cycle, the two pointer will meet each other in the end
     * <p>
     * Time complexity: O(n) (Worst: O(n+k))
     * Space complexity: O(1)
     */
    public static boolean hasCycle3(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * Mar 05, 2024 17:15
     * Floyd's Cycle Finding Algorithm
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static boolean hasCycle(ListNode head) {
        if (head ==null){
            return false;
        }
        ListNode slow, fast;
        if (head.next != null) {
            slow = head.next;
        } else {
            return false;
        }
        if (slow.next != null) {
            fast = slow.next;
        } else {
            return false;
        }
        while (slow != fast) {
            slow = slow.next;
            if (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
            } else {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        ListNode head;
        boolean output;

        head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        output = true;
        System.out.println(hasCycle(head) == output);
    }
}
