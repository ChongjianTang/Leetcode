from collections import Counter
from os import cpu_count


class Solution:
    """
    Feb 17, 2025 15:07
    k - len(input_list)
    m - max frequencies
    Time Complexity: O((m+1)^k*k^2*logk)
    Space Complexity: O
    """

    def numTilePossibilities(self, tiles: str) -> int:
        counter = Counter(tiles)
        result_dict = {}
        frequencies = counter.values()
        return self.helper(list(frequencies), result_dict)

    def helper(self, input_list, result_dict) -> int:
        key = tuple(sorted(input_list))
        if key in result_dict:
            return result_dict[key]

        count = 0
        for i in range(len(input_list)):
            if input_list[i] > 0:
                input_list[i] -= 1
                count += (self.helper(input_list, result_dict) + 1)
                input_list[i] += 1

        result_dict[key] = count
        return count


if __name__ == '__main__':
    obj = Solution()
    print(obj.numTilePossibilities("AAB"))
