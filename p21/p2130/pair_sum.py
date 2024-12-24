# Definition for singly-linked list.
from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    """
    Dec 24, 2024 14:41
    Time Complexity: O(n)
    Space Complexity: O(n)
    """

    def pairSum(self, head: Optional[ListNode]) -> int:
        pair_sum = []
        slow = fast = head
        pair_sum.append(slow.val)
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
            pair_sum.append(slow.val)

        i = len(pair_sum) - 1
        max_val = 0
        while slow.next:
            slow = slow.next
            pair_sum[i] += slow.val
            max_val = max(max_val, pair_sum[i])
            i -= 1

        return max_val


if __name__ == '__main__':
    sol = Solution()

    head = ListNode(5, ListNode(4, ListNode(3, ListNode(2))))

    sol.pairSum(head)
