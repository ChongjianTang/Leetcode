from collections import deque
from typing import List


class FirstUnique:
    """
    May 27, 2025 15:00
    Time Complexity:
        self.showFirstUnique: O(1)
        self.add: O(1)
    Space Complexity: O(n)
    """

    def __init__(self, nums: List[int]):
        self.frequencies = {}
        self.unique = deque()
        for num in nums:
            self.add(num)

    def showFirstUnique(self) -> int:
        while self.unique and self.frequencies[self.unique[0]] > 1:
            self.unique.popleft()
        if self.unique:
            return self.unique[0]
        else:
            return -1

    def add(self, value: int) -> None:
        if value not in self.frequencies:
            self.unique.append(value)
            self.frequencies[value] = 1
        else:
            self.frequencies[value] += 1


class FirstUnique1:
    """
    Oct 19, 2024 23:38
    Time Complexity: O(1)
    Space Complexity: O(n)
    """

    def __init__(self, nums: List[int]):
        self.unique = {}
        self.non_unique = set()
        for num in nums:
            self.add(num)

    def showFirstUnique(self) -> int:
        if not self.unique:
            return -1
        return next(iter(self.unique))

    def add(self, value: int) -> None:
        if value not in self.non_unique:
            if value not in self.unique:
                self.unique[value] = None
            else:
                self.unique.pop(value)
                self.non_unique.add(value)


# Your FirstUnique object will be instantiated and called as such:
# obj = FirstUnique(nums)
# param_1 = obj.showFirstUnique()
# obj.add(value)


if __name__ == '__main__':
    obj = FirstUnique([2, 3, 5])
    print(obj.showFirstUnique())
    obj.add(2)
    print(obj.showFirstUnique())
