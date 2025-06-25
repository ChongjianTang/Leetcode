"""
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.



Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.


Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.
"""
import re


class Solution:
    """
    Jun 24, 2025 13:30
    Time Complexity: O(n)
    Space Complexity: O(n)
    """

    def isPalindrome(self, s: str) -> bool:
        result = re.sub(r'[^a-zA-Z0-9]', '', s)
        result = result.lower()

        left = 0
        right = len(result) - 1
        while left < right:
            if result[left] != result[right]:
                return False
            left += 1
            right -= 1

        return True


if __name__ == '__main__':
    sol = Solution()
    s = "0P"
    print(sol.isPalindrome(s))
    s = "A man, a plan, a canal: Panama"
    print(sol.isPalindrome(s))
