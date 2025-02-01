# The guess API is already defined for you.
# @param num, your guess
# @return -1 if num is higher than the picked number
#          1 if num is lower than the picked number
#          otherwise return 0

answer = 0


def guess(num: int) -> int:
    if num == answer:
        return 0
    elif num > answer:
        return -1
    else:
        return 1


class Solution:
    """
    Jan 31, 2025 15:58
    Time Complexity: O(logn)
    Space Complexity: O(1)
    """

    def guessNumber(self, n: int) -> int:
        low = 1
        high = n
        mid = (low + high) // 2

        guess_result = guess(mid)

        while guess_result != 0:
            if guess_result == -1:
                high = mid - 1
            else:
                low = mid + 1

            if low == high:
                return low
            elif low + 1 == high:
                if guess(low) == 0:
                    return low
                else:
                    return high

            mid = (low + high) // 2
            guess_result = guess(mid)

        return mid


if __name__ == '__main__':
    sol = Solution()
    answer = 6
    print(sol.guessNumber(10))
