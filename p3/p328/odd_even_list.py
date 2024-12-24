# Definition for singly-linked list.
from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    """
    Dec 24, 2024 13:29
    """
    def oddEvenList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return head

        odd_list = head
        even_list = head.next
        odd = head
        even = head.next
        while even.next and even.next.next:
            odd.next = even.next
            odd = odd.next
            even.next = even.next.next
            even = even.next

        if even.next:
            odd.next = even.next
            odd = odd.next
            even.next = None

        odd.next = even_list

        return odd_list


if __name__ == '__main__':
    head = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))

    sol = Solution()

    print(sol.oddEvenList(head))
