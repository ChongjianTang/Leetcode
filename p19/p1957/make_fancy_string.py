"""
A fancy string is a string where no three consecutive characters are equal.

Given a string s, delete the minimum possible number of characters from s to make it fancy.

Return the final string after the deletion. It can be shown that the answer will always be unique.



Example 1:

Input: s = "leeetcode"
Output: "leetcode"
Explanation:
Remove an 'e' from the first group of 'e's to create "leetcode".
No three consecutive characters are equal, so return "leetcode".
Example 2:

Input: s = "aaabaaaa"
Output: "aabaa"
Explanation:
Remove an 'a' from the first group of 'a's to create "aabaaaa".
Remove two 'a's from the second group of 'a's to create "aabaa".
No three consecutive characters are equal, so return "aabaa".
Example 3:

Input: s = "aab"
Output: "aab"
Explanation: No three consecutive characters are equal, so return "aab".


Constraints:

1 <= s.length <= 105
s consists only of lowercase English letters.
"""


class Solution:
    """
    Jul 20, 2025 17:24
    Time Complexity: O(n)
    Space Complexity: O(n)
    """

    def makeFancyString(self, s: str) -> str:
        result = [s[0]]
        count = 1
        for i in range(1, len(s)):
            if s[i] != s[i - 1]:
                count = 1
                result.append(s[i])
            else:
                if count != 2:
                    count += 1
                    result.append(s[i])
        return "".join(result)


class Solution1:
    """
    Nov 01, 2024 15:33
    Time Complexity: O(n)
    Space Complexity: O(n)
    """

    def makeFancyString(self, s: str) -> str:
        result = []
        count = 1

        result.append(s[0])
        for i in range(1, len(s)):
            if s[i] == s[i - 1]:
                if count != 2:
                    result.append(s[i])
                    count += 1
            else:
                count = 1
                result.append(s[i])

        return "".join(result)


if __name__ == '__main__':
    obj = Solution()
    s = "aaabaaaa"
    print(obj.makeFancyString(s))

    s = "leeetcode"
    print(obj.makeFancyString(s))
