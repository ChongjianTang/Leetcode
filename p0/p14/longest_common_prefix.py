"""
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".



Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.


Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters if it is non-empty.
"""
from typing import List


class Solution:
    """
    Jun 24, 2025 13:23
    Time Complexity: O(n)
    Space Complexity: O(1)
    """

    def longestCommonPrefix(self, strs: List[str]) -> str:
        result = ""
        i = 0
        c = ""
        while True:
            for s in strs:
                if i >= len(s):
                    return result
                if not c:
                    c = s[i]
                else:
                    if s[i] != c:
                        return result
            result += c
            c = ""
            i += 1


if __name__ == '__main__':
    sol = Solution()
    strs = ["dog", "racecar", "car"]
    print(sol.longestCommonPrefix(strs))
    strs = ["flower", "flow", "flight"]
    print(sol.longestCommonPrefix(strs))
