class Solution:
    """
    Nov 03, 2024 19:12
    Time Complexity: O(n)
    Space Complexity: O(1)
    """

    def reverseVowels(self, s: str) -> str:
        vowels = ['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U']

        s = list(s)
        i = 0
        j = len(s) - 1

        while i < j:
            while i < j and s[i] not in vowels:
                i += 1
            while i < j and s[j] not in vowels:
                j -= 1

            s[i], s[j] = s[j], s[i]
            i += 1
            j -= 1

        return "".join(s)


if __name__ == '__main__':
    sol = Solution()
    s = "Ui"

    print(sol.reverseVowels(s))
