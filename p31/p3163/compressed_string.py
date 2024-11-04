class Solution:
    """
    Nov 03, 2024 17:51
    Time Complexity: O(n)
    Space Complexity: O(n)
    """

    def compressedString(self, word: str) -> str:
        count = 0
        char = ""
        comp = []
        for i in range(len(word)):
            if char != word[i]:
                if count != 0:
                    comp.append(str(count))
                    comp.append(char)
                count = 1
                char = word[i]
            else:
                count += 1
                if count == 9:
                    if count != 0:
                        comp.append(str(count))
                        comp.append(char)
                    count = 0
                    char = ""

        if count != 0:
            comp.append(str(count))
            comp.append(char)

        return "".join(comp)


if __name__ == '__main__':
    s = Solution()
    print(s.compressedString("abcde"))
