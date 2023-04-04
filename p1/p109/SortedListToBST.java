package leetcode.p1.p109;

import com.sun.source.tree.Tree;

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


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class SortedListToBST {
    /**
     * Jan 12, 2023 17:25
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        if (head.next.next == null) {
            TreeNode root = new TreeNode(head.next.val);
            root.left = new TreeNode(head.val);
            return root;

        }
        ListNode fast = head;
        ListNode slow = new ListNode();
        slow.next = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode rightHead = slow.next;
        ListNode leftHead = head;
        slow.next = null;
        slow = rightHead;
        rightHead = rightHead.next;
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(leftHead);
        root.right = sortedListToBST(rightHead);
        return root;
    }
}
