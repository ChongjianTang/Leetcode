package leetcode.p0.p23;

import java.util.Comparator;
import java.util.PriorityQueue;

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

public class MergeKLists {
    /**
     * Use priorityQueue
     * Time complexity: O(nlogk) where k is the number of linked lists.
     * Space complexity: O(k)
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        for (ListNode node : lists) {
            if (node != null) {
                priorityQueue.add(node);
            }
        }
        while (!priorityQueue.isEmpty()) {
            temp.next = priorityQueue.poll();
            temp = temp.next;
            if (temp.next != null) {
                priorityQueue.add(temp.next);
            }
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1, new ListNode(4, new ListNode(5)));
        lists[1] = new ListNode(1, new ListNode(3, new ListNode(4)));
        lists[2] = new ListNode(2, new ListNode(6, new ListNode(9)));
        ListNode result = mergeKLists(lists);
        ListNode temp = result;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
