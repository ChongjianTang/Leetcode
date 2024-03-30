package leetcode.p30.p3063;

import java.util.HashMap;
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

public class FrequenciesOfElements {
    /**
     * Mar 10, 2024 10:32
     * Hash Table
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public ListNode frequenciesOfElements(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();
        ListNode pointer = head;
        ListNode result = new ListNode();
        while (pointer != null) {
            if (!map.containsKey(pointer.val)) {
                map.put(pointer.val, 1);
            } else {
                map.put(pointer.val, map.get(pointer.val) + 1);
            }
            pointer = pointer.next;
        }
        pointer = result;
        for (int element : map.keySet()) {
            pointer.next = new ListNode(map.get(element));
            pointer = pointer.next;
        }
        return result.next;
    }
}
