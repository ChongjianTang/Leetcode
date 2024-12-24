from typing import List


class Solution:
    """
    Dec 23, 2024 16:24
    Time Complexity: O(n)
    Space complexity: O(n)
    """
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        stack = []
        for asteroid in asteroids:
            if not stack:
                stack.append(asteroid)
            else:
                if stack[-1] > 0 > asteroid:
                    while stack and 0 < stack[-1] < -asteroid:
                        stack.pop()
                    if not stack or stack[-1] < 0:
                        stack.append(asteroid)
                    elif stack[-1] == -asteroid:
                        stack.pop()
                else:
                    stack.append(asteroid)

        return stack


if __name__ == '__main__':
    s = Solution()
    print(s.asteroidCollision([-2, -2, 1, -2]))
