"""
Alice is attempting to type a specific string on her computer. However, she tends to be clumsy and may press a key for too long, resulting in a character being typed multiple times.

You are given a string word, which represents the final output displayed on Alice's screen. You are also given a positive integer k.

Return the total number of possible original strings that Alice might have intended to type, if she was trying to type a string of size at least k.

Since the answer may be very large, return it modulo 10**9 + 7.



Example 1:

Input: word = "aabbccdd", k = 7

Output: 5

Explanation:

The possible strings are: "aabbccdd", "aabbccd", "aabbcdd", "aabccdd", and "abbccdd".

Example 2:

Input: word = "aabbccdd", k = 8

Output: 1

Explanation:

The only possible string is "aabbccdd".

Example 3:

Input: word = "aaabbb", k = 3

Output: 8



Constraints:

1 <= word.length <= 5 * 105
word consists only of lowercase English letters.
1 <= k <= 2000
"""

"""
22

00 01 02 02 01 11 21 12
aaabbb aabbb abbb aaab aaabb aabb abb aab

||1 1 1
|1|1 1
|1 1|1

1||1 1
1|1|1
1|1 1|

1 1||1
1 1|1|

"""
class Solution:
    """
    TLE
    DP
    """
    def possibleStringCount(self, word: str, k: int) -> int:
        mod = 10 ** 9 + 7
        freq = []

        capacity = len(word) - k
        count = 0
        for i in range(1, len(word)):
            if word[i] == word[i - 1]:
                count += 1
            else:
                freq.append(count)
                count = 0

        freq.append(count)
        dp = [0] * (capacity + 1)
        dp[0] = 1
        for f in freq:
            for i in range(capacity, 0, -1):
                for j in range(1, min(f, i) + 1):
                    dp[i] += dp[i - j]
                    dp[i] %= mod

        result = 0
        for val in dp:
            result += val
            result %= mod

        return result


class Solution1:
    """
    TLE
    DP
    """
    def possibleStringCount(self, word: str, k: int) -> int:
        mod = 10 ** 9 + 7
        freq = []

        capacity = len(word) - k
        count = 0
        for i in range(1, len(word)):
            if word[i] == word[i - 1]:
                count += 1
            else:
                freq.append(count)
                count = 0

        freq.append(count)
        dp = [0] * (capacity + 1)
        dp[0] = 1
        for f in freq:
            for i in range(capacity, 0, -1):
                for j in range(1, min(f, i) + 1):
                    dp[i] += dp[i - j]
                    dp[i] %= mod

        result = 0
        for val in dp:
            result += val
            result %= mod

        return result


if __name__ == '__main__':
    obj = Solution()
    word = "aaabbb"
    k = 3
    print(obj.possibleStringCount(word, k))
