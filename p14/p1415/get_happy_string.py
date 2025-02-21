class Solution:
    """
    Feb 19, 2025 12:18
    Time Complexity: O(n)
    Space Complexity: O(1)
    """
    def getHappyString(self, n: int, k: int) -> str:
        if k > 3 * pow(2, n - 1):
            return ""
        binary_num = format(k - 1, f'0{n}b')
        chars = []

        if len(binary_num) > n:
            chars.append("c")
            binary_num = binary_num[2:]
        else:
            if binary_num[0] == '0':
                chars.append("a")
            else:
                chars.append("b")
            binary_num = binary_num[1:]

        for char in binary_num:
            if char == "0":
                if chars[-1] == "a":
                    chars.append("b")
                else:
                    chars.append("a")
            else:
                if chars[-1] == "c":
                    chars.append("b")
                else:
                    chars.append("c")

        return "".join(chars)

if __name__ == '__main__':
    obj = Solution()
    print(obj.getHappyString(6,57))