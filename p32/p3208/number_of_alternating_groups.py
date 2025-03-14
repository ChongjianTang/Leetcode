from typing import List


class Solution:
    """
    Mar 08, 2025 23:19
    """
    def numberOfAlternatingGroups(self, colors: List[int], k: int) -> int:
        left = right = 0
        n = len(colors)
        count = 0
        while left < n or right < n:
            right += 1
            if colors[(right - 1) % n] + colors[right % n] == 1:
                if right - left + 1 == k:
                    count += 1
                elif right - left + 1 > k:
                    left = left + 1
                    if left >= n and right >= n:
                        break
                    count += 1
            else:
                left = right

        return count


if __name__ == '__main__':
    obj = Solution()
    print(obj.numberOfAlternatingGroups([0, 1, 1], 3))
    print(obj.numberOfAlternatingGroups([0, 1, 0, 1], 3))
