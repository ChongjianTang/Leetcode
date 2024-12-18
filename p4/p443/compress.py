from typing import List


class Solution:
    """
    Dec 17, 2024 14:32
    Time Complexity: O(n)
    Space Complexity: O(1)
    """

    def compress(self, chars: List[str]) -> int:
        count = 1
        index = 1
        for i in range(1, len(chars)):
            if chars[i] == chars[i - 1]:
                count += 1
            else:
                if count > 1:
                    for x in str(count):
                        chars[index] = x
                        index += 1
                chars[index] = chars[i]
                count = 1
                index += 1

        if count > 1:
            for x in str(count):
                chars[index] = x
                index += 1

        del chars[index:]
        return len(chars)
