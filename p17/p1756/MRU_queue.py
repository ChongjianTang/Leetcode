class Node:
    def __init__(self, val: int):
        self.val = val
        self.prev = None
        self.next = None


class MRUQueue:
    """
    Feb 14, 2025 23:47
    Double Linked List
    init - Time Complexity: O(n)
    fetch - Time Complexity: O(n)
    Space Complexity: O(n)
    """

    def __init__(self, n: int):
        self.head = Node(0)
        self.tail = Node(0)

        curr = self.head
        for i in range(n):
            curr.next = Node(i + 1)
            curr.next.prev = curr
            curr = curr.next

        curr.next = self.tail
        self.tail.prev = curr

    def fetch(self, k: int) -> int:
        curr = self.head
        for i in range(k):
            curr = curr.next

        curr.next.prev = curr.prev
        curr.prev.next = curr.next

        curr.prev = self.tail.prev
        curr.next = self.tail
        curr.prev.next = curr
        self.tail.prev = curr

        return curr.val

# Your MRUQueue object will be instantiated and called as such:
# obj = MRUQueue(n)
# param_1 = obj.fetch(k)
