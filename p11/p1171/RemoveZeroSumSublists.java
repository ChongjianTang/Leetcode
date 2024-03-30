package leetcode.p11.p1171;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

public class RemoveZeroSumSublists {
    /**
     * Mar 12, 2024 01:19
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public ListNode removeZeroSumSublists1(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode temp = dummy;
        int sum = 0;
        map.put(sum, dummy);
        while (temp.next != null) {
            if (temp.next.val == 0) {
                temp.next = temp.next.next;
            } else {
                sum += temp.next.val;
                if (!map.containsKey(sum)) {
                    map.put(sum, temp.next);
                    temp = temp.next;
                } else {
                    ListNode prev = map.get(sum);
                    ListNode start = prev.next;
                    int tempSum = sum;
                    temp = temp.next;
                    while (start != temp) {
                        tempSum += start.val;
                        map.remove(tempSum);
                        start = start.next;
                    }
                    prev.next = temp.next;
                    temp = prev;
                }
            }
        }
        return dummy.next;
    }

    public ListNode removeZeroSumSublists(ListNode head) {
        return null;
        // TODO: FIX THIS LATER
    }


    public static void main(String[] args) {
        RemoveZeroSumSublists r = new RemoveZeroSumSublists();
        ListNode head = new ListNode(1);

        head.next = new ListNode(2);
        head.next.next = new ListNode(-3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(1);

        ListNode expected = new ListNode(3);
        expected.next = new ListNode(1);

        ListNode output = r.removeZeroSumSublists(head);
        boolean flag = true;
        while (expected != null && output != null) {
            if (expected.val != output.val) {
                flag = false;
                break;
            }
            expected = expected.next;
            output = output.next;
        }
        if (expected != null || output != null) {
            flag = false;
        }
        System.out.println(flag);

        head = new ListNode(-1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(1);

        expected = new ListNode(1);

        output = r.removeZeroSumSublists(head);
        flag = true;
        while (expected != null && output != null) {
            if (expected.val != output.val) {
                flag = false;
                break;
            }
            expected = expected.next;
            output = output.next;
        }
        if (expected != null || output != null) {
            flag = false;
        }
        System.out.println(flag);
    }
}
