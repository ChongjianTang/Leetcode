from typing import List


class Solution:
    """
    Nov 03, 2024 18:38
    Time Complexity: O(m+n)
    Space Complexity: O(n)
    """

    def sameEndSubstringCount(self, s: str, queries: List[List[int]]) -> List[int]:
        pre_sum = []
        sum_dict = {}
        pre_sum.append(sum_dict.copy())
        for i in range(len(s)):
            if s[i] not in sum_dict:
                sum_dict[s[i]] = 1
            else:
                sum_dict[s[i]] += 1

            pre_sum.append(sum_dict.copy())

        result = []
        for query in queries:
            count = 0
            for char in sum_dict.keys():
                if char in pre_sum[query[0]]:
                    first = pre_sum[query[0]][char]
                else:
                    first = 0

                if char in pre_sum[query[1] + 1]:
                    last = pre_sum[query[1] + 1][char]
                else:
                    last = 0
                diff = last - first + 1
                if diff > 0:
                    count += int(diff * (diff - 1) / 2)

            result.append(count)

        return result


if __name__ == '__main__':
    solution = Solution()
    s = "abcaab"
    queries = [[0, 0], [1, 4], [2, 5], [0, 5]]
    print(solution.sameEndSubstringCount(s, queries))
