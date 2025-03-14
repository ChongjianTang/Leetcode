from typing import List


class Solution:
    """
    Mar 06, 2025 17:16
    """
    def closestPrimes(self, left: int, right: int) -> List[int]:
        is_prime = [True] * (right + 1)
        is_prime[0] = is_prime[1] = False

        index = 2
        while index <= right:
            i = 2
            num_to_remove = index * i
            while num_to_remove <= right:
                is_prime[num_to_remove] = False
                i += 1
                num_to_remove = index * i

            index += 1
            while index <= right and not is_prime[index]:
                index += 1

        first = -1
        second = -1
        gap = [-1, -1]
        for i in range(left, right + 1):
            if is_prime[i]:
                if first == -1:
                    first = i
                elif second == -1:
                    second = i
                    gap = [first, second]
                else:
                    first = second
                    second = i
                    if gap[1] - gap[0] > second - first:
                        gap = [first, second]

        return gap


if __name__ == '__main__':
    obj = Solution()
    print(obj.closestPrimes(10, 19))
