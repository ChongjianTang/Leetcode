class Solution:
    """
    Oct 19, 2024 23:41
    Time Complexity: O(n)
    Space Complexity: O(n)
    """
    def mergeAlternately(self, word1: str, word2: str) -> str:
        result = []

        for char1, char2 in zip(word1, word2):
            result.append(char1)
            result.append(char2)

        if len(word1) > len(word2):
            result.append(word1[len(word2):])
        else:
            result.append(word2[len(word1):])

        return "".join(result)


if __name__ == '__main__':
    s = Solution()
    s.mergeAlternately("1234", "abdfawfawf")
