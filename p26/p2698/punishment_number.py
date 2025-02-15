from turtledemo.sorting_animate import partition
from typing import List


class Solution:
    """
    Feb 14, 2025 23:15
    Time Complexity: O(n*4^logn)
    Space Complexity: O(logn*2^logn)
    """
    def punishmentNumber(self, n: int) -> int:
        result = 0
        for i in range(1,n + 1):
            if i in self.partition(str(i * i), i):
                result += i * i

        return result

    def partition(self, num: str, target: int) -> set:
        result = set()
        for i in range(1, len(num)):
            s1 = num[:i]
            s2 = num[i:]
            s1_val = self.partition(s1, target)
            s2_val = self.partition(s2, target)
            for val1 in s1_val:
                for val2 in s2_val:
                    if val1 + val2 <= target:
                        result.add(val1 + val2)
        if int(num) <= target:
            result.add(int(num))

        return result


if __name__ == '__main__':
    obj = Solution()
    print(obj.punishmentNumber(10))
