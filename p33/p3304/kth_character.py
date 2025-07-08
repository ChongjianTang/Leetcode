"""
Alice and Bob are playing a game. Initially, Alice has a string word = "a".

You are given a positive integer k.

Now Bob will ask Alice to perform the following operation forever:

Generate a new string by changing each character in word to its next character in the English alphabet, and append it to the original word.
For example, performing the operation on "c" generates "cd" and performing the operation on "zb" generates "zbac".

Return the value of the kth character in word, after enough operations have been done for word to have at least k characters.

Note that the character 'z' can be changed to 'a' in the operation.



Example 1:

Input: k = 5

Output: "b"

Explanation:

Initially, word = "a". We need to do the operation three times:

Generated string is "b", word becomes "ab".
Generated string is "bc", word becomes "abbc".
Generated string is "bccd", word becomes "abbcbccd".
Example 2:

Input: k = 10

Output: "c"



Constraints:

1 <= k <= 500
"""

"""
abbcbccd

a
ab
abbc
abbcbccd
abbcbccdbccdcdde

1
12
1223
12232334
23343445
1223233423343445
2334344534454556
12232334233434452334344534454556
"""


class Solution:
    """
    Jul 03, 2025 15:53
    Time Complexity:O(logk)
    Space Complexity: O(1)
    """

    def kthCharacter(self, k: int) -> str:
        num = bin(k - 1).count('1')
        return chr(ord('a') + num)


class Solution1:
    """
    Jul 03, 2025 15:18
    Time Complexity:O(k)
    Space Complexity: O(k)
    """

    def kthCharacter(self, k: int) -> str:
        s = "a"
        while len(s) < k:
            length = len(s)
            for i in range(length):
                if s[i] == 'z':
                    s += 'a'
                else:
                    s += chr(ord(s[i]) + 1)

        return s[k - 1]


if __name__ == '__main__':
    obj = Solution()
    print(obj.kthCharacter(5))
