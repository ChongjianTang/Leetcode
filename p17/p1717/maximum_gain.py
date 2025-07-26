"""
You are given a string s and two integers x and y. You can perform two types of operations any number of times.

Remove substring "ab" and gain x points.
For example, when removing "ab" from "cabxbae" it becomes "cxbae".
Remove substring "ba" and gain y points.
For example, when removing "ba" from "cabxbae" it becomes "cabxe".
Return the maximum points you can gain after applying the above operations on s.



Example 1:

Input: s = "cdbcbbaaabab", x = 4, y = 5
Output: 19
Explanation:
- Remove the "ba" underlined in "cdbcbbaaabab". Now, s = "cdbcbbaaab" and 5 points are added to the score.
- Remove the "ab" underlined in "cdbcbbaaab". Now, s = "cdbcbbaa" and 4 points are added to the score.
- Remove the "ba" underlined in "cdbcbbaa". Now, s = "cdbcba" and 5 points are added to the score.
- Remove the "ba" underlined in "cdbcba". Now, s = "cdbc" and 5 points are added to the score.
Total score = 5 + 4 + 5 + 5 = 19.
Example 2:

Input: s = "aabbaaxybbaabb", x = 5, y = 4
Output: 20


Constraints:

1 <= s.length <= 105
1 <= x, y <= 104
s consists of lowercase English letters.
"""


class Solution:
    """
    Jul 23, 2025 15:56
    Time Complexity: O(n)
    Space Complexity: O(1)
    """

    def maximumGain(self, s: str, x: int, y: int) -> int:
        if x > y:
            target = 'b'
        else:
            target = 'a'
            x, y = y, x

        total = 0
        stack = []
        for input_str in s:
            for c in input_str:
                if c == 'a' or c == 'b':
                    if c == target and stack and stack[-1] != target:
                        total += x
                        stack.pop()
                    else:
                        stack.append(c)
                else:
                    next_stack = []
                    for c in stack:
                        if c != target and next_stack and next_stack[-1] == target:
                            total += y
                            next_stack.pop()
                        else:
                            next_stack.append(c)
                    stack = []

        next_stack = []
        for c in stack:
            if c != target and next_stack and next_stack[-1] == target:
                total += y
                next_stack.pop()
            else:
                next_stack.append(c)

        return total


class Solution1:
    """
    TLE
    DP
    """

    def maximumGain(self, s: str, x: int, y: int) -> int:
        input_list = []
        temp = []
        for c in s:
            if c == "a" or c == "b":
                temp.append(c)
            else:
                if temp and len(temp) >= 2:
                    input_list.append("".join(temp))
                temp = []
        if temp and len(temp) >= 2:
            input_list.append("".join(temp))

        dp = {"ab": x, "ba": y}
        total = 0
        for input_str in input_list:
            total += self.find_gain(dp, input_str)
        return total

    def find_gain(self, dp: dict, s: str):
        if s in dp:
            return dp[s]

        if len(s) <= 2:
            return 0

        max_gain = 0
        for i in range(1, len(s)):
            if s[i - 1] == "a" and s[i] == "b":
                max_gain = max(max_gain, self.find_gain(dp, s[:i - 1] + s[i + 1:]) + dp['ab'])
            elif s[i - 1] == "b" and s[i] == "a":
                max_gain = max(max_gain, self.find_gain(dp, s[:i - 1] + s[i + 1:]) + dp['ba'])

        dp[s] = max_gain
        return max_gain


if __name__ == '__main__':
    obj = Solution()
    s = "aabbaaxybbaabb"
    x = 5
    y = 4
    print(obj.maximumGain(s, x, y))
    s = "cdbcbbaaabab"
    x = 4
    y = 5
    print(obj.maximumGain(s, x, y))
