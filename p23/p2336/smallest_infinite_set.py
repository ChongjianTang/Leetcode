import heapq


class SmallestInfiniteSet:
    """
    heap
    Jan 04, 2025 18:10
    """

    def __init__(self):
        self.heap = [1]
        self.removed = set()

    def popSmallest(self) -> int:
        smallest = heapq.heappop(self.heap)
        if not self.heap:
            self.heap = [smallest + 1]
        self.removed.add(smallest)
        return smallest

    def addBack(self, num: int) -> None:
        if num in self.removed:
            heapq.heappush(self.heap, num)
            self.removed.remove(num)

# Your SmallestInfiniteSet object will be instantiated and called as such:
# obj = SmallestInfiniteSet()
# param_1 = obj.popSmallest()
# obj.addBack(num)
