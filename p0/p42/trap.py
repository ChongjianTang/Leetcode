from typing import List


class Solution:
    """
    Jun 16, 2025 16:47
    Time Complexity: O(n)
    Space Complexity: O(1)
    """

    def trap(self, height: List[int]) -> int:
        left = 0
        right = len(height) - 1
        water = 0
        while left < right:
            if height[left] <= height[right]:
                i = left + 1
                while i < right and height[i] <= height[left]:
                    water += height[left] - height[i]
                    i += 1
                left = i
            else:
                i = right - 1
                while i > left and height[i] <= height[right]:
                    water += height[right] - height[i]
                    i -= 1
                right = i
        return water


class Solution1:
    """
    Jun 16, 2025 00:42
    Time Complexity: O(n)
    Space Complexity: O(n)
    """

    def trap(self, height: List[int]) -> int:
        stack = []
        water = 0
        for i in range(len(height)):
            while stack and height[stack[-1]] <= height[i]:
                index = stack.pop()
                if not stack:
                    break

                water += (i - stack[-1] - 1) * (min(height[stack[-1]], height[i]) - height[index])

            stack.append(i)

        return water


if __name__ == '__main__':
    sol = Solution()
    height = [5, 5, 1, 7, 1, 1, 5, 2, 7, 6]
    print(sol.trap(height))
