"""
Alice is attempting to type a specific string on her computer. However, she tends to be clumsy and may press a key for too long, resulting in a character being typed multiple times.

Although Alice tried to focus on her typing, she is aware that she may still have done this at most once.

You are given a string word, which represents the final output displayed on Alice's screen.

Return the total number of possible original strings that Alice might have intended to type.



Example 1:

Input: word = "abbcccc"

Output: 5

Explanation:

The possible strings are: "abbcccc", "abbccc", "abbcc", "abbc", and "abcccc".

Example 2:

Input: word = "abcd"

Output: 1

Explanation:

The only possible string is "abcd".

Example 3:

Input: word = "aaaa"

Output: 4



Constraints:

1 <= word.length <= 100
word consists only of lowercase English letters.
"""


class Solution:
    """
    Jul 01, 2025 11:11
    Time Complexity: O(n)
    Space Complexity: O(1)
    """

    def possibleStringCount(self, word: str) -> int:
        total = 1
        count = 1
        for i in range(1, len(word)):
            if word[i] == word[i - 1]:
                count += 1
            else:
                total += count - 1
                count = 1

        total += count - 1
        return total


if __name__ == '__main__':
    obj = Solution()
    word = "aaaa"
    print(obj.possibleStringCount(word))
    word = "abbcccc"
    print(obj.possibleStringCount(word))
