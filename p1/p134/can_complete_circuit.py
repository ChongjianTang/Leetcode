from sys import flags
from typing import List


class Solution:
    """
    Jun 12, 2025 21:25
    Time Complexity: O(n)
    Space Complexity: O(1)
    """

    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        total = 0
        curr = 0
        start = 0
        for i in range(len(gas)):
            total += gas[i] - cost[i]
            curr += gas[i] - cost[i]
            if curr < 0:
                curr = 0
                start = i + 1

        if total > 0:
            return start

        return -1


if __name__ == '__main__':
    sol = Solution()
    gas = [1, 2, 3, 4, 5]
    cost = [3, 4, 5, 1, 2]
    print(sol.canCompleteCircuit(gas, cost))
