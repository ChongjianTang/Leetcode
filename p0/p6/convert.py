"""
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);


Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
Example 3:

Input: s = "A", numRows = 1
Output: "A"


Constraints:

1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000
"""

"""
1   5   9
2 4 6 8 10
3   7   


0   8     16
1 7 9  15
2 6 10 14
3 5 11 13
4   12
 
"""


class Solution:
    """
    Jul 01, 2025 17:12
    Time Complexity: O(n)
    Space Complexity: O(1)
    """

    def convert(self, s: str, numRows: int) -> str:
        if numRows == 1:
            return s
        result = ""
        n = 0
        while n < len(s):
            result += s[n]
            n += 2 * numRows - 2
        for i in range(1, numRows - 1):
            n = i
            while n < len(s):
                result += s[n]
                n += 2 * numRows - 2
                if n - 2 * i < len(s):
                    result += s[n - 2 * i]

        n = numRows - 1
        while n < len(s):
            result += s[n]
            n += 2 * numRows - 2

        return result


if __name__ == '__main__':
    obj = Solution()
    s = "A"
    numRows = 1
    print(obj.convert(s, numRows))
    s = "PAYPALISHIRING"
    numRows = 3
    print(obj.convert(s, numRows))
