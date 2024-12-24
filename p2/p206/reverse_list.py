# Definition for singly-linked list.
from audioop import reverse
from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    """
    Dec 24, 2024 13:56
    """
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return head

        temp = self.reverseList(head.next)

        head.next.next = head
        head.next = None
        return temp
