from typing import List


class Solution:
    """
    Nov 03, 2024 18:59
    Time Complexity: O(n)
    Space Complexity: O(1)
    """

    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        count = 1
        result = 0
        flowerbed.append(0)
        for bed in flowerbed:
            if bed == 1:
                if count != 0:
                    result += (count - 1) // 2
                    if result >= n:
                        return True
                count = 0
            else:
                count += 1
        if count != 0:
            result += (count - 1) // 2
            if result >= n:
                return True

        return False


if __name__ == '__main__':
    s = Solution()
    flowerbed = [1, 0, 0, 0, 1]
    n = 1
    print(s.canPlaceFlowers(flowerbed, n))
