class FirstUnique:
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
    obj = FirstUnique([2, 3, 4, 5])
    print(obj.showFirstUnique())
