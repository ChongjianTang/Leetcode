class Solution:
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
