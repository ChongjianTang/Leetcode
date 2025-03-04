from typing import List


class Solution:
    """
    Mar 02, 2025 23:15
    Time Complexity: O(n)
    Space Complexity: O(n)
    """
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        stack = []
        result = [0] * len(temperatures)
        for i in range(len(temperatures)):
            while stack and temperatures[stack[-1]] < temperatures[i]:
                index = stack.pop()
                result[index] = i - index

            stack.append(i)

        return result
