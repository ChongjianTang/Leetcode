import math
from typing import List


class Solution:
    """
    Nov 11, 2024 17:07
    Time Complexity: ?
    """
    def primeSubOperation(self, nums: List[int]) -> bool:
        for i in range(len(nums)):
            if i == 0:
                prev = 0
            else:
                prev = nums[i - 1]

            if nums[i] <= prev:
                return False
            else:
                diff = nums[i] - prev
                if diff == 2 or diff == 1:
                    pass
                elif diff == 3:
                    nums[i] -= 2
                else:
                    if diff % 2 == 0:
                        start = diff - 1
                    else:
                        start = diff - 2

                    while start >= 3:
                        if self.is_prime_num(start):
                            nums[i] -= start
                            start = -1
                        else:
                            start -= 2
        return True

    def is_prime_num(self, num):
        for i in range(3, int(math.sqrt(num)) + 1, 2):
            if num % i == 0:
                return False

        return True


if __name__ == '__main__':
    sol = Solution()

    nums = [998, 2]

    print(sol.primeSubOperation(nums))
