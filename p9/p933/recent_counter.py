from collections import deque


class RecentCounter:
    """
    Dec 24, 2024 13:00
    Time Complexity: O(1)
    Space Complexity: O(1)
    """
    def __init__(self):
        self.queue = deque()

    def ping(self, t: int) -> int:
        self.queue.append(t)
        while self.queue[0] < t - 3000:
            self.queue.popleft()

        return len(self.queue)

# Your RecentCounter object will be instantiated and called as such:
# obj = RecentCounter()
# param_1 = obj.ping(t)
